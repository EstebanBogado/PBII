package ar.edu.unlam.pbii.cuentaBancaria;

public class CuentaSueldo extends Cuenta {

	public CuentaSueldo(TipoDeCuenta tipoCuenta, Integer nroCuenta, Double saldo) {
		super(tipoCuenta, nroCuenta, saldo);
	}

	@Override
	public void extraer(Double importe) {
		if (importe < 0.0) {
			operacionInvalida();
		} else {
			if (importe <= this.saldo) {
				operacionValida();
				this.saldo -= importe;
			} else {
				operacionInvalida();
				System.out.println("MONTO INTRODUCIDO EXCEDE EL SALDO ACTUAL: " + this.saldo);
				System.out.println("IMPORTE EXTRAÍDO: " + this.saldo);
				this.saldo = 0.0;
				System.out.println("SALDO ACTUAL: " + this.saldo);
			}
		}
	}

	@Override
	public Boolean operacionValida() {
		return true;
	}

	@Override
	public Boolean operacionInvalida() {
		return true;
	}

	@Override
	public void depositar(Double importe) {
		if (importe <= 0.0) {
			operacionInvalida();
		} else {
			this.saldo += importe;
		}
	}

	@Override
	public Double calcularPunitorios(Double monto) {
		// TODO Auto-generated method stub
		return null;
	}
}
