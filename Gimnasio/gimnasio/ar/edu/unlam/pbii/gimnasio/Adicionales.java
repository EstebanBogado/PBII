package ar.edu.unlam.pbii.gimnasio;

public enum Adicionales {
	NUTRICIONISTA {
		@Override
		public Double getPrecioBase() {
			return 10000.0;
		}

		@Override
		public Double getPrecioExtra() {
			// TODO Auto-generated method stub
			return 0.0;
		}
	},
	SUPLEMENTOS {
		@Override
		public Double getPrecioBase() {
			return 20000.0;
		}

		@Override
		public Double getPrecioExtra() {
			// TODO Auto-generated method stub
			return 5000.0;
		}
	},
	MASAJES_RECUPERATIVOS {
		@Override
		public Double getPrecioBase() {
			return 8000.0;
		}

		@Override
		public Double getPrecioExtra() {
			// TODO Auto-generated method stub
			return 10000.0;	
		}
	},
	ENTRENAMIENTO_FUNCIONAL {
		@Override
		public Double getPrecioBase() {
			return 25000.0;
		}

		@Override
		public Double getPrecioExtra() {
			// TODO Auto-generated method stub
			return 25000.0;
		}
	},
	COACHING_MENTAL {
		@Override
		public Double getPrecioBase() {
			return 50000.0;
		}

		@Override
		public Double getPrecioExtra() {
			// TODO Auto-generated method stub
			return 0.0;
		}
	};

	public abstract Double getPrecioBase();

	public abstract Double getPrecioExtra();
}
