package com.example.obligatorioPeajes.dtos;

import com.example.obligatorioPeajes.modelo.Transito;

public class TransitoDTO {
    private String matricula;
    private String categoriaVehiculo;
    private String fechaHora;
    private String nombrePuesto;
    private double tarifaBase;
    private double descuentoAplicado;
    private double montoPagado;
    private String nombreBonificacionAplicada;

    public TransitoDTO(Transito t){
        this.matricula = t.getVehiculo().getMatricula();
        this.categoriaVehiculo = t.getVehiculo().getCategoria().getNombre();
        this.fechaHora = t.getFechaHora().toString();
        this.nombrePuesto = t.getPuesto().getNombre();
        this.tarifaBase = t.getTarifaBase();
        this.descuentoAplicado = t.getDescuentoAplicado();
        this.montoPagado = t.getMontoPagado();
        this.nombreBonificacionAplicada = (t.getNombreBonificacionAplicada() != null) 
                                ? t.getNombreBonificacionAplicada() 
                                : "N/A";
    }
    public String getMatricula() { return matricula; }
    public String getCategoriaVehiculo() { return categoriaVehiculo; }
    public String getFechaHora() { return fechaHora; }
    public String getNombrePuesto() { return nombrePuesto; }
    public double getTarifaBase() { return tarifaBase; }
    public double getDescuentoAplicado() { return descuentoAplicado; }
    public double getMontoPagado() { return montoPagado; }
    public String getNombreBonificacion() { return nombreBonificacionAplicada; }
    
}
