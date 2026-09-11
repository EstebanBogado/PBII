package ar.edu.unlam.pb2.contenido;

import java.util.ArrayList;

public class Serie extends Contenido {
	private ArrayList<Temporada> temporadas = new ArrayList<Temporada>();

	public Serie(String nombreSerie, Double costoBase) {
		super(nombreSerie, costoBase);
	}

	public void setTemporada(Temporada temporadas) {
		this.temporadas.add(temporadas);
	}

	@Override
	public Double getCostoBase() {
		return this.costoBase;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.titulo;
	}

	@Override
	public Double getCostoTotal() {
		if (temporadas.isEmpty())
			return 0.0;
		Double costoTotal = 0.0;
		Integer cantEpisodios = 0;
		for (Temporada t : temporadas) {
			for (Episodio e : t.getEpisodios()) {
				costoTotal += e.getCostoUnitario();
				cantEpisodios++;
			}
		}
		if (cantEpisodios == 0) {
			return this.costoBase;
		}
		return this.costoBase + (costoTotal / cantEpisodios);

	}
}
