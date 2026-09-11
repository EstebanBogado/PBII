package ar.edu.unlam.pbii.gimnasio;

import java.util.HashSet;
import java.util.Set;

public abstract class Plan implements EsPersonalizable {
	protected Double precioBase;
	protected final Integer duracion;
	protected Intensidad intensidad;
	protected final Integer sesionesSemanales;
	protected Set<Adicionales> adicionales = new HashSet<Adicionales>();

	public Plan(Double precioBase, Intensidad intensidad, Integer sesionesSemanales, Integer duracion) {
		this.precioBase = precioBase;
		this.duracion = duracion;
		this.intensidad = intensidad;
		this.sesionesSemanales = sesionesSemanales;
	}

	public abstract TipoPlan getTipoPlan();

	public abstract Double getPrecioFinal();

	public abstract Double getCostoAdicionales();

	public Double getPrecioConDescuento(Descuento descuento, Double monto) {
		switch (descuento) {
		case NOMINAL:
			return getPrecioFinal() - monto;
		case PORCENTUAL:
			return (getPrecioFinal() - (getPrecioFinal() * monto));
		default:
			getPrecioFinal();
		}
		return null;
	}

	@Override
	public String toString() {
		return "Plan [precioBase=" + precioBase + ", duracion=" + duracion + ", intensidad=" + intensidad
				+ ", sesionesSemanales=" + sesionesSemanales + " " + getTipoPlan() + "]";
	}

	public void setAdicionales(Adicionales adicionales) {
		this.adicionales.add(adicionales);
	}

	public void getAdicionales() {
		for (Adicionales a : adicionales) {
			System.out.println(a);
		}
	}

}
