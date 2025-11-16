package com.example.obligatorioPeajes.modelo;

public class Fachada {

    private static Fachada instancia;
    private SistemaUsuario sistemaUsuario;
    private SistemaTransito sistemaTransito;
    private SistemaBonificacion sistemaBonificacion;
    private Fachada() {
        this.sistemaUsuario = SistemaUsuario.getInstancia();
        this.sistemaTransito = SistemaTransito.getInstancia();
        this.sistemaBonificacion = SistemaBonificacion.getInstancia();
    }

	public static Fachada getInstance() {
        if(instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
	}

	public Usuario login(String cedula, String contrasenia) {
		boolean loginExitoso = this.sistemaUsuario.iniciarSesion(cedula, contrasenia);
        if(loginExitoso) {
            return this.sistemaUsuario.buscarPropietarioPorCI(cedula);
        }
        return null;
	}

	public void precargaDatosIniciales() {
        SistemaPrecarga precarga = new SistemaPrecarga();
        precarga.cargarDatosIniciales();
	}

	public void logout(String cedula) {
        this.sistemaUsuario.registrarLogout();
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
		return SistemaUsuario.getInstancia().buscarPropietarioPorCI(ci);
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
