package com.example.obligatorioPeajes.modelo;

import java.time.DayOfWeek;

public class BonificacionTrabajador extends Bonificacion {
    public BonificacionTrabajador(String nombre) {
        super(nombre);
    }

	public double calcularMontoBonificacion(Transito t) {
		return 0;
	}
    @Override
    public double calcularMontoFijo(Transito t, PuestoDePeaje puestoAsignado) {
        if(esAplicable(t, t.getPuesto(), puestoAsignado)){
            return t.getTarifaBase() * 0.80;
        }
        return 0.0;
    }
    private boolean esAplicable(Transito t, PuestoDePeaje puestoTransitado, PuestoDePeaje puestoAsignado) {
        boolean esDiaDeSemana = this.esDiaDeSemana(t);
        boolean esMismoPuesto = this.esMismoPuesto(puestoTransitado, puestoAsignado);

        return esDiaDeSemana && esMismoPuesto;
    }
    private boolean esDiaDeSemana(Transito t) {
        DayOfWeek dia = t.getFechaHora().getDayOfWeek();
        return dia != DayOfWeek.SATURDAY && dia != DayOfWeek.SUNDAY;
    }
    private boolean esMismoPuesto(PuestoDePeaje puestoTransitado, PuestoDePeaje puestoAsignado) {
        return puestoTransitado.getNombre().equals(puestoAsignado.getNombre());
    }

}
