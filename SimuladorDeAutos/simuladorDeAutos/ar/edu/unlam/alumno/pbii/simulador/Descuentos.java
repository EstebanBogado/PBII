package ar.edu.unlam.alumno.pbii.simulador;

public enum Descuentos {
	DESCUENTO_PORCENTUAL {

		@Override
		public Double aplicar(Vehiculo vehiculo, Double descuento) {
			return vehiculo.getPrecioFinal() * descuento;
		}

	},
	DESCUENTO_NOMINAL {

		@Override
		public Double aplicar(Vehiculo vehiculo, Double descuento) {
			return descuento;
		}

	};
	
	public abstract Double aplicar(Vehiculo vehiculo, Double descuento);
}
