package com.example.obligatorioPeajes.modelo;

public class Deshabilitado implements EstadoPropietario {

	public static Deshabilitado instancia;
	/**
	 * @see EstadoPropietario#puedeAsignarBonificacion()
	 */
	public boolean puedeAsignarBonificacion() {
		return false;
	}

	@Override
    public boolean esDeshabilitado() {
        return true; // Solo este estado devuelve true
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
        if (instancia == null) {
            instancia = new Deshabilitado();
        }
        return instancia;
    }

}
