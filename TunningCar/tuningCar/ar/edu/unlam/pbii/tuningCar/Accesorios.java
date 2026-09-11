package ar.edu.unlam.pbii.tuningCar;

public enum Accesorios implements EsTuneable {
	KIT_NITRO {

		private Double costo;

		@Override
		public void setCostoAdicional(Double adicional) {
		}

		@Override
		public Double getCostoAccesorio(Vehiculo vehiculo) {
			return this.costo;
		}

		@Override
		public void getNombreAccesotrio() {
			System.out.println(Accesorios.values());
		}

		@Override
		public void setCostoInstalacion(Double costo, Vehiculo vehiculo) {
			vehiculo.setKitNitro(true);
			this.costo = costo;
		}
	},
	ALARMA {
		private Double costo;
		private Double incrementoDeportivo;

		@Override
		public void setCostoAdicional(Double incrementoDeportivo) {
			this.incrementoDeportivo = incrementoDeportivo;
		}

		@Override
		public Double getCostoAccesorio(Vehiculo vehiculo) {
			return this.costo;
		}

		@Override
		public void getNombreAccesotrio() {
			System.out.println(Accesorios.values());
		}

		@Override
		public void setCostoInstalacion(Double costo, Vehiculo vehiculo) {
			this.costo = costo;
			if (vehiculo.esDeportivo()) {
				this.costo += this.incrementoDeportivo;
			}
		}
	},
	LEVANTA_VIDRIOS {
		private Double costo;

		@Override
		public void setCostoAdicional(Double adicional) {
		}

		@Override
		public Double getCostoAccesorio(Vehiculo vehiculo) {
			return this.costo;
		}

		@Override
		public void getNombreAccesotrio() {
			System.out.println(Accesorios.values());
		}

		@Override
		public void setCostoInstalacion(Double costo, Vehiculo vehiculo) {
			this.costo = costo;
			this.costo *= vehiculo.cantPuertas;
		}
	},
	PULIDO {
		private Double costo;
		private Double incrementoPulido;

		@Override
		public void setCostoAdicional(Double incrementoPulido) {
			this.incrementoPulido = incrementoPulido;
		}

		@Override
		public Double getCostoAccesorio(Vehiculo vehiculo) {
			return this.costo;
		}

		@Override
		public void getNombreAccesotrio() {
			System.out.println(Accesorios.values());
		}

		@Override
		public void setCostoInstalacion(Double costo, Vehiculo vehiculo) {
			this.costo = costo;
			if (vehiculo.esDeportivo()) {
				this.costo += this.incrementoPulido * vehiculo.superficie;
			} else {
				this.costo *= vehiculo.superficie;
			}
			if (this.costo > 100000.0) {
				this.costo = 100000.0;
			}
		}
	},
	ESTEREO {
		private Double costo;
		private Double precioParlante;

		@Override
		public void setCostoAdicional(Double precioParlante) {
			this.precioParlante = precioParlante;
		}

		@Override
		public Double getCostoAccesorio(Vehiculo vehiculo) {
			return this.costo;
		}

		@Override
		public void getNombreAccesotrio() {
			System.out.println(Accesorios.values());

		}

		@Override
		public void setCostoInstalacion(Double costo, Vehiculo vehiculo) {
			this.costo = costo;
			this.costo += vehiculo.cantPuertas * this.precioParlante;
		}
	};

//	protected static final Double INCREMENTO_DEPORTIVO = 30000.0;
//	protected static final Double INCREMENTO_PULIDO = 5000.0;
//	protected static final Double PRECIO_POR_PARLANTE = 25000.0;

	public abstract void setCostoAdicional(Double adicional);

	public abstract Double getCostoAccesorio(Vehiculo vehiculo);

	public abstract void getNombreAccesotrio();

	public abstract void setCostoInstalacion(Double costo, Vehiculo vehiculo);

}
