package com.example.obligatorioPeajes.controladores;

public interface EstadoPropietario {

	public abstract boolean puedeAsignarBonificacion();

	public abstract boolean puedeAplicarBonificacion();

	public abstract boolean puedeRecibirNotificaciones();

	public abstract boolean puedeRealizarTransito();

}
