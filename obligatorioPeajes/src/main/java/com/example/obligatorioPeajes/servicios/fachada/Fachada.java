package com.example.obligatorioPeajes.servicios.fachada;

import com.example.obligatorioPeajes.modelo.*;
import com.example.obligatorioPeajes.servicios.ServicioBonificacion;
import com.example.obligatorioPeajes.servicios.ServicioPrecarga;
import com.example.obligatorioPeajes.servicios.ServicioTransito;
import com.example.obligatorioPeajes.servicios.ServicioUsuario;

public class Fachada {

	private static Fachada instancia;
	private ServicioUsuario servicioUsuario;
	private ServicioTransito servicioTransito;
	private ServicioBonificacion servicioBonificacion;

	private Fachada() {
		this.servicioUsuario = ServicioUsuario.getInstancia();
		this.servicioTransito = ServicioTransito.getInstancia();
		this.servicioBonificacion = ServicioBonificacion.getInstancia();
	}

	public static Fachada getInstance() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}

	public Usuario login(String cedula, String contrasenia) {
		boolean loginExitoso = this.servicioUsuario.iniciarSesion(cedula, contrasenia);
		if (loginExitoso) {
			return this.servicioUsuario.buscarPropietarioPorCI(cedula);
		}
		return null;
	}

	public void precargaDatosIniciales() {
		ServicioPrecarga precarga = new ServicioPrecarga();
		precarga.cargarDatosIniciales();
	}

	public void logout(String cedula) {
		this.servicioUsuario.registrarLogout();
	}

	public Propietario obtenerDatosPropietario(String cedula) {
		return null;
	}

	public java.util.List<BonificacionAsignada> obtenerBonificacionesPropietario(String cedula) {
		return null;
	}

	public java.util.List<Vehiculo> obtenerVehiculosPropietario(String cedula) {
		return null;
	}

	public java.util.List<Transito> obtenerHistorialTransitos(String cedula) {
		return null;
	}

	public java.util.List<Notificacion> obtenerNotificaciones(String cedula) {
		return null;
	}

	public void borrarNotificaciones(String cedula) {

	}

	public Propietario buscarPropietarioPorCI(String ci) {
		return this.servicioUsuario.buscarPropietarioPorCI(ci);
	}

	public java.util.List<PuestoDePeaje> obtenerListaPuestos() {
		return null;
	}

	public java.util.List<Bonificacion> obtenerListaBonificaciones() {
		return null;
	}

	public java.util.List<EstadoPropietario> obtenerListaEstadosPropietario() {
		return null;
	}

	public void cambiarEstadoPropietario(String ciPropietario, String nombreNuevoEstado) {

	}

	public void asignarBonificacion(String ciPropietario, String nombreBonif, String nombrePuesto) {

	}

	public Transito emularTransito(String matricula, String nombrePuesto, DateTime fechaHora) {
		return null;
	}

}
