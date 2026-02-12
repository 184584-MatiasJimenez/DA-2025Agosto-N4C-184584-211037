package com.example.obligatorioPeajes.cotroladores;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import com.example.obligatorioPeajes.excepciones.UsuarioException;
import com.example.obligatorioPeajes.modelo.Usuario;
import com.example.obligatorioPeajes.utils.Respuesta;

import jakarta.servlet.http.HttpSession;

public abstract class ControladorLoginAbstracto {
    @PostMapping("login")
    public List<Respuesta> login(HttpSession sesion, String cedula, String contrasenia) throws UsuarioException {
        Usuario usuario = getUsuario(cedula, contrasenia);
        if (usuario != null) {
            guardarEstadoUsuarioEnSesion(usuario, sesion);
            return Respuesta.lista(new Respuesta("Login_exitoso", getDestinoLoginExitoso()));
        } else {
            return Respuesta.lista(new Respuesta("Credenciales_incorrectas", getDestinoLogoutExitoso()));
        }
    }

    protected abstract Usuario getUsuario(String nombreDeUsuario, String password) throws UsuarioException;

    protected abstract void guardarEstadoUsuarioEnSesion(Usuario usuario, HttpSession sesion) throws UsuarioException;

    protected abstract String getDestinoLoginExitoso();

    @PostMapping("logout")
    public List<Respuesta> logout(HttpSession sesion) {
        Usuario usuario = getEstadoUsuario(sesion);
        if (usuario != null) {
            eliminarSesion(sesion);
            return Respuesta.lista(new Respuesta("Logout_exitoso", getDestinoLogoutExitoso()));
        } else {
            return Respuesta.lista(new Respuesta("No_hay_usuario_logueado", getDestinoLogoutExitoso()));
        }
    }

    protected abstract void eliminarSesion(HttpSession sesion);

    protected abstract Usuario getEstadoUsuario(HttpSession sesion);

    protected abstract String getDestinoLogoutExitoso();
}
