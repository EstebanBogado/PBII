package ar.edu.unlam.pb2.contenido;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private Plan plan;
	private ArrayList<Contenido> contenidoVisto = new ArrayList<Contenido>();

	public Usuario(String nombre, Plan plan) {
		this.nombre = nombre;
		this.plan = plan;
	}

	public void getContenidoVisto() {
		for (Contenido c : this.contenidoVisto) {
			System.out.println(c.getNombre());
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public void setContenidoVisto(Contenido contenido) {
		contenidoVisto.add(contenido);
	}

	public Double costoAdicionales() {
		if (plan.getCategoria().equals(CategoriaPlan.PLAN_PREMIUM)) {
			return 0.0;
		}
		return contenidoVisto.stream().skip(plan.getLimiteMensual()).mapToDouble(Contenido::getCostoBase).sum();
	}

	public Integer getTotalVistos() {
		return this.contenidoVisto.size();
	}
}
