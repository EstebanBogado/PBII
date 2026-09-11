package ar.edu.unlam.pbii.hechizos;

public class Expelliarmus extends Hechizo {

	public Expelliarmus() {
		super("expelliarmus");
	}

	@Override
	public String getNombreHechizo() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public void aplicarHechizo(Hechizable objetivo) {
		objetivo.hechizado("Estoy desarmado");
	}

}
