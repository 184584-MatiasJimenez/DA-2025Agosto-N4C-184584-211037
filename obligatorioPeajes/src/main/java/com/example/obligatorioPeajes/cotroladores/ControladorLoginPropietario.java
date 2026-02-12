package com.example.obligatorioPeajes.cotroladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.obligatorioPeajes.excepciones.UsuarioException;
import com.example.obligatorioPeajes.modelo.Sesion;
import com.example.obligatorioPeajes.modelo.Usuario;
import com.example.obligatorioPeajes.servicios.fachada.Fachada;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/accesoPropietario")
public class ControladorLoginPropietario extends ControladorLoginAbstracto {

    private static final String USUARIO_PROPIETARIO_STATE_KEY = "USUARIO_PROPIETARIO_STATE_KEY";

    @Override
    protected String getDestinoLoginExitoso() {
        return "tableroControlPropietario.html";
    }

    @Override
    protected Usuario getUsuario(String cedula, String contrasenia) throws UsuarioException {
        return Fachada.getInstance().loginPropietario(cedula, contrasenia);
    }

    @Override
    protected String getDestinoLogoutExitoso() {
        return "login.html?rol=PROPIETARIO";
    }

    @Override
    protected void guardarEstadoUsuarioEnSesion(Usuario usuario, HttpSession sesionHttp) throws UsuarioException {
        Sesion sesion = Fachada.getInstance().login(usuario.getCedula(), usuario.getContrasenia(), "PROPIETARIO");
        sesionHttp.setAttribute(USUARIO_PROPIETARIO_STATE_KEY, sesion);
    }

    @Override
    protected void eliminarSesion(HttpSession sesion) {
        sesion.removeAttribute(USUARIO_PROPIETARIO_STATE_KEY);
        sesion.invalidate();
    }

    @Override
    protected Usuario getEstadoUsuario(HttpSession sesion) {
        Object attr = sesion.getAttribute(USUARIO_PROPIETARIO_STATE_KEY);
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
