package com.example.obligatorioPeajes.modelo;

public class Penalizado implements EstadoPropietario {

	public static Penalizado instancia;
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


    public static EstadoPropietario getInstancia() {
       if (instancia == null) {
            instancia = new Penalizado();
    	}
        return instancia;
    }

}
