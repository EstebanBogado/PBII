package ar.edu.unlam.pbii.hechizos;

public abstract class Hechizo {

	protected String nombre;

	public Hechizo(String nombre) {
		this.nombre = nombre;
	}

	public abstract String getNombreHechizo();

	public abstract void aplicarHechizo(Hechizable objetivo);
}
