package com.example.obligatorioPeajes.modelo;

public interface EstadoPropietario {
	public abstract boolean esDeshabilitado();

	public abstract boolean puedeAsignarBonificacion();

	public abstract boolean puedeAplicarBonificacion();

	public abstract boolean puedeRecibirNotificaciones();

	public abstract boolean puedeRealizarTransito();

}
