package com.example.obligatorioPeajes.dtos;

import com.example.obligatorioPeajes.modelo.BonificacionAsignada;

public class BonificacionDTO {
    private String nombreBonificacion;
    private String nombrePuesto;
    private String fechaAsignada;

    public BonificacionDTO(BonificacionAsignada b) {
        if (b.getBonificacion() != null) {
            this.nombreBonificacion = b.getBonificacion().getNombre();
        } else {
            this.nombreBonificacion = "Bonif. Desconocida";
        }
        if (b.getPuesto() != null) {
            this.nombrePuesto = b.getPuesto().getNombre();
        } else {
            this.nombrePuesto = "Puesto no asignado";
        }

        if (b.getFechaAsignada() != null) {
            this.fechaAsignada = b.getFechaAsignada().toString(); 
        } else {
            this.fechaAsignada = "-";
        }
    }
    public String getNombreBonificacion() { return nombreBonificacion; }
    public String getNombrePuesto() { return nombrePuesto; }
    public String getFechaAsignada() { return fechaAsignada; }

}
