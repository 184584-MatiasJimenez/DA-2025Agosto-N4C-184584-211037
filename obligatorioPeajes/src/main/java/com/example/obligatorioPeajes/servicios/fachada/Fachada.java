package com.example.obligatorioPeajes.servicios.fachada;

import com.example.obligatorioPeajes.modelo.*;
import com.example.obligatorioPeajes.observador.Observable;
import com.example.obligatorioPeajes.servicios.ServicioBonificacion;
import com.example.obligatorioPeajes.servicios.ServicioPrecarga;
import com.example.obligatorioPeajes.servicios.ServicioTransito;
import com.example.obligatorioPeajes.servicios.ServicioUsuario;
import com.example.obligatorioPeajes.dtos.BonificacionDTO;
import com.example.obligatorioPeajes.dtos.NotificacionDTO;
import com.example.obligatorioPeajes.dtos.PuestoDePeajeDTO;
import com.example.obligatorioPeajes.dtos.TransitoDTO;
import java.util.Collections;
import com.example.obligatorioPeajes.excepciones.UsuarioException;
import java.util.*;

public class Fachada extends Observable {
	public enum Eventos {
		nuevoUsuarioConectado,
		nuevoUsuarioDesconectado
	}

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

	public Sesion login(String cedula, String contrasenia, String rol) throws UsuarioException {
		return servicioUsuario.loginSesion(cedula, contrasenia, rol);
	}

	public Propietario loginPropietario(String cedula, String contrasenia) throws UsuarioException {
		return servicioUsuario.loginPropietario(cedula, contrasenia);
	}

	public Administrador loginAdministrador(String cedula, String contrasenia) throws UsuarioException {
		return servicioUsuario.loginAdministrador(cedula, contrasenia);
	}

	public void precargaDatosIniciales() {
		ServicioPrecarga precarga = new ServicioPrecarga();
		precarga.cargarDatosIniciales();
	}

	public void logout(Sesion s) {
		this.servicioUsuario.logout(s);
	}

	public Propietario obtenerDatosPropietario(String cedula) {
		return null;
	}

	public List<BonificacionDTO> obtenerBonificacionesPropietario(String cedula) {
		Propietario propietario = servicioUsuario.buscarPropietarioPorCI(cedula);

		List<BonificacionDTO> listaDTos = new ArrayList<>();

		if (propietario != null) {
			List<BonificacionAsignada> asignadas = propietario.obtenerBonificacionesAsignadas();

			for (BonificacionAsignada b : asignadas) {
				listaDTos.add(new BonificacionDTO(b));
			}
		}
		return listaDTos;
	}

	public List<Vehiculo> obtenerVehiculosPropietario(String cedula) {
		return this.servicioUsuario.obtenerVehiculosPropietario(cedula);
	}

	public List<TransitoDTO> obtenerHistorialTransitos(String cedula) {
		List<Transito> transitos = servicioTransito.obtenerTransitosPorPropietario(cedula);

		List<TransitoDTO> listaDTos = new ArrayList<>();

		if (transitos != null) {
			for (Transito t : transitos) {
				listaDTos.add(new TransitoDTO(t));
			}
		}
		return listaDTos;
	}

	public List<NotificacionDTO> obtenerNotificaciones(String cedula) {
		Propietario propietario = servicioUsuario.buscarPropietarioPorCI(cedula);
		if (propietario != null) {
			List<Notificacion> notificaciones = propietario.getNotificaciones();
			return NotificacionDTO.fromList(notificaciones);
		}
		return Collections.emptyList();
	}

	public void borrarNotificaciones(String cedula) {

	}

	public Propietario buscarPropietarioPorCI(String ci) {
		return this.servicioUsuario.buscarPropietarioPorCI(ci);
	}

	public List<PuestoDePeajeDTO> obtenerPuestosDePeajes() {
		List<PuestoDePeajeDTO> listaDTos = new ArrayList<>();
		List<PuestoDePeaje> puestos = this.servicioTransito.obtenerPuestosDePeaje();

		for (PuestoDePeaje puesto : puestos) {
			PuestoDePeajeDTO dto = new PuestoDePeajeDTO(puesto);
			List<Tarifa> tarifas = this.servicioTransito.getTarifasPorPuestoDePeaje(puesto);
			dto.setTarifas(tarifas);
			listaDTos.add(dto);
		}

		return listaDTos;
	}

	public List<Bonificacion> obtenerListaBonificaciones() {
		return null;
	}

	public List<EstadoPropietario> obtenerListaEstadosPropietario() {
		return null;
	}

	public void cambiarEstadoPropietario(String ciPropietario, String nombreNuevoEstado) {

	}

	public void asignarBonificacion(String ciPropietario, String nombreBonif, String nombrePuesto) {
	}

	public TransitoDTO emularTransito(String matricula, String nombrePuesto, DateTime fechaHora) {
		Vehiculo vehiculo = servicioUsuario.buscarVehiculoPorMatricula(matricula);
		if (vehiculo == null)
			return new TransitoDTO("No existe el vehículo");

		Propietario propietario = vehiculo.getPropietario();
		if (propietario.estaDeshabilitado()) {
			return new TransitoDTO("El propietario del vehículo está deshabilitado, no puede realizar tránsitos");
		}
		if (propietario.getEstado() instanceof Suspendido) {
			return new TransitoDTO("El propietario del vehículo está suspendido, no puede realizar tránsitos");
		}

		PuestoDePeaje puesto = servicioTransito.buscarPuestoDePeajePorNombre(nombrePuesto);
		Tarifa tarifa = servicioTransito.buscarTarifa(puesto, vehiculo.getCategoria());
		double tarifaBase = tarifa.getMonto();

		double saldoActual = propietario.getSaldoActual();
		if (saldoActual < tarifaBase) {
			return new TransitoDTO("Saldo insuficiente: " + saldoActual);
		}

		Transito creado = servicioTransito.registrarTransito(vehiculo, nombrePuesto, fechaHora);
		// descontar saldo del propietario luego de registrar el tránsito
		if (creado != null && propietario != null) {
			propietario.restarSaldo(creado.getMontoPagado());
		}
		return new TransitoDTO(creado);
	}

}
