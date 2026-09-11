package ar.edu.unlam.alumno.pbii.simuladorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.alumno.pbii.simulador.Accesorios;
import ar.edu.unlam.alumno.pbii.simulador.Auto;
import ar.edu.unlam.alumno.pbii.simulador.Descuentos;

public class SimuladorTest {

	@Test
	public void crearUnAutoBasicoYQueDevuelvaSusCaracteristicas() {
		Auto autoBasico = new Auto(1500.0, 4, 130, 15.5);

		assertEquals(1500.0, autoBasico.getPrecioBase(), 0.01);
		assertEquals(Integer.valueOf(4), autoBasico.getCantPuertas());
		assertEquals(Integer.valueOf(130), autoBasico.getVelMax());
		assertEquals(15.5, autoBasico.getSuperficie(), 0.01);
		assertNotNull(autoBasico);
		assertFalse(autoBasico.esVeloz());
	}
	
	@Test
	public void unVehiculoConMasDe140kmHEsVeloz() {
		Auto autoVeloz = new Auto(250000.0, 4, 180, 5.0);
		assertTrue(autoVeloz.esVeloz());
	}
	
	@Test
	public void unVehiculoConMasDe140kmHYDosPuertasEsDeportivo() {
		Auto autoVeloz = new Auto(250000.0, 2, 180, 5.0);
		assertTrue(autoVeloz.esDeportivo());
	}

	@Test
	public void alAutoBasicoConvertirloEnVeloz() {
		Double valorEsperado = 390000.0;
		Double valorObtenido = 0.0;
		Auto autoBasico = new Auto(150000.0, 4, 130, 15.5);
		Accesorios.KIT_NITRO.setPrecioNitro(100000.0);
		autoBasico.setAccesorio(Accesorios.KIT_NITRO);
		Accesorios.ALARMA.setPrecioAlarma(45000.0, 0.0);
		autoBasico.setAccesorio(Accesorios.ALARMA);
		Accesorios.ESTEREO.setCostoEstereo(15000.0, 20000.0);
		autoBasico.setAccesorio(Accesorios.ESTEREO);
		valorObtenido = autoBasico.getPrecioFinal();
		assertEquals(valorEsperado, valorObtenido, 0.01);
		assertTrue(autoBasico.esVeloz());
	}
	
//	@Test
//	public void alAutoBasicoConvertirloEnVeloz() {
//		Double valorEsperado = 390000.0;
//		Double valorObtenido = 0.0;
//		Auto autoBasico = new Auto(150000.0, 4, 130, 15.5);
//		Accesorios.KIT_NITRO.setPrecioNitro(100000.0);
//		autoBasico.setAccesorio(Accesorios.KIT_NITRO);
//		Accesorios.ALARMA.setPrecioAlarma(45000.0, 0.0);
//		autoBasico.setAccesorio(Accesorios.ALARMA);
//		Accesorios.ESTEREO.setCostoEstereo(15000.0, 20000.0);
//		autoBasico.setAccesorio(Accesorios.ESTEREO);
//		valorObtenido = autoBasico.getPrecioFinal();
//		assertEquals(valorEsperado, valorObtenido, 0.01);
//		assertTrue(autoBasico.esVeloz());
//	}

	@Test
	public void alAutoBasicoAgregarleAccesoriosYLuegoRemoverlosYQueTengaElPrecioBase() {
		Double valorEsperado = 295000.0;
		Double valorObtenido = 0.0;
		Auto autoBasico = new Auto(150000.0, 4, 130, 15.5);
		autoBasico.setAccesorio(Accesorios.KIT_NITRO);
		autoBasico.setAccesorio(Accesorios.ALARMA);
		valorObtenido = autoBasico.getPrecioFinal();
		assertEquals(valorEsperado, valorObtenido, 0.01);
		autoBasico.quitarAccesorio(Accesorios.ALARMA);
		autoBasico.quitarAccesorio(Accesorios.KIT_NITRO);
		assertEquals(autoBasico.getPrecioFinal(), autoBasico.getPrecioBase(), 0.01);
	}

