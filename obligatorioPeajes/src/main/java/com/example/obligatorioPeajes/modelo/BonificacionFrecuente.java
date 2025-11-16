package com.example.obligatorioPeajes.modelo;

public class BonificacionFrecuente extends Bonificacion {

    public BonificacionFrecuente(String nombre) {
        super(nombre);
    }
    @Override
    public double calcularMontoFijo(Transito t, PuestoDePeaje puesto) {
       return 0;
    }
}
