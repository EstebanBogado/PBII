package ar.edu.unlam.pbii.eventosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pbii.eventos.Adicional;
import ar.edu.unlam.pbii.eventos.Corporativo;
import ar.edu.unlam.pbii.eventos.Descuentos;
import ar.edu.unlam.pbii.eventos.Evento;
import ar.edu.unlam.pbii.eventos.Social;

public class EventosTest {

	@Test
	public void crearUnEventoYQueNoSeaNull() {
		Evento nuevoEventoCorporativo = new Corporativo(1000000.0, 250, 6.0, 80);
		Evento nuevoEventoSocial = new Social(1500000.0, 120, 5.5, 100);

		assertNotNull(nuevoEventoCorporativo);
		assertNotNull(nuevoEventoSocial);

	}

	@Test
	public void crearUnEventoYDeterminarSiEsVipOMasivo() {
		Evento eventoCorporativo = new Corporativo(2000000.0, 70, 6.0, 80);
		Evento eventoSocial = new Social(1500000.0, 520, 5.5, 1100);

		assertTrue(eventoCorporativo.esVip());
		assertTrue(eventoSocial.esMasivo());
	}

	@Test
	public void crearUnEventoGenericoSeConviertaEnMasivo() {
		Evento eventoGenerico = new Corporativo(1000000.0, 70, 6.0, 80);

		assertFalse(eventoGenerico.esVip());
		eventoGenerico.setPrecioBase(2000000.0);
		assertTrue(eventoGenerico.esVip());
	}

	@Test
	public void generarUnEventoGenericoYAgregarleAdicionalesYModificarSuPrecioFinalYVolverloVip() {
		Double valorEsperado = 11300000.0;
		Evento eventoGenerico = new Social(2000000.0, 600, 7.5, 1200);

		eventoGenerico.setAdicionales(Adicional.CATERING);
		eventoGenerico.setAdicionales(Adicional.FUEGOS_ARTIRIFICIALES);

		assertEquals(valorEsperado, eventoGenerico.getPrecioTotal());
		assertTrue(eventoGenerico.getVip());

	}

	@Test
	public void generarUnEventoGenericoYAgregarleCateringYFuegosArtificialesYModificarSuPrecioFinalYVolverloVipYLuegoAgregarleDecoPremium() {
		Double valorEsperadoAnterior = 11300000.0;
		Double valorEsperadoPosterior = 11700000.0;
		Evento eventoGenerico = new Social(2000000.0, 600, 7.5, 600);

		eventoGenerico.setAdicionales(Adicional.CATERING);
		eventoGenerico.setAdicionales(Adicional.FUEGOS_ARTIRIFICIALES);

		assertEquals(valorEsperadoAnterior, eventoGenerico.getPrecioTotal());
		assertTrue(eventoGenerico.getVip());

		eventoGenerico.setAdicionales(Adicional.DECO_PREMIUM);
		assertEquals(valorEsperadoPosterior, eventoGenerico.getPrecioTotal());

	}

	@Test
	public void queHabiendoUnEventoCorporativoNoVipYAgregarleDecoPremiumNoLeSumeElExtra() {
		Double valorEsperado = 2300000.0;
		Evento eventoGenerico = new Corporativo(2000000.0, 600, 7.5, 600);

		eventoGenerico.setAdicionales(Adicional.DECO_PREMIUM);
		assertEquals(valorEsperado, eventoGenerico.getPrecioTotal());
		assertFalse(eventoGenerico.getVip());
	}

	@Test
	public void ejercicioEnunciadoPrecioFinalSinDescuentos() {
		Double valorEsperado = 5420000.0;
		Evento eventoEnunciado = new Corporativo(2000000.0, 200, 6.0, 500);

		eventoEnunciado.setAdicionales(Adicional.CATERING);
		eventoEnunciado.setAdicionales(Adicional.DJ_SONIDO);
		eventoEnunciado.setAdicionales(Adicional.DECO_PREMIUM);

		assertEquals(valorEsperado, eventoEnunciado.getPrecioTotal());
	}

	@Test
	public void ejercicioEnunciadoPrecioFinalConDescuentoDiezPorCiento() {
		Double valorEsperado = 4878000.0;
		Double descuento = 0.10;
		Evento eventoEnunciado = new Corporativo(2000000.0, 200, 6.0, 500);

		eventoEnunciado.setAdicionales(Adicional.CATERING);
		eventoEnunciado.setAdicionales(Adicional.DJ_SONIDO);
		eventoEnunciado.setAdicionales(Adicional.DECO_PREMIUM);

		assertEquals(valorEsperado, eventoEnunciado.getPrecioTotalConDescuento(Descuentos.PORCENTUAL, descuento));
	}

	@Test
	public void ejercicioEnunciadoPrecioFinalConDescuentoNominal() {
		Double valorEsperado = 5320000.0;
		Double descuento = 300000.0;
		Evento eventoEnunciado = new Corporativo(2000000.0, 200, 6.0, 500);

		eventoEnunciado.setAdicionales(Adicional.CATERING);
		eventoEnunciado.setAdicionales(Adicional.DJ_SONIDO);
		eventoEnunciado.setAdicionales(Adicional.DECO_PREMIUM);
		eventoEnunciado.setAdicionales(Adicional.BANDA_EN_VIVO);

		assertEquals(valorEsperado, eventoEnunciado.getPrecioTotalConDescuento(Descuentos.NOMINAL, descuento));
	}
}
