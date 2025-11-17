package com.example.obligatorioPeajes.cotroladores;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.obligatorioPeajes.modelo.Administrador;
import com.example.obligatorioPeajes.modelo.Propietario;
import com.example.obligatorioPeajes.modelo.Sesion;
import com.example.obligatorioPeajes.utils.Respuesta;
import com.example.obligatorioPeajes.servicios.fachada.Fachada;
import com.example.obligatorioPeajes.excepciones.UsuarioException;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/acceso")
public class ControladorLogin {
    private Fachada fachada = Fachada.getInstance();
    @PostMapping("/ingresoPropietario")
    public List<Respuesta> ingresoPropietario(HttpSession session, @RequestParam String cedula, @RequestParam String contrasenia) 
        throws UsuarioException {
            Sesion sesionCreada = fachada.login(cedula, contrasenia);
            Propietario propietarioLogueado = (Propietario)sesionCreada.getUsuario();
            session.setAttribute("sesion", sesionCreada);
            Respuesta datosPropietario = new Respuesta("datosPropietario", propietarioLogueado.getNombreCompleto());
            //respuesta de exito
            return Respuesta.lista(new Respuesta("loginExitoso", "TableroPropietario"), datosPropietario);
    }
    @PostMapping("/logout")
    public List<Respuesta> logout(HttpSession sesionHttp) {
        Sesion sesion = (Sesion) sesionHttp.getAttribute("sesion");
        if (sesion != null) {
            fachada.logout(sesion);
            sesionHttp.removeAttribute("sesion");
        }
        return Respuesta.lista(new Respuesta("usuarioNoLogueado", "index.html"));
    }
    
    @PostMapping("path")
    public List<Respuesta> ingresoAdministrador(HttpSession session, @RequestParam String cedula, @RequestParam String contrasenia) 
    throws UsuarioException {
        Administrador adminLogueado = fachada.loginAdministrador(cedula, contrasenia);
        session.setAttribute("adminLogueado", adminLogueado);
        Respuesta datosAdmin = new Respuesta("datosAdministrador", adminLogueado.getNombreCompleto());
        return Respuesta.lista(new Respuesta("loginExitoso", "PanelAdmin"), datosAdmin);
    }
    
    
}
