package com.example.obligatorioPeajes.cotroladores;

import java.util.List;

import javax.xml.crypto.dsig.TransformException;


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

import com.example.obligatorioPeajes.modelo.Sesion;
import com.example.obligatorioPeajes.servicios.fachada.Fachada;
import com.example.obligatorioPeajes.utils.ConexionNavegador;
import com.example.obligatorioPeajes.utils.Respuesta;


import com.example.obligatorioPeajes.modelo.Administrador;
import com.example.obligatorioPeajes.modelo.DateTime;
import com.example.obligatorioPeajes.dtos.PuestoDePeajeDTO;
import com.example.obligatorioPeajes.dtos.TransitoDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/emularTransito")
@Scope("session")
public class ControladorEmularTransito {
    private Fachada fachada = Fachada.getInstance();
    private final ConexionNavegador conexionNavegador;

    public ControladorEmularTransito(@Autowired ConexionNavegador conexionNavegador) {
        this.conexionNavegador = conexionNavegador;
    }

    @GetMapping(value = "/registrarSSE", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter registrarSSE() {
        // Establecer la conexión SSE con el navegador en este caso el menú admin
        conexionNavegador.conectarSSE();
        return conexionNavegador.getConexionSSE();
    }

    @GetMapping("/vistaConectada")
    public Respuesta inicializarVista(
            @SessionAttribute(name = "USUARIO_ADMINISTRADOR_STATE_KEY", required = false) Sesion administrador) {
        if (administrador == null) {
            // Manejar el caso en que el usuario no está en la sesión pide redireccionar a
            // la página de login
            return new Respuesta("usuarioNoAutenticado", "login.html");
        }
        return new Respuesta();
    }

    @GetMapping("/puestosDePeaje")
    public List<Respuesta> obtenerPuestosDePeaje(
            @SessionAttribute(name = "USUARIO_ADMINISTRADOR_STATE_KEY", required = false) Sesion administrador) {
        if (administrador == null) {
            return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "login.html"));
        }

        if (!(administrador.getUsuario() instanceof Administrador)) {
            return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "login.html"));
        }

        List<PuestoDePeajeDTO> puestosDePeajes = fachada.obtenerPuestosDePeajes();
        return Respuesta.lista(new Respuesta("listaPuestosDePeaje", puestosDePeajes));
    }

    @PostMapping("/transito")
    public List<Respuesta> registrarTransito(@RequestParam(name = "puesto") String nombrePuestoDePeaje,
            @RequestParam String matricula, @RequestParam String fechaHora) throws TransformException {

        // Parsear la fecha enviada desde el input datetime-local (ej: 2025-11-19T15:30)
        DateTime fechaHoraObj = null;
        try {
            LocalDateTime ldt = LocalDateTime.parse(fechaHora);
            fechaHoraObj = new DateTime(ldt);
        } catch (DateTimeParseException e) {
            return Respuesta.lista(new Respuesta("error", "Formato de fecha inválido"));
        }

        TransitoDTO transitoDTO = fachada.emularTransito(matricula, nombrePuestoDePeaje, fechaHoraObj);
        if (transitoDTO != null && transitoDTO.getMensajeError() != null) {
            String mensaje = transitoDTO.getMensajeError();
            return Respuesta.lista(new Respuesta("error", mensaje));
        }

        return Respuesta.lista(new Respuesta("transito", transitoDTO),
                new Respuesta("mensaje", "Tránsito registrado con éxito"),
                new Respuesta("limpiarFormulario", true));
    }

}
