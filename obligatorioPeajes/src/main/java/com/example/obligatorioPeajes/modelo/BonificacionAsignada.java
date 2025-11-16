package com.example.obligatorioPeajes.modelo;

public class BonificacionAsignada {

	private DateTime fechaAsignada;

	private Propietario propietario;

	private Bonificacion bonificacion;

	private PuestoDePeaje puesto;

	private EstadoFrecuente estadoFrecuente;

    public BonificacionAsignada(DateTime fechaAsignada, Propietario propietario, Bonificacion bonificacion,
            PuestoDePeaje puesto, EstadoFrecuente estadoFrecuente) {
        this.fechaAsignada = fechaAsignada;
        this.propietario = propietario;
        this.bonificacion = bonificacion;
        this.puesto = puesto;
        this.estadoFrecuente = estadoFrecuente;
    }

	public Bonificacion getBonificacion() {
		return bonificacion;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public PuestoDePeaje getPuesto() {
		return puesto;
	}

	public DateTime getFechaAsignada() {
		return fechaAsignada;
	}

    public EstadoFrecuente getEstadoFrecuente() {
        return estadoFrecuente;
    }

    public double calcularMontoDescuento(Transito t) {
        if(this.bonificacion instanceof BonificacionFrecuente) {
            return this.estadoFrecuente.calcularDescuento(this.bonificacion, t);
        } else {
            return this.bonificacion.calcularMontoFijo(t, this.puesto);
        }
    }
}
