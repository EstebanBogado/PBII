package ar.edu.unlam.pbii.amarrasTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pbii.amarras.Amarra;
import ar.edu.unlam.pbii.amarras.AmarraExistenteException;
import ar.edu.unlam.pbii.amarras.Barco;
import ar.edu.unlam.pbii.amarras.CantMaximaAmarrasException;
import ar.edu.unlam.pbii.amarras.EsAmarrable;
import ar.edu.unlam.pbii.amarras.Fondeadero;
import ar.edu.unlam.pbii.amarras.NoSePuedeAmarrarException;
import ar.edu.unlam.pbii.amarras.Velero;
import ar.edu.unlam.pbii.amarras.Yate;

class FondeaderoTest {
	Fondeadero fondeadero;

	@BeforeEach
	void setUp() throws Exception {
		fondeadero = new Fondeadero(2);
	}

	@Test
	void crearElFondeaderoYQueRecibaYMuestreLaCantidadDeAmarras()
			throws AmarraExistenteException, CantMaximaAmarrasException {
		Integer valorEsperado = 2;
		Amarra amarra1 = new Amarra(1, 15.0);
		Amarra amarra2 = new Amarra(2, 10.0);
		fondeadero.agregarAmarra(amarra1);
		fondeadero.agregarAmarra(amarra2);

		assertEquals(Integer.valueOf(valorEsperado), fondeadero.getAmarrasCreadas());
		assertEquals(Integer.valueOf(valorEsperado), fondeadero.getAmarrasLibres());
		assertEquals(Integer.valueOf(0), fondeadero.getAmarrasOcupadas());
	}

	@Test
	public void crearUnaAmarraDuplicadaYQueArrojeAmarraExsistenteException()
			throws AmarraExistenteException, CantMaximaAmarrasException {
		Amarra amarra1 = new Amarra(1, 15.0);
		Amarra amarra2 = new Amarra(1, 20.0);

		fondeadero.agregarAmarra(amarra1);
		assertThrows(AmarraExistenteException.class, () -> {
			fondeadero.agregarAmarra(amarra2);
		});
	}

	@Test
	public void crearTresAmarrasCuandoSoloSePuedenCrearDosYQueArrojeCantMaximaAmarrasException()
			throws AmarraExistenteException, CantMaximaAmarrasException {
		Amarra amarra1 = new Amarra(1, 15.0);
		Amarra amarra2 = new Amarra(2, 20.0);
		Amarra amarra3 = new Amarra(3, 30.0);

		fondeadero.agregarAmarra(amarra1);
		fondeadero.agregarAmarra(amarra3);
		assertThrows(CantMaximaAmarrasException.class, () -> {
			fondeadero.agregarAmarra(amarra2);
		});
	}

	@Test
	public void crearDosAmarraLibresYPoderOcuparUna()
			throws AmarraExistenteException, CantMaximaAmarrasException, NoSePuedeAmarrarException {
		Amarra amarra1 = new Amarra(1, 15.0);
		Amarra amarra2 = new Amarra(2, 20.0);
		Barco barco = new Yate("barco 1", 2.0, 7.0);

		fondeadero.agregarAmarra(amarra1);
		fondeadero.agregarAmarra(amarra2);
		if (barco.sePuedeAmarrar(amarra2)) {
			fondeadero.amarrarBarco(barco, amarra2);
		}
		assertEquals(Integer.valueOf(1), fondeadero.getAmarrasLibres());
		assertEquals(Integer.valueOf(1), fondeadero.getAmarrasOcupadas());
	}

	@Test
	public void crearUnYateAMotorYAmarrarlo()
			throws AmarraExistenteException, CantMaximaAmarrasException, NoSePuedeAmarrarException {
		Amarra amarra1 = new Amarra(1, 25.0);
		Barco yateMotor = new Yate("Yate", 7.5, 3.0);

		fondeadero.agregarAmarra(amarra1);
		assertTrue(yateMotor.sePuedeAmarrar(amarra1));
		fondeadero.amarrarBarco(yateMotor, amarra1);
		assertEquals(Integer.valueOf(0), fondeadero.getAmarrasLibres());
	}

	@Test
	public void ocuparUnaAmarraOcuparlaYLiberarla()
			throws AmarraExistenteException, CantMaximaAmarrasException, NoSePuedeAmarrarException {
		Amarra amarra = new Amarra(1, 45.0);
		Amarra amarra1 = new Amarra(2, 45.0);
		Barco barco = new Velero("barco", 12.0, 3.0);

		fondeadero.agregarAmarra(amarra);
		fondeadero.agregarAmarra(amarra1);
		fondeadero.amarrarBarco(barco, amarra);
		assertEquals(Integer.valueOf(1), fondeadero.getAmarrasLibres());
		fondeadero.liberarAmarra(amarra);
		assertEquals(Integer.valueOf(0), fondeadero.getAmarrasOcupadas());
	}

	@Test
	public void obtenerElPrecioSegunElTipoDeEmbarcacion()
			throws AmarraExistenteException, CantMaximaAmarrasException, NoSePuedeAmarrarException {
		Amarra amarra1 = new Amarra(1, 145.0);
		Barco velero = new Velero("Velero", 22.0, 3.0);

		fondeadero.agregarAmarra(amarra1);
		fondeadero.amarrarBarco(velero, amarra1);
		assertEquals(12_000.0, fondeadero.precioAlquilerAmarra(velero));
	}

	@Test
	public void obtenerLaFacturacionTotalDelAmarradero()
			throws AmarraExistenteException, CantMaximaAmarrasException, NoSePuedeAmarrarException {
		Amarra amarra1 = new Amarra(1, 145.0);
		Amarra amarra2 = new Amarra(2, 300.0);
		Yate yate = new Yate("Yate", 35.0, 7.0);
		Barco velero = new Velero("Velero", 22.0, 3.0);

		fondeadero.agregarAmarra(amarra1);
		fondeadero.amarrarBarco(velero, amarra1);
		fondeadero.agregarAmarra(amarra2);
		fondeadero.amarrarBarco(yate, amarra2);
		assertEquals(25_000.0, fondeadero.fecturacionTotal());
	}
}
