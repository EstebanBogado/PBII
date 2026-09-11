package ar.edu.unlam.pbii.cuentaBancaria;

public abstract class Cuenta {
	protected TipoDeCuenta tipoCuenta;
	protected Integer nroCuentas;
	protected Double saldo;
	protected Double descubierto;

	public Cuenta(TipoDeCuenta tipoCuenta, Integer nroCuenta, Double saldo) {
		this.tipoCuenta = tipoCuenta;
		this.nroCuentas = nroCuenta;
		this.saldo = saldo;
	}

	public TipoDeCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public Integer getNroCuentas() {
		return nroCuentas;
	}

	public Double getSaldo() {
		return saldo;
	}

	public abstract void extraer(Double importe);

	public abstract Boolean operacionValida();

	public abstract Boolean operacionInvalida();

	public abstract void depositar(Double importe);

	public void setDescubierto(Double descubierto) {
		this.descubierto = descubierto;
	}

	public Double getDescubierto() {
		return this.descubierto;
	}

	public abstract Double calcularPunitorios(Double monto);

}
