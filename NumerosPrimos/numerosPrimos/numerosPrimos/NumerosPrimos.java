package numerosPrimos;

public class NumerosPrimos {

	public Integer numero;
	public Double resto;
	public Double divisor;

	public NumerosPrimos(Integer numero) {
		this.numero = numero;
	}

	public Boolean esPrimo() {
		Boolean esPrimo = false;
		divisor = Math.floor(Math.sqrt(numero));
		if (numero == 2) {
			esPrimo = true;
		} else {
			resto = numero % divisor;
			if (resto != 0) {
				do {
					resto = numero % divisor;
					divisor--;
				} while (divisor > 1 && resto != 0);
			}
			if (divisor == 1) {
				esPrimo = true;
			}
			if (resto == 0) {
				esPrimo = false;
			}
		}
		return esPrimo;
	}
}
