package ar.edu.unlam.pbii.cuentaBancaria;

public class CuentaCorriente extends Cuenta {
	private Double descubierto;

	public CuentaCorriente(TipoDeCuenta tipoCuenta, Integer nroCuenta, Double saldo, Double descubierto) {
		super(tipoCuenta, nroCuenta, saldo);
		setDescubierto(descubierto);
		this.descubierto = descubierto;
		// TODO Auto-generated constructor stub
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
				if (importe <= this.saldo + getDescubierto()) {
					operacionValida();
					setDescubierto(getDescubierto() - (importe - this.saldo));
					this.saldo -= (importe + calcularPunitorios(importe - this.saldo));
				} else {
					if (importe <= getDescubierto()) {
						operacionValida();
						this.saldo -= (importe + calcularPunitorios(getDescubierto()));
						setDescubierto(getDescubierto() - importe);
					}
				}
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
			if (getDescubierto() < this.descubierto) {
				if (this.descubierto - getDescubierto() <= importe) {
					setDescubierto(this.descubierto);
				} else {
					setDescubierto(importe + getDescubierto());
				}
			}
			this.saldo += importe;
		}
	}

	@Override
	public Double calcularPunitorios(Double monto) {
		return tipoCuenta.getPunitorios() * monto;
	}

}
