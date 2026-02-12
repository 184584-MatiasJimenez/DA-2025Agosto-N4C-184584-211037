package com.example.obligatorioPeajes.dtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.time.format.DateTimeFormatter;

import com.example.obligatorioPeajes.modelo.Notificacion;

public class NotificacionDTO {
    private String fechaHora;
    private String mensaje;

    public NotificacionDTO(Notificacion n) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.fechaHora = n.getFechaHora().format(formatter);
        this.mensaje = n.getMensaje();
    }
    public String getFechaHora() { return fechaHora; }
    public String getMensaje() { return mensaje; }

    public static List<NotificacionDTO> fromList(List<Notificacion> notificaciones) {
        if (notificaciones == null || notificaciones.isEmpty()) {
            return Collections.emptyList();
        }
        List<Notificacion> listaOrdenada = ordenarNotificaciones(notificaciones);
        List<NotificacionDTO> listaDTos = new ArrayList<>();
        for (Notificacion n : listaOrdenada) {
            listaDTos.add(new NotificacionDTO(n));
        }
        
        return listaDTos;
    }

    private static List<Notificacion> ordenarNotificaciones(List<Notificacion> notificaciones) {
        List<Notificacion> listaOrdenable = new ArrayList<>(notificaciones);
        listaOrdenable.sort(Comparator.comparing(Notificacion::getFechaHora).reversed());
        return listaOrdenable;
    }
    
}
