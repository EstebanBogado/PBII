package ar.edu.unlam.pbii.hechizos;

public class Mueble implements Hechizable {
	private String estado = "Normal";

	@Override
	public String getEstado() {
		return this.estado;
	}

	@Override
	public void hechizado(String hechizo) {
		// TODO Auto-generated method stub
		this.estado = hechizo;
	}

}
