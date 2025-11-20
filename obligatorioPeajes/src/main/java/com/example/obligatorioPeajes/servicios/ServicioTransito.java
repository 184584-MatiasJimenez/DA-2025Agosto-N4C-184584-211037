package com.example.obligatorioPeajes.servicios;

import com.example.obligatorioPeajes.modelo.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public Transito registrarTransito(Vehiculo vehiculo, String nombrePuesto, DateTime fecha) {
        if(vehiculo == null) {
            return null;
        }
        PuestoDePeaje puesto = buscarPuestoDePeajePorNombre(nombrePuesto);
        if (puesto == null) return null;

        Tarifa tarifaObj = buscarTarifa(puesto, vehiculo.getCategoria());
        double tarifaBase = (tarifaObj != null) ? tarifaObj.getMonto() : 0.0;
        Transito nuevoTransito = new Transito(
            fecha, 
            vehiculo, 
            puesto, 
            tarifaBase
            );
        vehiculo.agregarTransito(nuevoTransito); 
        this.transito.add(nuevoTransito);
        
        return nuevoTransito;
    }
    public PuestoDePeaje buscarPuestoDePeajePorNombre(String nombre) {
        for (PuestoDePeaje puesto : this.puestosDePeaje) {
            if (puesto.getNombre().equalsIgnoreCase(nombre)) {
                return puesto;
            }
        }
        return null;
    }

    public Tarifa buscarTarifa(PuestoDePeaje puesto, CategoriaVehiculo categoria) {
        if(puesto == null || categoria == null) return null;
        for(Tarifa t: this.tarifas) {
            if(t.getPuesto().equals(puesto) && t.getCategoria().equals(categoria)) {
                return t;
            }
        }
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

    public List<Transito>obtenerTransitosPorPropietario(String cedula) {
        ServicioUsuario servicioUsuario = ServicioUsuario.getInstancia();
        Propietario propietario = servicioUsuario.buscarPropietarioPorCI(cedula);

        if (propietario == null) {
            return new ArrayList<>();
        }

        // **Punto 2: Lógica del ServicioTransito**
        // Solo itera sobre los tránsitos y los filtra.
        List<Transito> transitosDelPropietario = new ArrayList<>();
        for (Transito t : this.transito) {
            if (t.getPropietario().equals(propietario)) {
                transitosDelPropietario.add(t);
            }
        }
        
        return transitosDelPropietario;
    }

}
