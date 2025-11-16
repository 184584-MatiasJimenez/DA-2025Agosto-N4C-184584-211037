package com.example.obligatorioPeajes.modelo;

public class Tarifa {

	private double monto;

	private CategoriaVehiculo categoria;

	private PuestoDePeaje puesto;

    public Tarifa(PuestoDePeaje puesto, CategoriaVehiculo categoria, double monto) {
        this.puesto = puesto;
        this.categoria = categoria;
        this.monto = monto;
    }
    public double getMonto() {
        return monto;
    }
    public CategoriaVehiculo getCategoria() {
        return categoria;
    }
    public PuestoDePeaje getPuesto() {
        return puesto;
    }

}