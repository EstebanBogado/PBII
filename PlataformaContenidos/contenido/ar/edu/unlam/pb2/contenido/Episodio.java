package ar.edu.unlam.pb2.contenido;

import java.util.Objects;

public class Episodio {
	private Double costoUnitario;
	private String nombreEpisodio;
	private Integer numEpisodio;

	public Episodio(Integer numEpisodio, String nombreEpisodio, Double costoUnitario) {
		this.numEpisodio = numEpisodio;
		this.nombreEpisodio = nombreEpisodio;
		this.costoUnitario = costoUnitario;
	}

	public String getNomEpisodio() {
		return this.nombreEpisodio;
	}

	public Double getCostoUnitario() {
		return this.costoUnitario;
	}

	public Integer getNumEpisodio() {
		return this.numEpisodio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numEpisodio, nombreEpisodio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Episodio))
			return false;
		Episodio otro = (Episodio) obj;
		return this.numEpisodio.equals(otro.numEpisodio);
	}
}
