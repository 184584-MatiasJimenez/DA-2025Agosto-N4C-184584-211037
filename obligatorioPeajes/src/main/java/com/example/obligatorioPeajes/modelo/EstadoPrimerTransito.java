package com.example.obligatorioPeajes.modelo;

public class EstadoPrimerTransito implements EstadoFrecuente {

	@Override
	public double calcularDescuento(Bonificacion bf, Transito t) {
		return 0;
	}

}
