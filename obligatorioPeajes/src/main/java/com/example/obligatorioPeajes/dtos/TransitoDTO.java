package com.example.obligatorioPeajes.dtos;

import com.example.obligatorioPeajes.modelo.Transito;

public class TransitoDTO {
    private String nombrePropietario;
    private String matricula;
    private String categoriaVehiculo;
    private String fechaHora;
    private String nombrePuesto;
    private double tarifaBase;
    private double descuentoAplicado;
    private double montoPagado;
    private String nombreBonificacionAplicada;
    private String mensajeError;
    private Double saldoPosterior;

    public TransitoDTO(Transito t, String mensajeError) {
        this.nombrePropietario = t.getVehiculo().getPropietario().getNombre();
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
        this.mensajeError = mensajeError;
        this.saldoPosterior = (t.getVehiculo() != null && t.getVehiculo().getPropietario() != null)
            ? t.getVehiculo().getPropietario().getSaldoActual()
            : null;
    }

    public TransitoDTO(Transito t) {
        this(t, null);
    }

    public TransitoDTO(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getNombrePropietario() { return nombrePropietario; }
    public String getMatricula() { return matricula; }
    public String getCategoriaVehiculo() { return categoriaVehiculo; }
    public String getFechaHora() { return fechaHora; }
    public String getNombrePuesto() { return nombrePuesto; }
    public double getTarifaBase() { return tarifaBase; }
    public double getDescuentoAplicado() { return descuentoAplicado; }
    public double getMontoPagado() { return montoPagado; }
    public String getNombreBonificacion() { return nombreBonificacionAplicada; }
    public String getMensajeError() { return mensajeError; }
    public Double getSaldoPosterior() { return saldoPosterior; }
    
}
