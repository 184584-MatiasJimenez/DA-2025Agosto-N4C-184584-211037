package com.example.obligatorioPeajes.cotroladores;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.obligatorioPeajes.modelo.EstadoPropietario;
import com.example.obligatorioPeajes.modelo.Propietario;
import com.example.obligatorioPeajes.modelo.Sesion;
import com.example.obligatorioPeajes.servicios.fachada.Fachada;
import com.example.obligatorioPeajes.utils.ConexionNavegador;
import com.example.obligatorioPeajes.utils.Respuesta;

@RestController
@RequestMapping("/cambiarEstadoPropietario")
@Scope("session")
public class ControladorCambiarEstadoPropietario {
    private Fachada fachada = Fachada.getInstance();
    private final ConexionNavegador conexionNavegador;

    public ControladorCambiarEstadoPropietario(@Autowired ConexionNavegador conexionNavegador) {
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
            @SessionAttribute(name = "USUARIO_ADMINISTRADOR_STATE_KEY", required = false) Sesion administrador) {
        if (administrador == null) {
            // Manejar el caso en que el usuario no está en la sesión pide redireccionar a
            // la página de login
            return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "login.html"));
        }
        return Respuesta.lista(new Respuesta("nombreCompleto", administrador.getUsuario().getNombreCompleto()));
    }

    @GetMapping("/buscarPropietario")
    public List<Respuesta> buscarPropietario(
            @RequestParam("cedula") String cedula,
            @SessionAttribute(name = "USUARIO_ADMINISTRADOR_STATE_KEY", required = false) Sesion administrador) {
        if (administrador == null) {
            return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "login.html"));
        }
        
        Propietario propietario = fachada.buscarPropietarioPorCI(cedula);
        
        if (propietario == null) {
            return Respuesta.lista(new Respuesta("error", "No existe el propietario con C.I.: " + cedula));
        }

        List<EstadoPropietario> estados = fachada.obtenerListaEstadosPropietario();
        
        String estadosJSON = estados.stream()
                .map(e -> String.format("{\"nombre\": \"%s\", \"value\": \"%s\"}", 
                            e.getClass().getSimpleName(), e.getClass().getSimpleName()))
                .collect(Collectors.joining(",", "[", "]"));
        return Respuesta.lista(
            new Respuesta("nombreCompleto", propietario.getNombreCompleto()),
            new Respuesta("estadoActual", propietario.getEstado().getClass().getSimpleName()),
            new Respuesta("listaEstados", estadosJSON)
        );
    }
    @PostMapping("/cambiarEstado")
    public List<Respuesta> cambiarEstado(
            @RequestParam("cedula") String cedula, 
            @RequestParam("nuevoEstado") String nuevoEstado,
            @SessionAttribute(name = "USUARIO_ADMINISTRADOR_STATE_KEY", required = false) Sesion administrador) {
        
        if (administrador == null) {
            return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "login.html"));
        }
        
        String resultado = fachada.cambiarEstadoPropietario(cedula, nuevoEstado);

        // Se verifica si el resultado es un mensaje de error o el nombre del estado (éxito)
        if (resultado.startsWith("No existe") || resultado.startsWith("El propietario ya esta en estado")) {
            // Curso Alternativo 2 o 5 (el mensaje de error viene del servicio)
            return Respuesta.lista(new Respuesta("error", resultado));
        }
        
        return Respuesta.lista(
            new Respuesta("exito", "Estado cambiado con éxito. Nuevo estado: " + resultado),
            new Respuesta("nuevoEstado", resultado)
        );
    }
    
}