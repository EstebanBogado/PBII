package ar.edu.unlam.pbii.amarras;

public class Amarra implements Comparable<Amarra> {
	private Double supAmarra;
	private Boolean amarraLibre;
	private Integer nroAmarra;

	public Amarra(Integer nroAmarra, Double supAmarra) {
		this.supAmarra = supAmarra;
		this.amarraLibre = true;
		this.nroAmarra = nroAmarra;
	}

	public Double getSupAmarra() {
		return supAmarra;
	}

	public Boolean getAmarraLibre() {
		return amarraLibre;
	}

	public Integer getNroAmarra() {
		return this.nroAmarra;
	}

	@Override
	public int compareTo(Amarra amarraNueva) {
		return Integer.compare(this.nroAmarra, amarraNueva.nroAmarra);
	}

	public void amarraOcupada() {
		amarraLibre = false;
	}

	public void amarraLiberada() {
		amarraLibre = true;
	}
}
