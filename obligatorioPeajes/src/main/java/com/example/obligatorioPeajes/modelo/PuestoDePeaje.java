package com.example.obligatorioPeajes.modelo;

import java.util.List;
import java.util.ArrayList;

public class PuestoDePeaje {

    private String nombre;

    private String direccion;

    private List<Transito> listaDeTransitos;

    public PuestoDePeaje(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaDeTransitos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Transito> getListaDeTransitos() {
        return listaDeTransitos;
    }

    public Transito registrarTransito(Vehiculo v, DateTime fecha) {
        return null;
    }

    public boolean tuvoTransitoHoy(Vehiculo v) {
        return false;
    }

}
