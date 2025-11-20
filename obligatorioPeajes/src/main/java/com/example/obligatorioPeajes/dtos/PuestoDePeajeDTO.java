package com.example.obligatorioPeajes.dtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import com.example.obligatorioPeajes.modelo.PuestoDePeaje;
import com.example.obligatorioPeajes.modelo.Tarifa;

public class PuestoDePeajeDTO {
    private String nombre;
    private String direccion;
    private List<Tarifa> tarifas;

    public PuestoDePeajeDTO(PuestoDePeaje p) {
        this.nombre = p.getNombre();
        this.direccion = p.getDireccion();
        this.tarifas = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(List<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

    public static List<PuestoDePeajeDTO> fromList(List<PuestoDePeaje> puestos) {
        if (puestos == null || puestos.isEmpty()) {
            return Collections.emptyList();
        }
        List<PuestoDePeaje> listaOrdenada = ordenarPuestosDePeaje(puestos);
        List<PuestoDePeajeDTO> listaDTos = new ArrayList<>();
        for (PuestoDePeaje p : listaOrdenada) {
            listaDTos.add(new PuestoDePeajeDTO(p));
        }

        return listaDTos;
    }

    private static List<PuestoDePeaje> ordenarPuestosDePeaje(List<PuestoDePeaje> puestos) {
        List<PuestoDePeaje> listaOrdenable = new ArrayList<>(puestos);
        listaOrdenable.sort(Comparator.comparing(PuestoDePeaje::getNombre));
        return listaOrdenable;
    }

}