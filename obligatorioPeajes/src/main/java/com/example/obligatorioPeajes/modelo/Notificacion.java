package com.example.obligatorioPeajes.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Notificacion {

    private LocalDateTime fechaHora;

    private String mensaje;

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }
    public Notificacion(LocalDateTime fechaHora, String mensaje) {
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
    }
}
