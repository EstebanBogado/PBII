package ar.edu.unlam.alumno.pbii.simulador;

public enum Accesorios implements EsMejorable {
	LEVANTA_VIDRIOS {
		// precio por puerta
		@Override
		public Double getCostoAccesorio(Vehiculo vehiculo) {
			return vehiculo.getCantPuertas() * getLevantaVidrio();
		}

	},
	ESTEREO {
		// precio fijo de instalación más costo de parlante, siempre un parlante por
		// puerta

		@Override
		public Double getCostoAccesorio(Vehiculo vehiculo) {
			return vehiculo.getCantPuertas() * getPercioParlante() + getInstalacionEstereo();
		}
	},
	PULIDO {
		// si el auto es veloz, se incrementa en $5000, nunca debe superar los $100000

		@Override
		public Double getCostoAccesorio(Vehiculo vehiculo) {
			Double precioPulido = 0.0;
			if (vehiculo.esVeloz()) {
				precioPulido = (getBasePulido() + incrementoPulido) * vehiculo.getSuperficie();
			} else {
				precioPulido = getBasePulido() * vehiculo.getSuperficie();
			}
//			if (precioPulido > 100000.0) {
//				precioPulido = 100000.0;
//			}
			return Math.min(precioPulido, 100000.0);
		}
	},
	ALARMA {
		// si el auto es deportivo, se incrementa en $30000
		@Override
		public Double getCostoAccesorio(Vehiculo vehiculo) {
		
			if (vehiculo.esDeportivo()) {
				precioAlarma = getPrecioAlarma() + getIncrementoAlarma();
			}
			return precioAlarma;
		}
	},
	KIT_NITRO {
		// sin importar la velocidad máxima del auto, el kit nitro lo vuelve veloz
		// siempre
		@Override
		public Double getCostoAccesorio(Vehiculo vehiculo) {
			vehiculo.setKitNitro(true);
			return getPrecioNitro();
		}
	};

	private static Double instalacionEstereo = 0.0;
	private static Double precioPorParlante = 0.0;
	private static Double basePulido = 0.0;
	private static Double incrementoPulido = 5000.0;
	private static Double levantaVidrio = 0.0;
	private static Double precioAlarma = 0.0;
	private static Double incrementoDeportivo = 0.0;
	private static Double precioNitro = 0.0;

	public void setCostoEstereo(Double instalacionEstereo, Double precioPorParlante) {
		Accesorios.instalacionEstereo = instalacionEstereo;
		Accesorios.precioPorParlante = precioPorParlante;
	}

	public Double getInstalacionEstereo() {
		return Accesorios.instalacionEstereo;
	}

	public Double getPercioParlante() {
		return Accesorios.precioPorParlante;
	}

	public void setBasePulido(Double basePulido) {
		Accesorios.basePulido = basePulido;
	}

	public Double getBasePulido() {
		return Accesorios.basePulido;
	}
	
	public void setLevantaVidrio(Double precioLevantaVidrio) {
		Accesorios.levantaVidrio = precioLevantaVidrio;
	}
	
	public Double getLevantaVidrio() {
		return Accesorios.levantaVidrio;
	}
	
	public void setPrecioAlarma(Double precioAlarma, Double incrementoDeportivo) {
		Accesorios.precioAlarma = precioAlarma;
		Accesorios.incrementoDeportivo = incrementoDeportivo;
	}
	
	public Double getPrecioAlarma() {
		return Accesorios.precioAlarma;
	}
	
	public Double getIncrementoAlarma() {
		return Accesorios.incrementoDeportivo;
	}

	public void setPrecioNitro(Double precioNitro) {
		Accesorios.precioNitro = precioNitro;
	}
	
	public Double getPrecioNitro() {
		return Accesorios.precioNitro;
	}

	public abstract Double getCostoAccesorio(Vehiculo vehiculo);
}
