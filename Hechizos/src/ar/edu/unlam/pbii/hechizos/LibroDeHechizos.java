package ar.edu.unlam.pbii.hechizos;

import java.util.HashSet;
import java.util.Set;

public class LibroDeHechizos {

	private Set<Hechizo> hechizos = new HashSet<Hechizo>();

	public LibroDeHechizos() {
	}

	public void agregarHechizo(Hechizo hechizo) {
		hechizos.add(hechizo);
	}

	public Hechizo buscar(String nombre) {
		for (Hechizo h : hechizos) {
			if (h.getNombreHechizo().equalsIgnoreCase(nombre)) {
				return h;
			}
		}
		return null;
	}
}
