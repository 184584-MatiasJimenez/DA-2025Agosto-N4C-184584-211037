package com.example.obligatorioPeajes.modelo;

public class BonificacionExonerado extends Bonificacion {

	public BonificacionExonerado(String nombre) {
		super(nombre);
	}

	public double calcularMontoBonificacion(Transito t) {
		return 0;
	}

	@Override
	public double calcularMontoFijo(Transito t, PuestoDePeaje puesto) {
		return t.getTarifaBase();
	}

}
