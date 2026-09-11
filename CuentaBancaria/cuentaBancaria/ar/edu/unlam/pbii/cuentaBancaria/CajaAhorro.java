package ar.edu.unlam.pbii.cuentaBancaria;

public class CajaAhorro extends Cuenta {

	public CajaAhorro(TipoDeCuenta tipoCuenta, Integer nroCuenta, Double saldo) {
		super(tipoCuenta, nroCuenta, saldo);
	}

	private Integer cantExtracciones = 0;

	@Override
	public void extraer(Double importe) {
		if (importe < 0.0) {
			operacionInvalida();
		} else {
			this.cantExtracciones++;
			if ((importe + TipoDeCuenta.CAJA_DE_AHORRO.getComision()) <= this.saldo && this.cantExtracciones < 6) {
				operacionValida();
				this.saldo -= importe;
			} else {
				if ((importe + TipoDeCuenta.CAJA_DE_AHORRO.getComision()) <= this.saldo && this.cantExtracciones >= 6) {
					operacionValida();
					this.saldo -= importe + TipoDeCuenta.CAJA_DE_AHORRO.getComision();
				}
			}

			if (importe > this.saldo) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean operacionInvalida() {
		// TODO Auto-generated method stub
		return null;
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
