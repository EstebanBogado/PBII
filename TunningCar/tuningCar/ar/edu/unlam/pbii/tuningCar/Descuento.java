package ar.edu.unlam.pbii.tuningCar;

public class Descuento {
	private Double descuento;
	private TipoDescuento tipo;
	private Vehiculo vehiculo;

	public Descuento(TipoDescuento tipo, Vehiculo vehiculo) {
		this.tipo = tipo;
		this.vehiculo = vehiculo;
	}

	public Double getDescuento() {
		switch (tipo) {
		case NOMINAL:
			return this.descuento;
		case PORCENTUAL:
			return this.vehiculo.getPrecioTotal() * this.descuento;
		default:
			return null;
		}
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
}
