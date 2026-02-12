package com.example.obligatorioPeajes.modelo;

public class Habilitado implements EstadoPropietario {

	private static Habilitado instancia;
	private Habilitado() {
	}
    public static Habilitado getInstancia() {
        if (instancia == null) {
            instancia = new Habilitado();
        }
        return instancia;
    }
	/**
	 * @see EstadoPropietario#puedeAsignarBonificacion()
	 */
	public boolean puedeAsignarBonificacion() {
		return false;
	}
	@Override
	public boolean esDeshabilitado() {
		return false;
	}
	
	/**
	 * @see EstadoPropietario#puedeAplicarBonificacion()
	 */
	public boolean puedeAplicarBonificacion() {
		return false;
	}

	/**
	 * @see EstadoPropietario#puedeRecibirNotificaciones()
	 */
	public boolean puedeRecibirNotificaciones() {
		return false;
	}

	/**
	 * @see EstadoPropietario#puedeRealizarTransito()
	 */
	public boolean puedeRealizarTransito() {
		return false;
	}

}
