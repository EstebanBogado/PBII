package ar.edu.unlam.pbii.hechizos;

public class Agrandar extends Hechizo {

	public Agrandar() {
		super("enormuvus");
	}

	@Override
	public String getNombreHechizo() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public void aplicarHechizo(Hechizable objetivo) {
		// TODO Auto-generated method stub
		objetivo.hechizado("Ahora soy más grande");
	}

}
