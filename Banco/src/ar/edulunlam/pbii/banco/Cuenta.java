package ar.edulunlam.pbii.banco;

public class Cuenta {
	private String cbu;
	private Double saldo;
	private Boolean bloqueada;

	public Cuenta(String cbu, Double monto) {
		this.cbu = cbu;
		this.saldo = monto;
		this.bloqueada = false;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public String getCbu() {
		return this.cbu;
	}

	public Boolean getBloqueada() {
		return this.bloqueada;
	}

	public void depositar(Double monto) throws MontoInvalidoException{
		if (monto <= 0.0) {
			throw new MontoInvalidoException("No se puede depositar un monto menor o igual a cero.");
		}
		this.saldo += monto;
	}

	public void retirar(Double monto) throws MontoInvalidoException {
		if (monto > this.saldo || monto <= 0.0) {
			throw new MontoInvalidoException(
					"No se puede retirar un monto menor o igual a cero o mayor al saldo disponible.");
		}
		this.saldo -= monto;
	}
}
