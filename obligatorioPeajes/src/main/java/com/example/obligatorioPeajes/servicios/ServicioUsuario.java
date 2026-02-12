package com.example.obligatorioPeajes.servicios;
import com.example.obligatorioPeajes.excepciones.UsuarioException;
import com.example.obligatorioPeajes.modelo.*;
import com.example.obligatorioPeajes.servicios.fachada.Fachada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ServicioUsuario {

    private static ServicioUsuario instancia;
    private Usuario usuarioLogueado;
	private Collection<Usuario> usuarios;
    private ArrayList<Sesion> sesiones = new ArrayList<>();
    private EstadoPropietario estadoHabilitado;
    private EstadoPropietario estadoDeshabilitado;
    private EstadoPropietario estadoSuspendido;
    private EstadoPropietario estadoPenalizado;

    private ServicioUsuario() {
        this.usuarios = new java.util.ArrayList<>();
        this.precargaEstados();
    }

    public static ServicioUsuario getInstancia() {
        if (instancia == null) {
            instancia = new ServicioUsuario();
        }
        return instancia;
    }

    public void precargaEstados() {
        this.estadoHabilitado = Habilitado.getInstancia();
        this.estadoDeshabilitado = Deshabilitado.getInstancia();
        this.estadoSuspendido = Suspendido.getInstancia();
        this.estadoPenalizado = Penalizado.getInstancia();
    }

    public EstadoPropietario getEstadoHabilitado() {
        return this.estadoHabilitado;
    }
    public EstadoPropietario getEstadoDeshabilitado() {
        return this.estadoDeshabilitado;
    }
    public EstadoPropietario getEstadoSuspendido() {
        return this.estadoSuspendido;
    }
    public EstadoPropietario getEstadoPenalizado() {
        return this.estadoPenalizado;
    }

	public Usuario validarCredenciales(String cedula, String contrasenia) {
		Usuario usuario = this.buscarUsuarioPorCI(cedula);
        if(usuario != null && usuario.verificarContrasenia(contrasenia)){
            return usuario;
        }
        return null;
	}

    private Usuario login(String cedula, String contrasenia) throws UsuarioException {
        Usuario usuario = this.validarCredenciales(cedula, contrasenia);
        if(usuario == null) {
            throw new UsuarioException("Acceso denegado");
        }
        this.usuarioLogueado = usuario;
        return usuario;
    }

    public Propietario loginPropietario(String cedula, String contrasenia) throws UsuarioException{
        Usuario usuario = login(cedula, contrasenia);
        if(!(usuario instanceof Propietario propietario)) {
            throw new UsuarioException("El usuario no es un propietario");
        }
		return propietario;
    }
    public Administrador loginAdministrador(String cedula, String contrasenia) throws UsuarioException{
        Usuario usuario = login(cedula, contrasenia);
        if(!(usuario instanceof Administrador administrador)) {
            throw new UsuarioException("El usuario no es un administrador");
        }        
        return administrador;
    }

    public Sesion loginSesion(String cedula, String contrasenia, String rol) throws UsuarioException {
        Sesion nuevaSesion = null;
        Usuario usuario = rol.equals("PROPIETARIO") ? loginPropietario(cedula, contrasenia) : loginAdministrador(cedula, contrasenia);
        if (usuario != null) {
            nuevaSesion = new Sesion(usuario);
            sesiones.add(nuevaSesion);
            Fachada.getInstance().avisar(Fachada.Eventos.nuevoUsuarioConectado);
        } else {
            throw new UsuarioException("Credenciales incorrectas");
        }
        return nuevaSesion;
    }

	public void logout(Sesion s) {
        sesiones.remove(s);
        Fachada.getInstance().avisar(Fachada.Eventos.nuevoUsuarioDesconectado);
	}

    public void agregarPropietario(String cedula, String nombreCompleto, String contrasenia, double SaldoActual,
            double saldoMinimoAlerta) {
        Propietario propietario = new Propietario(cedula, nombreCompleto, contrasenia, SaldoActual, saldoMinimoAlerta);
        this.usuarios.add(propietario);
    }

    public void agregarAdministrador(String cedula, String nombreCompleto, String contrasenia) {
        Administrador administrador = new Administrador(cedula, nombreCompleto, contrasenia);
        this.usuarios.add(administrador);
    }

    public Usuario buscarUsuarioPorCI(String ci) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCedula().equals(ci)) {
                return usuario;
            }
        }
        return null;
    }

    public Propietario buscarPropietarioPorCI(String ci) {
        Usuario usuario = this.buscarUsuarioPorCI(ci);
        if (usuario != null && usuario instanceof Propietario) {
            return (Propietario) usuario;
        }
        return null;
    }

    public void agregarVehiculo(Propietario propietario, String matricula,
            String marca, String modelo, String color, int anio, CategoriaVehiculo categoria) {

        Vehiculo nuevoVehiculo = null;
        String nombreCategoria = categoria.getNombre();

        if (nombreCategoria.equals("Automóvil")) {
            nuevoVehiculo = new Auto(matricula, marca, modelo, color, anio, propietario);
        } else if (nombreCategoria.equals("Camioneta")) {
            nuevoVehiculo = new Camioneta(matricula, marca, modelo, color, anio, propietario);
        } else if (nombreCategoria.equals("Moto")) {
            nuevoVehiculo = new Moto(matricula, marca, modelo, color, anio, propietario);
        }

        if (nuevoVehiculo != null) {
            propietario.agregarVehiculo(nuevoVehiculo);
        }
    }
    
    public List<Vehiculo> obtenerVehiculosPropietario(String ci) {
        Propietario propietario = this.buscarPropietarioPorCI(ci);
        if (propietario != null) {
            return new ArrayList<>(propietario.getVehiculos());
        }
        return new ArrayList<>();
    }

    public Vehiculo buscarVehiculoPorMatricula(String matricula) {
        for (Usuario usuario : this.usuarios) {
            if(usuario instanceof Propietario propietario) {
                Vehiculo vehiculoEncontrado = propietario.buscarVehiculoPorMatricula(matricula);
                if(vehiculoEncontrado != null) {
                    return vehiculoEncontrado;
                }
            }
        }
        return null;
    }
    public EstadoPropietario buscarEstadoPorNombre(String nombreEstado) {
        for(EstadoPropietario estado : obtenerTodosLosEstados()) {
            if(estado.getClass().getSimpleName().equals(nombreEstado)) {
                return estado;
            }
        }
        return null;
    }
    public List<EstadoPropietario> obtenerTodosLosEstados() {
        return Arrays.asList(
            this.estadoHabilitado,
            this.estadoDeshabilitado,
            this.estadoSuspendido,
            this.estadoPenalizado
        );
    }

    public String cambiarEstadoPropietario(String ciPropietario, String nombreNuevoEstado) {
        Propietario propietario = this.buscarPropietarioPorCI(ciPropietario);
        if(propietario == null){
            return "No existe el propietario";
        }
        EstadoPropietario nuevoEstado = this.buscarEstadoPorNombre(nombreNuevoEstado); 
        if(nuevoEstado == null) {
            return "Error: Estado '"+ nombreNuevoEstado + "' no encontrado en el sistema";
        }
        String resultado = propietario.cambiarEstado(nuevoEstado);
        return resultado;
    }
}
