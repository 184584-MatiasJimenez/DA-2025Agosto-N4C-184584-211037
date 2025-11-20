package com.example.obligatorioPeajes.dtos;

import com.example.obligatorioPeajes.modelo.BonificacionAsignada;

public class BonificacionDTO {
    private String nombreBonificacion;
    private String nombrePuesto;
    private String fechaAsignada;

    public BonificacionDTO(BonificacionAsignada b) {
        // 1. Verificamos si la bonificación existe antes de pedir su nombre
        if (b.getBonificacion() != null) {
            this.nombreBonificacion = b.getBonificacion().getNombre();
        } else {
            this.nombreBonificacion = "Bonif. Desconocida"; // O el texto que prefieras
        }

        // 2. Verificamos lo mismo para el puesto, por seguridad
        if (b.getPuesto() != null) {
            this.nombrePuesto = b.getPuesto().getNombre();
        } else {
            this.nombrePuesto = "Puesto no asignado";
        }

        // 3. Verificamos la fecha
        if (b.getFechaAsignada() != null) {
            // Asumiendo que es tu clase DateTime custom o Java LocalDateTime
            this.fechaAsignada = b.getFechaAsignada().toString(); 
        } else {
            this.fechaAsignada = "-";
        }
    }
    public String getNombreBonificacion() { return nombreBonificacion; }
    public String getNombrePuesto() { return nombrePuesto; }
    public String getFechaAsignada() { return fechaAsignada; }

}
