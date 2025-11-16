package com.example.obligatorioPeajes.modelo;

public class EstadoPrimerTransito implements EstadoFrecuente {
    
	@Override
	public double calcularDescuento(Bonificacion b, Transito t) {
		return 0;
	}

}
