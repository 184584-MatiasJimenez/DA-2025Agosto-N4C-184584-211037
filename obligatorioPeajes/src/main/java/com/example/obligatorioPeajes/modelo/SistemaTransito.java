package com.example.obligatorioPeajes.modelo;

import java.util.Collection;

public class SistemaTransito {

    private static SistemaTransito instancia;
	private Collection<Transito> transito;
    private Collection<Tarifa> tarifas;
    private Collection<PuestoDePeaje> puestosDePeaje;

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
       if(instancia == null) {
           instancia = new SistemaTransito();
       }
       return instancia;
    }

    public PuestoDePeaje agregarPuestoDePeaje(String nombre, String ubicacion) {
        PuestoDePeaje nuevoPuesto = new PuestoDePeaje(nombre, ubicacion);
        this.puestosDePeaje.add(nuevoPuesto);
        return nuevoPuesto;
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
