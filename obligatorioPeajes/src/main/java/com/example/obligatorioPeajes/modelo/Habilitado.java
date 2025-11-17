package com.example.obligatorioPeajes.modelo;

public class Habilitado implements EstadoPropietario {

	/**
	 * @see EstadoPropietario#puedeAsignarBonificacion()
	 */
	public boolean puedeAsignarBonificacion() {
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

	public static EstadoPropietario getInstancia() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getInstancia'");
	}

}
