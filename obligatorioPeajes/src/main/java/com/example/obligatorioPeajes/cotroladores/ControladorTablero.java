package com.example.obligatorioPeajes.cotroladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.http.MediaType;
import com.example.obligatorioPeajes.modelo.Sesion;
import com.example.obligatorioPeajes.utils.Respuesta;
import com.example.obligatorioPeajes.utils.ConexionNavegador;

@RestController
@RequestMapping("/menuTablero")
@Scope("session")
public class ControladorTablero {

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
    public List<Respuesta> inicializarVista(@SessionAttribute(name = "sesion", required = false) Sesion sesion) {
        if (sesion == null) {
            // Manejar el caso en que el usuario no está en la sesión pide redireccionar a
            // la página de login
            return Respuesta.lista(new Respuesta("usuarioNoAutenticado", "loginPropietario.html"));
        }
        return Respuesta.lista(new Respuesta("nombreCompleto", sesion.getUsuario().getNombreCompleto()));

    }

}
