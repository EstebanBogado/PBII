package ar.edu.unlam.pbii.salaDeCine;

public class Butaca {
	private Boolean ocupada;

	public Butaca() {
		this.ocupada = false;
	}

	@Override
	public String toString() {
		return this.getEstadoButaca() ? "X" : "O";
	}

	public Boolean getEstadoButaca() {
		return this.ocupada;
	}

	public void ocupar() {
		// TODO Auto-generated method stub
		this.ocupada = true;
	}

}
