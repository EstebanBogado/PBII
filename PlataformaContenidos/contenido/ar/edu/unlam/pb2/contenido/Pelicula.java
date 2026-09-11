package ar.edu.unlam.pb2.contenido;

public class Pelicula extends Contenido {

	public Pelicula(String titulo, Double costoBase) {
		// super le envía al padre (Contenido) la info necesaria para que este se
		// construya
		super(titulo, costoBase);
	}

	@Override
	public Double getCostoBase() {
		// TODO Auto-generated method stub
		return this.costoBase;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.titulo;
	}

	@Override
	public Double getCostoTotal() {
		// TODO Auto-generated method stub
		return null;
	}
}
