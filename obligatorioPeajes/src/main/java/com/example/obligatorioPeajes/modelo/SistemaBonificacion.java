package com.example.obligatorioPeajes.modelo;

import java.util.Collection;

public class SistemaBonificacion {

	private Collection<BonificacionAsignada> bonificacionAsignada;

	private Collection<Bonificacion> bonificacion;

	public void precargarTiposBonificacion() {

	}

	public java.util.List<Bonificacion> obtenerBonificacionesDefinidas() {
		return null;
	}

	public Bonificacion buscarBonificacionPorNombre(String nombre) {
		return null;
	}

	public BonificacionAsignada asignarBonificacion(Propietario propietario, PuestoDePeaje puesto, Bonificacion bonificacion) {
		return null;
	}

	public BonificacionAsignada obtenerBonificacionAsignada(Propietario propietario, PuestoDePeaje puesto) {
		return null;
	}

	public void calcularMontoDescuento(BonificacionAsignada bonificacionAsignada, Transito transito) {

	}

    public static SistemaBonificacion getInstancia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInstancia'");
    }

    public void precargaTiposBonificaciones() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'precargaTiposBonificaciones'");
    }

}
