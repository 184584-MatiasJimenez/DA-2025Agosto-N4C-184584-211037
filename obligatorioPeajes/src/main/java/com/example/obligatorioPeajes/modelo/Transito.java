package com.example.obligatorioPeajes.modelo;

public class Transito {

    private DateTime fechaHora;

    private double tarifaBase;

    private double descuentoAplicado;

    private double montoPagado;

    private Vehiculo vehiculo;

    private Propietario propietario;

    private PuestoDePeaje puesto;

    private double montoBonificacion;

    private String nombreBonificacionAplicada;

    public Transito(DateTime fechaHora, Vehiculo vehiculo, PuestoDePeaje puesto, double tarifaBase) {
        this.fechaHora = fechaHora;
        this.vehiculo = vehiculo;
        this.puesto = puesto;
        this.tarifaBase = tarifaBase;
        this.propietario = vehiculo.getPropietario();
        this.descuentoAplicado = 0.0;
        this.montoBonificacion = 0.0;
        this.montoPagado = tarifaBase;
        this.nombreBonificacionAplicada = null;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public PuestoDePeaje getPuesto() {
        return puesto;
    }

    public double getMontoBonificacion() {
        return montoBonificacion;
    }

    public void setMontoBonificacion(double montoBonificacion) {
        this.montoBonificacion = montoBonificacion;
    }

    public String getNombreBonificacionAplicada() {
        return nombreBonificacionAplicada;
    }

    public void setNombreBonificacionAplicada(String nombreBonificacionAplicada) {
        this.nombreBonificacionAplicada = nombreBonificacionAplicada;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void setPuesto(PuestoDePeaje puesto) {
        this.puesto = puesto;
    }

    public DateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(DateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

}
