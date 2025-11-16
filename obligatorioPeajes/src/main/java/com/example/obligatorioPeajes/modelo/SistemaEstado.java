package com.example.obligatorioPeajes.modelo;

public class SistemaEstado {
    private static SistemaEstado instancia;

    private EstadoPropietario estadoHabilitado;
    private EstadoPropietario estadoDeshabilitado;
    private EstadoPropietario estadoSuspendido;
    private EstadoPropietario estadoPenalizado;

    private EstadoFrecuente estadoPrimerTransito;
    private EstadoFrecuente estadoFrecuenteDia;

    private SistemaEstado() {
        this.estadoHabilitado = Habilitado.getInstancia();
        this.estadoDeshabilitado = Deshabilitado.getInstancia();
        this.estadoSuspendido = Suspendido.getInstancia();
        this.estadoPenalizado = Penalizado.getInstancia();

    }

    public static SistemaEstado getInstancia() {
        if(instancia == null) {
            instancia = new SistemaEstado();
        }
        return instancia;
    }

    public EstadoPropietario getEstadoHabilitado() {
        return estadoHabilitado;
    }
    public EstadoPropietario getEstadoDeshabilitado() {
        return estadoDeshabilitado;
    }
    public EstadoPropietario getEstadoSuspendido() {
        return estadoSuspendido;
    }
    public EstadoPropietario getEstadoPenalizado() {
        return estadoPenalizado;
    }
    public EstadoFrecuente getEstadoPrimerTransito() {
        return estadoPrimerTransito;
    }
    public EstadoFrecuente getEstadoFrecuenteDia() {
        return estadoFrecuenteDia;
    }

}
