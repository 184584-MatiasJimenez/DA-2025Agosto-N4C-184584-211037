package com.example.obligatorioPeajes.servicios;
import com.example.obligatorioPeajes.modelo.*;

import java.util.Collection;

public class ServicioUsuario {

	private static ServicioUsuario instancia;
    private Usuario usuarioLogueado;
	private Collection<Usuario> usuarios;
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
    public boolean iniciarSesion(String cedula, String contrasenia) {
        Usuario usuario = this.validarCredenciales(cedula, contrasenia);
        if(usuario != null) {
            this.usuarioLogueado = usuario;
            return true;
        }
        return false;
    }
	public void registrarLogout() {
        this.usuarioLogueado = null;
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
        for(Usuario usuario : usuarios) {
            if(usuario.getCedula().equals(ci)) {
                return usuario;
            }
        }
        return null;
    }

    public Propietario buscarPropietarioPorCI(String ci) {
        Usuario usuario = this.buscarUsuarioPorCI(ci);
        if(usuario != null && usuario instanceof Propietario) {
            return (Propietario) usuario;
        }
        return null;
    }

	public void agregarVehiculo(Propietario propietario, String matricula,
	 String marca, String modelo,String color, int anio, CategoriaVehiculo categoria) {

		Vehiculo nuevoVehiculo = null;

		if(categoria.getNombre().equals("Automóvil")) {
			nuevoVehiculo = new Auto(matricula, marca, modelo, color, anio, propietario);
		} else if(categoria.getNombre().equals("Camioneta")) {
			nuevoVehiculo = new Camioneta(matricula, marca, modelo, color, anio, propietario);
		} else if(categoria.getNombre().equals("Moto")) {
			nuevoVehiculo = new Moto(matricula, marca, modelo, color, anio, propietario);
		}

		if(nuevoVehiculo != null) {
			propietario.agregarVehiculo(nuevoVehiculo);
		}
	}
}
