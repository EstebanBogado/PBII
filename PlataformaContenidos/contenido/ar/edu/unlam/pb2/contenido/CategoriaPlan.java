package ar.edu.unlam.pb2.contenido;

public enum CategoriaPlan {
	PLAN_BASICO {
		@Override
		public Double getPrecioBase() {
			// TODO Auto-generated method stub
			return 5.0;
		}

		@Override
		public Double getDescuentoPlan() {
			// TODO Auto-generated method stub
			return 0.0;
		}

		@Override
		public Double getAdicional() {
			// TODO Auto-generated method stub
			return 0.0;
		}
	},
	PLAN_FAMILIAR {
		@Override
		public Double getPrecioBase() {
			// TODO Auto-generated method stub
			return 5.0;
		}

		@Override
		public Double getDescuentoPlan() {
			// TODO Auto-generated method stub
			return 0.15;
		}

		@Override
		public Double getAdicional() {
			// TODO Auto-generated method stub
			return null;
		}
	},
	PLAN_PREMIUM {
		@Override
		public Double getPrecioBase() {
			// TODO Auto-generated method stub
			return 12.0;
		}

		@Override
		public Double getDescuentoPlan() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Double getAdicional() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	public abstract Double getPrecioBase();

	public abstract Double getDescuentoPlan();

	public abstract Double getAdicional();

}
