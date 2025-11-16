package com.example.obligatorioPeajes.modelo;

import java.util.Collection;

public class SistemaUsuario {

	private static SistemaUsuario instancia;

	private Collection<Administrador> administradores;
	private Collection<Propietario> propietarios;
    private EstadoPropietario estadoHabilitado;
    private EstadoPropietario estadoDeshabilitado;
    private EstadoPropietario estadoSuspendido;
    private EstadoPropietario estadoPenalizado;


	public static SistemaUsuario getInstancia() {
		if (instancia == null) {
			instancia = new SistemaUsuario();
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
		return null;
	}

	public void registrarLogout(String cedula) {

	}

	public void agregarPropietario(String cedula, String nombreCompleto, String contrasenia, double SaldoActual,
	double saldoMinimoAlerta) {
		 Propietario propietario = new Propietario(cedula, nombreCompleto, contrasenia, SaldoActual, saldoMinimoAlerta);
		 this.propietarios.add(propietario);
	}

	public void agregarAdministrador(String cedula, String nombreCompleto, String contrasenia) {
		 Administrador administrador = new Administrador(cedula, nombreCompleto, contrasenia);
		 this.administradores.add(administrador);
	}

	public Propietario buscarPropietarioPorCI(String ci) {
		for (Propietario propietario : propietarios) {
			if (propietario.getCedula().equals(ci)) {
				return propietario;
			}
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
