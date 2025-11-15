import java.util.Collection;

public class SistemaBonificacion {

	private Collection<BonificacionAsignada> bonificacionAsignada;

	private Collection<Bonificacion> bonificacion;

	public void precargarTiposBonificacion() {

	}

	public List<Bonificacion> obtenerBonificacionesDefinidas() {
		return null;
	}

	public Bonificacion buscarBonificacionPorNombre(String nombre) {
		return null;
	}

	public BonificacionAsignada asignarBonificacion(Propietario propietario, PuestoDePeaje puesto, Bonificacion bonificacion) {
		return null;
	}

	public BonificacionAsignada obtenerBonificacionAsignada(Propietario propietario, PuestoDePeaje puesto) {
		return null;
	}

	public void calcularMontoDescuento(BonificacionAsignada bonificacionAsignada, Transito transito) {

	}

}
