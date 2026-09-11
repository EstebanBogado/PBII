package ar.edu.unlam.pbii.salaDeCine;

public class Pelicula {
	// título género duración edad mínima sinopsis

	private String titulo;
	private Genero genero;
	private Integer duracion;
	private Integer edadMinima;
	private String sinopsis;

	public Pelicula(String titulo, Genero genero, Integer duracion, Integer edadMinima) {
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
	}

	public Boolean puedeVerla(Integer edad) {
		return edad < this.edadMinima;
	}

	public String getTitulo() {
		return titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public Integer getEdadMinima() {
		return this.edadMinima;
	}
}
