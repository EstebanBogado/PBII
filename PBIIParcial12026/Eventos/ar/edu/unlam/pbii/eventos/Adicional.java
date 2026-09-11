package ar.edu.unlam.pbii.eventos;

public enum Adicional {
	CATERING {
		@Override
		public Double getPrecioBaseAdicional() {
			// TODO Auto-generated method stub
			return 15000.0;
		}

		@Override
		public Double getPrecioExtraAdicional() {
			// TODO Auto-generated method stub
			return null;
		}
	}, DJ_SONIDO {
		@Override
		public Double getPrecioBaseAdicional() {
			// TODO Auto-generated method stub
			return 50000.0;
		}

		@Override
		public Double getPrecioExtraAdicional() {
			// TODO Auto-generated method stub
			return 20000.0;
		}
	}, DECO_PREMIUM {
		@Override
		public Double getPrecioBaseAdicional() {
			// TODO Auto-generated method stub
			return 500.0;
		}

		@Override
		public Double getPrecioExtraAdicional() {
			// TODO Auto-generated method stub
			return 50000.0;
		}
	}, BANDA_EN_VIVO {
		@Override
		public Double getPrecioBaseAdicional() {
			// TODO Auto-generated method stub
			return 200000.0;
		}

		@Override
		public Double getPrecioExtraAdicional() {
			// TODO Auto-generated method stub
			return 100000.0	;
		}
	}, FUEGOS_ARTIRIFICIALES {
		@Override
		public Double getPrecioBaseAdicional() {
			// TODO Auto-generated method stub
			return 250000.0;
		}

		@Override
		public Double getPrecioExtraAdicional() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	public abstract Double getPrecioBaseAdicional();

	public abstract Double getPrecioExtraAdicional();
}
