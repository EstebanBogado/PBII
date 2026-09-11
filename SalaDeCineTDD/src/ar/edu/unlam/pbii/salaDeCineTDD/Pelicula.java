package ar.edu.unlam.pbii.salaDeCineTDD;

public class Pelicula {
	private String titulo;
	private Integer duracion;
	private Integer edadMinima;
	private Tipo categoria;
	private String sinopsis;

	public Pelicula(String titulo, Integer duracion, Integer edadMinima, Tipo categoria) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Pelicula [titulo= " + this.titulo + ", duracion= " + this.duracion + ", edadMinima= " + this.edadMinima
				+ ", categoria= " + this.categoria + "Sinopsis= " + this.sinopsis + "]";
	}

	public Integer getEdadMinima() {
		// TODO Auto-generated method stub
		return this.edadMinima;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getSinopsis() {
		return this.sinopsis;
	}

}
