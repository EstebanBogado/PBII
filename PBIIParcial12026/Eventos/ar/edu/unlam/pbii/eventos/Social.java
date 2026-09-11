package ar.edu.unlam.pbii.eventos;

public class Social extends Evento {
	private final Double recargo = 50000.0;

	public Social(Double precioBase, Integer cantInvitados, Double duracion, Integer superficieSalon) {
		super(precioBase, cantInvitados, duracion, superficieSalon);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Double getCostoAdicionales() {
		// TODO Auto-generated method stub
		Double costoAdicionales = 0.0;
		for (Adicional a : this.adicionales) {
			switch (a) {
			case BANDA_EN_VIVO:
				if (esMasivo()) {
					costoAdicionales += a.getPrecioBaseAdicional() + a.getPrecioExtraAdicional();
				} else {
					costoAdicionales += a.getPrecioBaseAdicional();
				}
				break;
			case CATERING:
				costoAdicionales += a.getPrecioBaseAdicional() * this.cantInvitados;
				break;
			case DECO_PREMIUM:
				Double valor = 0.0;
				if (getVip()) {
					valor = (a.getPrecioBaseAdicional() + a.getPrecioExtraAdicional()) * this.superficieSalon;
				} else {
					valor = a.getPrecioBaseAdicional() * this.superficieSalon;
				}
				costoAdicionales += Double.min(valor, 400000.0);
				break;
			case DJ_SONIDO:
				costoAdicionales += a.getPrecioBaseAdicional() + (a.getPrecioExtraAdicional() * this.duracion);
				break;
			case FUEGOS_ARTIRIFICIALES:
				costoAdicionales += a.getPrecioBaseAdicional();
				this.vip = true;
			default:
				break;
			}
		}

		return costoAdicionales;
	}

	@Override
	public Double getPrecioFinal() {
		// TODO Auto-generated method stub
		return this.precioBase + this.recargo;
	}

	@Override
	public Double getPrecioTotal() {
		// TODO Auto-generated method stub
		return getPrecioFinal() + getCostoAdicionales();
	}
}
