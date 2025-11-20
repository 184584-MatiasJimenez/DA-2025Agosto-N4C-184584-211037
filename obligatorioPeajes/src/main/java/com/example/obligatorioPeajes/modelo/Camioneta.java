package com.example.obligatorioPeajes.modelo;
import com.example.obligatorioPeajes.servicios.ServicioTransito;

public class Camioneta extends Vehiculo {

    public Camioneta(String matricula, String marca, String modelo, String color, int anio, Propietario propietario) {
        super(matricula, marca, modelo, color, anio, propietario);
    }

    @Override
    protected void setCategoria(CategoriaVehiculo categoria) {
        super.setCategoria(ServicioTransito.getInstancia().buscarCategoriaPorNombre("Moto"));
    }

}