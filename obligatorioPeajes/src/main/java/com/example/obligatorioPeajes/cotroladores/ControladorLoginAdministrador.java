package com.example.obligatorioPeajes.cotroladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.obligatorioPeajes.excepciones.UsuarioException;
import com.example.obligatorioPeajes.modelo.Sesion;
import com.example.obligatorioPeajes.modelo.Usuario;
import com.example.obligatorioPeajes.servicios.fachada.Fachada;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/accesoAdministrador")
public class ControladorLoginAdministrador extends ControladorLoginAbstracto {

    private static final String USUARIO_ADMINISTRADOR_STATE_KEY = "USUARIO_ADMINISTRADOR_STATE_KEY";

    @Override
    protected String getDestinoLoginExitoso() {
        return "emularTransito.html";
    }

    @Override
    protected Usuario getUsuario(String cedula, String contrasenia) throws UsuarioException {
        return Fachada.getInstance().loginAdministrador(cedula, contrasenia);
    }

    @Override
    protected String getDestinoLogoutExitoso() {
        return "login.html";
    }

    @Override
    protected void guardarEstadoUsuarioEnSesion(Usuario usuario, HttpSession sesionHttp) throws UsuarioException {
        Sesion sesion = Fachada.getInstance().login(usuario.getCedula(), usuario.getContrasenia(), "ADMINISTRADOR");
        sesionHttp.setAttribute(USUARIO_ADMINISTRADOR_STATE_KEY, sesion);
    }

    @Override
    protected void eliminarSesion(HttpSession sesion) {
        sesion.removeAttribute(USUARIO_ADMINISTRADOR_STATE_KEY);
        sesion.invalidate();
    }

    @Override
    protected Usuario getEstadoUsuario(HttpSession sesion) {
        Object attr = sesion.getAttribute(USUARIO_ADMINISTRADOR_STATE_KEY);
        if (attr == null) {
            return null;
        }
        if (attr instanceof Sesion) {
            return ((Sesion) attr).getUsuario();
        }
        if (attr instanceof Usuario) {
            return (Usuario) attr;
        }
        return null;
    }
}