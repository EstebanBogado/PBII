package ar.edu.unlam.pb2.cuentaGanado;

public class Contador {



	private static Integer cantidad = 0;
	private static final Integer LIMITE_SUPERIOR = 9999;

	public Contador() {

	}

	public Integer sumarUno() {
		return 1;
	}

	public void sumador() {
		Contador.cantidad++;
	}

	public Integer getCantidad() {
		return Contador.cantidad;
	}

	public void resetearContador() {
		Contador.cantidad = 0;
	}

	public void autoReset(Integer acumulado) {
		if (acumulado > Contador.LIMITE_SUPERIOR) {
			Contador.cantidad = 0;
		}
	}
}
