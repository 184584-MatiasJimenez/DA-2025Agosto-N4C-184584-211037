package com.example.obligatorioPeajes.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo {

	private String matricula;

	private CategoriaVehiculo categoria;

	private String modelo;

	private String color;

	private String marca;

	private int anio;

	private List<Transito> transitos;

	private Propietario propietario;

	public Vehiculo(String matricula, String marca, String modelo, String color, int anio, Propietario propietario) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.anio = anio;
		this.propietario = propietario;
		this.transitos = new ArrayList<>();
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

	public List<Transito> getTransitos() {
		return transitos;
	}

	public int getCantidadTransitos() {
		return (transitos!= null) ? transitos.size() : 0;
	}

	public double getMontoTotalGastado() {
		if(transitos == null || transitos.isEmpty()) {
			return 0;
		}
		double total =0;
		for (Transito transito : transitos) {
			total += transito.getTarifaBase();//no va tarifa base, va un metodo que calcula segun el tipo de 
		}
		return total;
	}

}
