package com.example.obligatorioPeajes.modelo;
import java.util.ArrayList;
import java.util.Collection;
import java.time.LocalDateTime;

public class SistemaBonificacion {
    private static SistemaBonificacion instancia;

	private Collection<BonificacionAsignada> bonificacionAsignada;

	private Collection<Bonificacion> bonificacion;

    private SistemaBonificacion() {
        this.bonificacionAsignada = new ArrayList<>();
        this.bonificacion = new ArrayList<>();
        this.precargarTiposBonificacion();
    }
	public void precargarTiposBonificacion() {
        Bonificacion exonerado = new BonificacionExonerado("Exonerados");
        Bonificacion frecuente = new BonificacionFrecuente("Frecuentes");
        Bonificacion trabajador = new BonificacionTrabajador("Trabajadores");

        this.bonificacion.add(exonerado);
        this.bonificacion.add(frecuente);
        this.bonificacion.add(trabajador);
	}

    public static SistemaBonificacion getInstancia() {
        if(instancia == null) {
            instancia = new SistemaBonificacion();
        }
        return instancia;
    }
	public java.util.List<Bonificacion> obtenerBonificacionesDefinidas() {
		return null;
	}

	public Bonificacion buscarBonificacionPorNombre(String nombre) {
		Bonificacion bonificacionBuscada = null;
        for(Bonificacion b : this.bonificacion) {
            if(b.getNombre().equalsIgnoreCase(nombre)) {
                bonificacionBuscada = b;
                break;
            }
        }
        return bonificacionBuscada;
	}

    public BonificacionAsignada asignarBonificacion(Propietario propietario, PuestoDePeaje puesto, Bonificacion bonificacion) {
        EstadoFrecuente estadoInicial = SistemaEstado.getInstancia().getEstadoPrimerTransito();
        BonificacionAsignada ba = new BonificacionAsignada(new DateTime(LocalDateTime.now()), propietario, bonificacion, puesto, estadoInicial);
        this.bonificacionAsignada.add(ba);
        propietario.agregarBonificacionAsignada(ba);
        return ba;
    }
	public BonificacionAsignada obtenerBonificacionAsignada(Propietario propietario, PuestoDePeaje puesto) {
		return null;
	}

	public void calcularMontoDescuento(BonificacionAsignada bonificacionAsignada, Transito transito) {

	}

}
