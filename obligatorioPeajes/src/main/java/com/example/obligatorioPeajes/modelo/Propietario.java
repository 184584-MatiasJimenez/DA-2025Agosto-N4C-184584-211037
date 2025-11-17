package com.example.obligatorioPeajes.modelo;
import com.example.obligatorioPeajes.servicios.ServicioUsuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Propietario extends Usuario {

	private int id;

	private double saldoActual;

	private double saldoMinimoAlerta;

	private EstadoPropietario estado;

	private List<BonificacionAsignada> bonificacionesAsignadas;

	private List<Notificacion> notificaciones;

	private Collection<Vehiculo> vehiculos;

	public Propietario(String cedula, String nombreCompleto, String contrasenia,
	 double saldoActual, double saldoMinimoAlerta) {
		super(cedula, nombreCompleto, contrasenia);
		this.saldoActual = saldoActual;
		this.saldoMinimoAlerta = saldoMinimoAlerta;
		this.bonificacionesAsignadas = new ArrayList<>();
		this.notificaciones = new ArrayList<>();
		this.vehiculos = new ArrayList<>();
		this.estado = ServicioUsuario.getInstancia().getEstadoHabilitado();
	}
	

    public int getId() {
        return id;
    }
    public double getSaldoActual() {
        return saldoActual;
    }
    public double getSaldoMinimoAlerta() {
        return saldoMinimoAlerta;
    }
    public EstadoPropietario getEstado() {
        return estado;
    }
	public void setEstado(EstadoPropietario estado) {
		this.estado = estado;
	}
    public List<BonificacionAsignada> getBonificacionesAsignadas() {
        return bonificacionesAsignadas;
    }
    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }
    public String getNombre() {
        return super.getNombreCompleto();
    }
    public String getCedula(){
        return super.getCedula();
    }
    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

	public void agregarVehiculo(Vehiculo v) {
		this.vehiculos.add(v);
	}

	public boolean puedeRealizarTransito() {
		return this.estado.puedeRealizarTransito();
	}

	public boolean puedeRecibirNotifiaciones() {
		return this.estado.puedeRecibirNotificaciones();
	}

	public void restarSaldo(double monto) {

	}

	public void agregarNotificacion(Notificacion n) {

	}

	public void borrarNotificaciones() {

	}

	public BonificacionAsignada getBonificacionPara(PuestoDePeaje puesto) {
		return null;
	}

	public boolean tieneBonificacionesEn(PuestoDePeaje puesto) {
		return false;
	}
    public void agregarBonificacionAsignada(BonificacionAsignada ba) {
        if(ba == null) return;
        if(!this.bonificacionesAsignadas.contains(ba)){
            this.bonificacionesAsignadas.add(ba);
        } 
    }
    
    public List<BonificacionAsignada> obtenerBonificacionesAsignadas() {
        return new ArrayList<>(this.bonificacionesAsignadas);
    }
	public boolean estaDeshabilitado() {
		return this.estado.esDeshabilitado();
	}

}
