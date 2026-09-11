package calculadora;

public class CalculadoraDescuento {

	private static final Double DESCUENTO_DIEZ = 0.10;
	private static final Double DESCUENTO_VEINTE = 0.20;
	private String nombre;
	private Double porcentaje;

	public CalculadoraDescuento() {
	}

	public CalculadoraDescuento(String nombre, Double porcentaje) {
		this.nombre = nombre;
		this.porcentaje = porcentaje;
	}

	public Double aplicarDescuento(Double monto) {
		if (monto == 100.0) {
			return calcular(monto, DESCUENTO_DIEZ);
		}
		if (monto < 50) {
			return monto;
		}
		if (monto > 200.00) {
			return calcular(monto, DESCUENTO_VEINTE);
		}
		return monto;
	}

	public Double descuentoPersonalizado(Double monto) {
		if (this.nombre.equals("Marcelo")) {
			return calcular(monto, this.porcentaje);
		}
		if (this.nombre.equals("Estefania")) {
			return aplicarDescuento(monto);
		}

		return null;
	}

	public Double calcular(Double monto, Double descuento) {
		return monto * (1 - descuento);
	}
}