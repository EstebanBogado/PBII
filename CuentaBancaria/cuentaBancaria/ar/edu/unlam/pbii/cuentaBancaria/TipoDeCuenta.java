package ar.edu.unlam.pbii.cuentaBancaria;

public enum TipoDeCuenta {
	CUENTA_SUELDO {
		@Override
		public void setComision(Double comision) {
			// TODO Auto-generated method stub

		}

		@Override
		public Double getPunitorios() {
			return null;
		}

		@Override
		public Double getComision() {
			// TODO Auto-generated method stub
			return null;
		}
	},
	CAJA_DE_AHORRO {
		private Double comision;

		@Override
		public Double getPunitorios() {
			return null;
		}

		@Override
		public void setComision(Double comision) {
			this.comision = comision;
		}

		@Override
		public Double getComision() {
			return this.comision;
		}

	},
	CUENTA_CORRIENTE {
		private Double punitorios = 0.05;

		@Override
		public void setComision(Double comision) {
			// TODO Auto-generated method stub

		}

		@Override
		public Double getPunitorios() {
			return this.punitorios;
		}

		@Override
		public Double getComision() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	public abstract void setComision(Double comision);

	public abstract Double getComision();

	public abstract Double getPunitorios();

}
