package com.example.obligatorioPeajes.cotroladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.obligatorioPeajes.modelo.Sesion;
import com.example.obligatorioPeajes.servicios.fachada.Fachada;
import com.example.obligatorioPeajes.utils.ConexionNavegador;
import com.example.obligatorioPeajes.utils.Respuesta;

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
    public List<Respuesta> inicializarVista(
            @SessionAttribute(name = "USUARIO_ADMINISTRADOR_STATE_KEY", required = false) Sesion administrador) {
        if (administrador == null) {
            // Manejar el caso en que el usuario no está en la sesión pide redireccionar a
            // la página de login
            return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "login.html"));
        }
        return Respuesta.lista(new Respuesta("nombreCompleto", administrador.getUsuario().getNombreCompleto()));
    }
}
