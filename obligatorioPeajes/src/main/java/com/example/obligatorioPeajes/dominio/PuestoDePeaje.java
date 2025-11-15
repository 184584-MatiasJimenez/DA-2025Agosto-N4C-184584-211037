package com.example.obligatorioPeajes.dominio;
import java.util.List;

public class PuestoDePeaje {

	private char nombre;

	private char direccion;

	private List<Transito> listaDeTransitos;

	public Transito registrarTransito(Vehiculo v, DateTime fecha) {
		return null;
	}

	public boolean tuvoTransitoHoy(Vehiculo v) {
		return false;
	}

}
