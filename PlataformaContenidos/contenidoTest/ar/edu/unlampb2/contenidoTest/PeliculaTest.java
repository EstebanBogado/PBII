package ar.edu.unlampb2.contenidoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.contenido.Pelicula;

public class PeliculaTest {

	@Test
	public void alConsultarUnaPeliculaDeberiaDevolverSuCostoBase() {
		// given
		Pelicula pelicula = new Pelicula("The Matrix", 10.0);
		// when
		Double costoObtenido = pelicula.getCostoBase();
		// then
		assertEquals(10.0, costoObtenido, 0.01);
	}

	@Test
	public void alCambiarElCostoBaseDevuelveElValorActualizado() {
		Pelicula pelicula = new Pelicula("The Matrix", 10.0);
		pelicula.setCostoBase(12.0);
		Double costoObtenido = pelicula.getCostoBase();
		assertEquals(12.0, costoObtenido, 0.01);
	}

}
