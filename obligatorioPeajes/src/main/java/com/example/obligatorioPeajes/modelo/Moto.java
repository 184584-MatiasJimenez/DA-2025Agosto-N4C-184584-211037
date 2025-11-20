package com.example.obligatorioPeajes.modelo;

import com.example.obligatorioPeajes.servicios.ServicioTransito;

public class Moto extends Vehiculo {

    public Moto(String matricula, String marca, String modelo, String color, int anio, Propietario propietario) {
        super(matricula, marca, modelo, color, anio, propietario);
        this.setCategoria(null);
    }
    @Override
    protected void setCategoria(CategoriaVehiculo categoria) {
        super.setCategoria(ServicioTransito.getInstancia().buscarCategoriaPorNombre("Moto"));
    }

}
