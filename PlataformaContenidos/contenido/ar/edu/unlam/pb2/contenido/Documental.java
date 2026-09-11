package ar.edu.unlam.pb2.contenido;

public class Documental extends Contenido {

	private static Double canonIDRA = 0.5;

	public Documental(String titulo, Double costoBase) {
		// super le envía al padre (Contenido) la info necesaria para que este se
		// construya
		super(titulo, costoBase);
	}

	public static void setCanonIDRA(double canonIDRA) {
		Documental.canonIDRA = canonIDRA;
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
		return getCostoBase() + canonIDRA;
	}
}
