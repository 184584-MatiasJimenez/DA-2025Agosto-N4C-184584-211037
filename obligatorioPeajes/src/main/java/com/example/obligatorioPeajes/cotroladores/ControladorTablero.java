package com.example.obligatorioPeajes.cotroladores;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.http.MediaType;

import com.example.obligatorioPeajes.dtos.BonificacionDTO;
import com.example.obligatorioPeajes.dtos.TransitoDTO;
import com.example.obligatorioPeajes.dtos.VehiculoDTO;
import com.example.obligatorioPeajes.modelo.BonificacionAsignada;
import com.example.obligatorioPeajes.modelo.Propietario;
import com.example.obligatorioPeajes.modelo.Sesion;
import com.example.obligatorioPeajes.modelo.Vehiculo;
import com.example.obligatorioPeajes.servicios.fachada.Fachada;
import com.example.obligatorioPeajes.utils.Respuesta;
import com.example.obligatorioPeajes.utils.ConexionNavegador;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/menuTablero")
@Scope("session")
public class ControladorTablero {
    private Fachada fachada = Fachada.getInstance();
    private final ConexionNavegador conexionNavegador;

    public ControladorTablero(@Autowired ConexionNavegador conexionNavegador) {
        this.conexionNavegador = conexionNavegador;
    }

    @GetMapping(value = "/registrarSSE", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter registrarSSE() {
        // Establecer la conexión SSE con el navegador en este caso el menú admin
        conexionNavegador.conectarSSE();
        return conexionNavegador.getConexionSSE();
    }

    @GetMapping("/vistaConectada")
    public List<Respuesta> inicializarVista(
            @SessionAttribute(name = "USUARIO_PROPIETARIO_STATE_KEY", required = false) Sesion propietario) {
        if (propietario == null) {
            // Manejar el caso en que el usuario no está en la sesión pide redireccionar a
            // la página de login
            return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "login.html"));
        }
        return Respuesta.lista(new Respuesta("nombreCompleto", propietario.getUsuario().getNombreCompleto()));
    }

    @GetMapping("/vehiculosPropietario")
    public List<Respuesta> obtenerVehiculos(
            @SessionAttribute(name = "USUARIO_PROPIETARIO_STATE_KEY", required = false) Sesion propietario) {
        if (propietario == null) {
            return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "login.html"));
        }

        if (!(propietario.getUsuario() instanceof Propietario)) {
            return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "login.html"));
        }

        List<Vehiculo> vehiculos = fachada.obtenerVehiculosPropietario(propietario.getUsuario().getCedula());
        List<VehiculoDTO> vehiculosDto = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            vehiculosDto.add(new VehiculoDTO(vehiculo));
        }
        return Respuesta.lista(new Respuesta("listaVehiculos", vehiculosDto));
    }

    @GetMapping("/bonificacionesPropietario")
    public List<Respuesta> obtenerBonificaciones(
            @SessionAttribute(name = "USUARIO_PROPIETARIO_STATE_KEY", required = false) Sesion propietario) {

            if (propietario == null) {
                return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "login.html"));
            }
            if (!(propietario.getUsuario() instanceof Propietario)) {
                return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "login.html"));
            }
            List<BonificacionDTO> bonificacionesDto = fachada.obtenerBonificacionesPropietario(propietario.getUsuario().getCedula());
            return Respuesta.lista(new Respuesta("listaBonificaciones", bonificacionesDto));
    }

    @GetMapping("/historialTransitos")
    public List<Respuesta> obtenerHistorialTransitos(
        @SessionAttribute(name = "USUARIO_PROPIETARIO_STATE_KEY", required = false) Sesion propietario) {
        if (propietario == null || !(propietario.getUsuario() instanceof Propietario)) {
            return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "login.html"));
        }
        List<TransitoDTO> transitosDto = fachada.obtenerHistorialTransitos(propietario.getUsuario().getCedula());
        return Respuesta.lista(new Respuesta("listaTransitos", transitosDto));
    }
    
}
