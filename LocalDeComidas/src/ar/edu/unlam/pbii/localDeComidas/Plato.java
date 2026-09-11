package ar.edu.unlam.pbii.localDeComidas;

public class Plato {
	private String nombre;
	private String ingred;
	private String guarnicion;
	private Double precio;

	public Plato(String nombre, String ingred, String guarnicion, Double precio) {
		this.nombre = nombre;
		this.ingred = ingred;
		this.guarnicion = guarnicion;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	/*
	 * public void setNombre(String nombre) { this.nombre = nombre; }
	 */

	public String getIngred() {
		return ingred;
	}

	@Override
	public String toString() {
		return "nombre= " + nombre + ", ingredientes= " + ingred + ", guarnicion= " + guarnicion + ", precio= " + precio
				+ "\n";
	}

	public void setIngred(String ingred) {
		this.ingred = ingred;
	}

	public String getGuarnicion() {
		return guarnicion;
	}

	public void setGuarnicion(String guarnicion) {
		this.guarnicion = guarnicion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