	@Test
	public void alAutoBasicoAgregarleAccesoriosModificarSuPrecioBaseYAplicarDescuentoCincoPorciento() {
		Double valorEsperado = 280250.0;
		Double valorObtenido = 0.0;
		Auto autoBasico = new Auto(150000.0, 4, 130, 15.5);
		autoBasico.setAccesorio(Accesorios.KIT_NITRO);
		autoBasico.setAccesorio(Accesorios.ALARMA);
		autoBasico.getPrecioFinal();
		autoBasico.setDescuento(0.05);
		autoBasico.getDescuento(Descuentos.DESCUENTO_PORCENTUAL);
		valorObtenido = autoBasico.getPrecioConDescuento();
		assertEquals(valorEsperado, valorObtenido, 0.01);
	}

	@Test
	public void alAutoBasicoAgregarleAccesoriosModificarSuPrecioBaseYAplicarDescuentoCienMilPesos() {
		Double valorEsperado = 195000.0;
		Double valorObtenido = 0.0;
		Auto autoBasico = new Auto(150000.0, 4, 130, 15.5);
		autoBasico.setAccesorio(Accesorios.KIT_NITRO);
		autoBasico.setAccesorio(Accesorios.ALARMA);
		autoBasico.getPrecioFinal();
		autoBasico.setDescuento(100000.0);
		autoBasico.getDescuento(Descuentos.DESCUENTO_NOMINAL);
		valorObtenido = autoBasico.getPrecioConDescuento();
		assertEquals(valorEsperado, valorObtenido, 0.01);
	}

	@Test
	public void testeoDelEjercicioDelEnunciadoSinDescuentos() {
		Double valorEsperado = 5315000.0;
		Double valorObtenido = 0.0;
		Auto autoBasico = new Auto(5000000.0, 4, 170, 5.0);
		Accesorios.LEVANTA_VIDRIOS.setLevantaVidrio(30000.0);
		autoBasico.setAccesorio(Accesorios.LEVANTA_VIDRIOS);
		Accesorios.ESTEREO.setCostoEstereo(15000.0, 20000.0);
		autoBasico.setAccesorio(Accesorios.ESTEREO);
		Accesorios.PULIDO.setBasePulido(25000.0);
		autoBasico.setAccesorio(Accesorios.PULIDO);
		valorObtenido = autoBasico.getPrecioFinal();
		assertEquals(valorEsperado, valorObtenido, 0.01);
	}
	
	@Test
	public void testeoDelEjercicioDelEnunciadoConDescuentoDiezPoriciento() {
		Double valorEsperado = 4783500.0;
		Double valorObtenido = 0.0;
		Auto autoBasico = new Auto(5000000.0, 4, 170, 5.0);
		Accesorios.LEVANTA_VIDRIOS.setLevantaVidrio(30000.0);
		autoBasico.setAccesorio(Accesorios.LEVANTA_VIDRIOS);
		Accesorios.ESTEREO.setCostoEstereo(15000.0, 20000.0);
		autoBasico.setAccesorio(Accesorios.ESTEREO);
		Accesorios.PULIDO.setBasePulido(25000.0);
		autoBasico.setAccesorio(Accesorios.PULIDO);
		autoBasico.setDescuento(0.10);
		autoBasico.getDescuento(Descuentos.DESCUENTO_PORCENTUAL);
		valorObtenido = autoBasico.getPrecioConDescuento();
		assertEquals(valorEsperado, valorObtenido, 0.01);
	}
	
	@Test
	public void testeoDelEjercicioDelEnunciadoConDescuento200MilPesos() {
		Double valorEsperado = 5115000.0;
		Double valorObtenido = 0.0;
		Auto autoBasico = new Auto(5000000.0, 4, 170, 5.0);
		Accesorios.LEVANTA_VIDRIOS.setLevantaVidrio(30000.0);
		autoBasico.setAccesorio(Accesorios.LEVANTA_VIDRIOS);
		Accesorios.ESTEREO.setCostoEstereo(15000.0, 20000.0);
		autoBasico.setAccesorio(Accesorios.ESTEREO);
		Accesorios.PULIDO.setBasePulido(25000.0);
		autoBasico.setAccesorio(Accesorios.PULIDO);
		autoBasico.setDescuento(200000.0);
		autoBasico.getDescuento(Descuentos.DESCUENTO_NOMINAL);
		valorObtenido = autoBasico.getPrecioConDescuento();
		assertEquals(valorEsperado, valorObtenido, 0.01);
	}
}
