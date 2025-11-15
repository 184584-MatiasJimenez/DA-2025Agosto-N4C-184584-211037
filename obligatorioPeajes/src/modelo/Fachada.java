public class Fachada {

	private Fachada instancia;

	private SistemaUsuario sistemaUsuario;

	private SistemaTransito sistemaTransito;

	private SistemaBonificacion sistemaBonificacion;

	private SistemaPrecarga sistemaPrecarga;

	public static Fachada getInstance() {
		return null;
	}

	public Usuario login(String cedula, String contrasenia) {
		return null;
	}

	public void precargaDatosIniciales() {

	}

	public void logout(String cedula) {

	}

	public Propietario obtenerDatosPropietario(String cedula) {
		return null;
	}

	public List<BonificacionAsignada> obtenerBonificacionesPropietario(String cedula) {
		return null;
	}

	public List<Vehiculo> obtenerVehiculosPropietario(String cedula) {
		return null;
	}

	public List<Transito> obtenerHistorialTransitos(String cedula) {
		return null;
	}

	public List<Notificacion> obtenerNotificaciones(String cedula) {
		return null;
	}

	public void borrarNotificaciones(String cedula) {

	}

	public Propietario buscarPropietarioPorCI(String ci) {
		return null;
	}

	public List<PuestoDePeaje> obtenerListaPuestos() {
		return null;
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

	public Transito emularTransito(String matricula, String nombrePuesto, DateTime fechaHora) {
		return null;
	}


}
