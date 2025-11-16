package com.example.obligatorioPeajes.modelo;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DateTime {
    private LocalDateTime fechaHora;

    public DateTime(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public DayOfWeek getDayOfWeek() {
        return this.fechaHora.getDayOfWeek();
    }

}
