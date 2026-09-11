package ar.edu.unlampb2.contenidoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.contenido.*;

public class SeriesTest {

	@Test
	public void crearUnaSerieYQueRetorneElCostoBaseYSuTitulo() {
		Contenido serie = new Serie("csi", 2000.0);

		assertEquals(2000.0, serie.getCostoBase(), 0.01);
		assertEquals("csi", serie.getNombre());
	}

	@Test
	public void crearUnaSerieYAgregarleUnaTemporadaYUncapitulo() {
		Double valorEsperado = 3500.0;
		Episodio piloto = new Episodio(1, "Piloto", 1500.0);
		Temporada temporada1 = new Temporada(1);
		temporada1.setEpisodios(piloto);
		Serie serie = new Serie("csi", 2000.0);
		serie.setTemporada(temporada1);

		assertEquals(valorEsperado, serie.getCostoTotal());
	}

	@Test
	public void crearUnaSerieYAgregarleUnaTemporadaYDoscapitulos() {
		Double valorEsperado = 3650.0;
		Episodio piloto = new Episodio(1, "Piloto", 1500.0);
		Episodio episodio2 = new Episodio(2, "Episodio 2", 1800.0);
		Temporada temporada1 = new Temporada(1);
		temporada1.setEpisodios(episodio2);
		temporada1.setEpisodios(piloto);
		Serie serie = new Serie("csi", 2000.0);
		serie.setTemporada(temporada1);

		assertEquals(valorEsperado, serie.getCostoTotal());
	}

	@Test
	public void crearUnaSerieYAgregarleUnaTemporadaYDoscapitulosIgualesYQueNoAgregueElRepetido() {
		Integer valorEsperado = 1;
		Episodio piloto = new Episodio(1, "Piloto", 1500.0);
		Episodio episodio2 = new Episodio(1, "Piloto", 1500.0);
		Temporada temporada1 = new Temporada(1);
		temporada1.setEpisodios(episodio2);
		temporada1.setEpisodios(piloto);
		temporada1.listarEpisodios();

		assertEquals(valorEsperado, temporada1.cantEpisodios());
	}

	@Test
	public void crearUnaSerieYAgregarleDosTemporadasYDoscapitulos() {
		Double valorEsperado = 3950.0;
		Episodio piloto = new Episodio(1, "Piloto", 2500.0);
		Episodio episodio21 = new Episodio(2, "Episodio 21", 2000.0);
		Temporada temporada1 = new Temporada(1);
		temporada1.setEpisodios(piloto);
		temporada1.setEpisodios(episodio21);
		Episodio episodio12 = new Episodio(1, "Episodio 12", 1500.0);
		Episodio episodio22 = new Episodio(2, "Episodio 22", 1800.0);
		Temporada temporada2 = new Temporada(2);
		temporada2.setEpisodios(episodio12);
		temporada2.setEpisodios(episodio22);
		Serie serie = new Serie("csi", 2000.0);
		temporada1.listarEpisodios();
		temporada2.listarEpisodios();
		serie.setTemporada(temporada1);
		serie.setTemporada(temporada2);

		assertEquals(valorEsperado, serie.getCostoTotal());
	}
}
