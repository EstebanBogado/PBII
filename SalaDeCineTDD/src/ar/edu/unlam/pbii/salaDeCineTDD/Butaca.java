package ar.edu.unlam.pbii.salaDeCineTDD;

public class Butaca {
	private Boolean ocupada;

	public Butaca() {
		this.ocupada = false;
	}

	public Boolean estaOcupada() {
		return this.ocupada;
	}

	public void ocuparButaca() {
		this.ocupada = true;
	}
	
	public void liberarButaca() {
		this.ocupada = false;
	}
}
