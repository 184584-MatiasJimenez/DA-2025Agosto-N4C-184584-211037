package com.example.obligatorioPeajes.servicios;

import com.example.obligatorioPeajes.modelo.*;

import java.util.Collection;

public class ServicioTransito {

    private static ServicioTransito instancia;
    private Collection<Transito> transito;
    private Collection<Tarifa> tarifas;
    private Collection<PuestoDePeaje> puestosDePeaje;
    private Collection<CategoriaVehiculo> categoriasVehiculos;

    private ServicioTransito() {
        this.transito = new java.util.ArrayList<>();
        this.tarifas = new java.util.ArrayList<>();
        this.puestosDePeaje = new java.util.ArrayList<>();
        this.categoriasVehiculos = new java.util.ArrayList<>();
    }

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

    public static ServicioTransito getInstancia() {
        if (instancia == null) {
            instancia = new ServicioTransito();
        }
        return instancia;
    }

    public PuestoDePeaje agregarPuestoDePeaje(String nombre, String ubicacion) {
        PuestoDePeaje nuevoPuesto = new PuestoDePeaje(nombre, ubicacion);
        this.puestosDePeaje.add(nuevoPuesto);
        return nuevoPuesto;
    }

    public CategoriaVehiculo buscarCategoriaPorNombre(String nombre) {
        for (CategoriaVehiculo cat : this.categoriasVehiculos) {
            if (cat.getNombre().equalsIgnoreCase(nombre)) {
                return cat;
            }
        }
        return null;
    }

    public void agregarTarifa(PuestoDePeaje puesto, CategoriaVehiculo categoria, double monto) {
        Tarifa tarifa = new Tarifa(puesto, categoria, monto);
        this.tarifas.add(tarifa);
    }

    public void agregarCategoria(CategoriaVehiculo categoria) {
        this.categoriasVehiculos.add(categoria);
    }

}
