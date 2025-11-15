public class Propietario extends Usuario {

	private int id;

	private String nombre;

	private double saldoActual;

	private double saldoMinimoAlerta;

	private EstadoPropietario estado;

	private List<BonificacionAsignada> bonificacionesAsignadas;

	private List<Notificacion> notificaciones;

	public boolean puedeRealizarTransito() {
		return false;
	}

	public boolean puedeRecibirNotifiaciones() {
		return false;
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

	public void asignarBonificacion(Bonificacion b, PuestoDePeaje puesto) {

	}

}
