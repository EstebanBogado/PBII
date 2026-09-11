package ar.edu.unlam.pb2.contenido;

public abstract class Contenido {
	protected String titulo;
	protected Double costoBase;

	public Contenido(String titulo, Double costoBase) {
		this.titulo = titulo;
		this.costoBase = costoBase;
	}

	public abstract Double getCostoBase();

	public abstract String getNombre();

	public abstract Double getCostoTotal();

	public void setCostoBase(Double costoBase) {
		this.costoBase = costoBase;
	}
}
