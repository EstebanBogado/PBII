package ar.edu.unlam.pb2.contenido;

import java.util.ArrayList;

public class Temporada {

	private Integer numTemp;
	private ArrayList<Episodio> episodios = new ArrayList<Episodio>();

	public Temporada(Integer numTemp) {
		this.numTemp = numTemp;
	}

	public Integer getNumTemp() {
		return this.numTemp;
	}

	public void setEpisodios(Episodio episodios) {
		if (!this.episodios.contains(episodios)) {
			this.episodios.addLast(episodios);
		}
	}

	public void listarEpisodios() {
		for (Episodio e : episodios) {
			System.out.println(e.getNomEpisodio());
		}
	}

	public ArrayList<Episodio> getEpisodios() {
		return this.episodios;
	}

	public Integer cantEpisodios() {
		return this.episodios.size();
	}
}
