package com.example.obligatorioPeajes.servicios.fachada;

import com.example.obligatorioPeajes.modelo.*;
import com.example.obligatorioPeajes.observador.Observable;
import com.example.obligatorioPeajes.servicios.ServicioBonificacion;
import com.example.obligatorioPeajes.servicios.ServicioPrecarga;
import com.example.obligatorioPeajes.servicios.ServicioTransito;
import com.example.obligatorioPeajes.servicios.ServicioUsuario;
import com.example.obligatorioPeajes.dtos.BonificacionDTO;
import com.example.obligatorioPeajes.dtos.NotificacionDTO;
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
		if(propietario != null) {
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
