package ar.edu.unlam.pbii.gimnasio;

public class PlanIntensivo extends Plan implements EsPersonalizable {
	private TipoPlan tipoPlan = TipoPlan.INTENSIVO;

	public PlanIntensivo(Double precioBase, Intensidad intensidad, Integer sesionesSemanales, Integer duracion) {
		super(precioBase, intensidad, sesionesSemanales, duracion);

	}

	@Override
	public TipoPlan getTipoPlan() {
		return this.tipoPlan;
	}

	@Override
	public Double getPrecioFinal() {
		return this.precioBase + getCostoAdicionales();
	}

	@Override
	public Double getCostoAdicionales() {
		Double costoAdicionales = 0.0;
		for (Adicionales a : adicionales) {
			switch (a) {
			case NUTRICIONISTA:
				costoAdicionales += a.getPrecioBase();
				break;
			case SUPLEMENTOS:
				costoAdicionales += a.getPrecioBase() + (a.getPrecioExtra() * this.duracion);
				break;
			case MASAJES_RECUPERATIVOS:
				if (this.duracion * (a.getPrecioBase() + a.getPrecioExtra()) > 150000.0) {
					costoAdicionales += 150000.0;
				} else {
					costoAdicionales += (this.duracion * (a.getPrecioBase() + a.getPrecioExtra()));
				}
				break;
			case ENTRENAMIENTO_FUNCIONAL:
				costoAdicionales += a.getPrecioBase();
				break;
			case COACHING_MENTAL:
				costoAdicionales += a.getPrecioBase();
				break;
			default:
				break;
			}
		}
		return costoAdicionales;
	}

}
