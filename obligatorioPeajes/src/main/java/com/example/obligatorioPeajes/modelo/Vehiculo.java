package com.example.obligatorioPeajes.modelo;

public abstract class Vehiculo {

	private String matricula;

	private CategoriaVehiculo categoria;

	private String modelo;

	private String color;

	private String marca;

	private int anio;

	private Propietario propietario;

	public Vehiculo(String matricula, String marca, String modelo, String color, int anio, Propietario propietario) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.anio = anio;
		this.propietario = propietario;
	}

	public String getMatricula() {
		return matricula;
	}

	public CategoriaVehiculo getCategoria() {
		return categoria;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAnio() {
		return anio;
	}

	public String getColor() {
		return color;
	}

	public java.util.List<Transito> getTransitos() {
		return null;
	}

}
