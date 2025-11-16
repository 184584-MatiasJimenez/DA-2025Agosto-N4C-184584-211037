package com.example.obligatorioPeajes.modelo;

import java.util.Collection;

public class SistemaTransito {

	private Collection<Transito> transito;
    private Collection<Tarifa> tarifas;

    public Collection<Tarifa> getTarifas() {
        return tarifas;
    }
    public Collection<Transito> getTransito() {
        return transito;
    }

	public Transito buscarTransitosPorCI(String cedula) {
		return null;
	}

	public Transito registrarTransito(String matricula, String nombrePuesto, DateTime fecha) {
		return null;
	}

    public static SistemaTransito getInstancia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInstancia'");
    }

    public PuestoDePeaje agregarPuestoDePeaje(String string, String string2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarPuestoDePeaje'");
    }

    public CategoriaVehiculo buscarCategoriaPorNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarCategoriaPorNombre'");
    }

    public void agregarTarifa(PuestoDePeaje puesto, CategoriaVehiculo categoria, double monto) {
        Tarifa tarifa = new Tarifa(puesto, categoria, monto);
        this.tarifas.add(tarifa);
    }

}
