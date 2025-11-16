package com.example.obligatorioPeajes.modelo;

import java.util.Collection;
import java.util.ArrayList;

public class Propietario extends Usuario {

	private int id;

	private String nombre;

	private double saldoActual;

	private double saldoMinimoAlerta;

	private EstadoPropietario estado;

	private java.util.List<BonificacionAsignada> bonificacionesAsignadas;

	private java.util.List<Notificacion> notificaciones;

	private Collection<Vehiculo> vehiculos;

	public Propietario(String cedula, String nombreCompleto, String contrasenia,
	 double saldoActual, double saldoMinimoAlerta) {
		super(cedula, nombreCompleto, contrasenia);
		this.saldoActual = saldoActual;
		this.saldoMinimoAlerta = saldoMinimoAlerta;
		this.bonificacionesAsignadas = new ArrayList<>();
		this.notificaciones = new ArrayList<>();
		this.vehiculos = new ArrayList<>();
		this.estado = SistemaUsuario.getInstancia().getEstadoHabilitado();
	}

	public void agregarVehiculo(Vehiculo v) {
		this.vehiculos.add(v);
	}

	public boolean puedeRealizarTransito() {
		return false;
	}

	public boolean puedeRecibirNotifiaciones() {
		return false;
	}

	public void restarSaldo(double monto) {

	}

	public void agregarNotificacion(Notificacion n) {

	}

	public void borrarNotificaciones() {

	}

	public BonificacionAsignada getBonificacionPara(PuestoDePeaje puesto) {
		return null;
	}

	public boolean tieneBonificacionesEn(PuestoDePeaje puesto) {
		return false;
	}

	public void asignarBonificacion(Bonificacion b, PuestoDePeaje puesto) {

	}

    public Object getCedula() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCedula'");
    }


}
