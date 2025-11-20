package com.example.obligatorioPeajes.modelo;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    private LocalDateTime fechaHora;

    public DateTime(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public static DateTime fechaActual() {
        return new DateTime(LocalDateTime.now());
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public DayOfWeek getDayOfWeek() {
        return this.fechaHora.getDayOfWeek();
    }

    @Override
    public String toString() {
        if (this.fechaHora == null) return "Fecha nula";
        
        // Esto le da el formato dia/mes/año
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.fechaHora.format(formato);
    }

}
