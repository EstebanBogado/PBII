package ar.edu.unlam.pbii.tunningCarTest;

import static org.junit.Assert.*;

import org.junit.Test;
import ar.edu.unlam.pbii.tuningCar.Auto;
import ar.edu.unlam.pbii.tuningCar.TipoDescuento;
import ar.edu.unlam.pbii.tuningCar.Accesorios;
import ar.edu.unlam.pbii.tuningCar.Vehiculo;

public class TunningCarTest {

	/*
	 * falta hacer los métodos de descuento porcentual y nominal
	 */

	@Test
	public void creacionDeUnAutoBasicoYQueSepaSiEsVelozONo() {
		Vehiculo autoBasico = new Auto(1000000.0, 4, 130, 5.5);

		assertFalse(autoBasico.esVeloz());
	}
	
	@Test
	public void creacionDeUnAutoBasicoYQueSepaSiEsDeportivoONo() {
		Vehiculo autoBasico = new Auto(1000000.0, 2, 180, 5.5);

		assertTrue(autoBasico.esDeportivo());
	}

	@Test
	public void crearUnAutoBasicoYConvertirloEnVelozConNitro() {
		Double valorEsperado = 1100000.0;
		Vehiculo autoBasico = new Auto(1000000.0, 4, 130, 5.5);

		autoBasico.setAccesorio(Accesorios.KIT_NITRO);
		Accesorios.KIT_NITRO.setCostoInstalacion(100000.0, autoBasico);
		assertTrue(autoBasico.esVeloz());
		assertEquals(valorEsperado, autoBasico.getPrecioTotal(), 0.01);
	}

	@Test
	public void crearUnAutoBasicoYQueAlAgregarleAccesoriosSepaCalcularSuCosto() {
		Double valorEsperado = 1145000.0;
		Vehiculo autoBasico = new Auto(1000000.0, 4, 130, 5.5);

		autoBasico.setAccesorio(Accesorios.KIT_NITRO);
		Accesorios.KIT_NITRO.setCostoInstalacion(100000.0, autoBasico);
		autoBasico.setAccesorio(Accesorios.ALARMA);
		Accesorios.ALARMA.setCostoAdicional(30000.0);
		Accesorios.ALARMA.setCostoInstalacion(45000.0, autoBasico);
		assertEquals(valorEsperado, autoBasico.getPrecioTotal(), 0.01);
	}

	@Test
	public void crearUnAutoDeportivoYQueAlAgregarleAccesoriosSepaCalcularSuCosto() {
		Double valorEsperado = 1175000.0;
		Vehiculo autoDeportivo = new Auto(1000000.0, 2, 180, 4.5);

		autoDeportivo.setAccesorio(Accesorios.KIT_NITRO);
		Accesorios.KIT_NITRO.setCostoInstalacion(100000.0, autoDeportivo);
		autoDeportivo.setAccesorio(Accesorios.ALARMA);
		Accesorios.ALARMA.setCostoAdicional(30000.0);
		Accesorios.ALARMA.setCostoInstalacion(45000.0, autoDeportivo);
		assertEquals(valorEsperado, autoDeportivo.getPrecioTotal(), 0.01);
	}

	@Test
	public void crearUnAutoDeportivoYAlAgregarleLevantaVidriosCorrigeSuPrecio() {
		Double valorEsperado = 1050000.0;
		Double precioPorPuerta = 25000.0;
		Vehiculo autoDeportivo = new Auto(1000000.0, 2, 180, 4.5);

		autoDeportivo.setAccesorio(Accesorios.LEVANTA_VIDRIOS);
		Accesorios.LEVANTA_VIDRIOS.setCostoInstalacion(precioPorPuerta, autoDeportivo);
		assertEquals(valorEsperado, autoDeportivo.getPrecioTotal(), 0.01);
	}

	@Test
	public void crearUnAutoBasicoEIncrementarSuCostoAlConvertirloEnVelozConNitroYPulido() {
		Double valorEsperado = 3700000.0;
		Double precioPulido = 20000.0;
		Auto autoBasico = new Auto(3500000.0, 4, 130, 6.0);

		autoBasico.setAccesorio(Accesorios.KIT_NITRO);
		Accesorios.KIT_NITRO.setCostoInstalacion(100000.0, autoBasico);
		autoBasico.setAccesorio(Accesorios.PULIDO);
		Accesorios.PULIDO.setCostoAdicional(5000.0);
		Accesorios.PULIDO.setCostoInstalacion(precioPulido, autoBasico);
		assertEquals(valorEsperado, autoBasico.getPrecioTotal(), 0.01);
	}

	@Test
	public void crearUnAutoBasicoYPulirloSinQueSupereLosCiemMil() {
		Double valorEsperado = 3590000.0;
		Double precioPulido = 15000.0;
		Auto autoBasico = new Auto(3500000.0, 4, 130, 6.0);

		autoBasico.setAccesorio(Accesorios.PULIDO);
		Accesorios.PULIDO.setCostoAdicional(5000.0);
		Accesorios.PULIDO.setCostoInstalacion(precioPulido, autoBasico);
		assertEquals(valorEsperado, autoBasico.getPrecioTotal(), 0.01);
	}

	@Test
	public void crearUnAutoDeportivoYColocarleEstereo() {
		Double valorEsperado = 6150000.0;
		Double costoInstalacion = 100000.0;
		Vehiculo autoDeportivo = new Auto(6000000.0, 2, 200, 5.0);

		autoDeportivo.setAccesorio(Accesorios.ESTEREO);
		Accesorios.ESTEREO.setCostoAdicional(25000.0);
		Accesorios.ESTEREO.setCostoInstalacion(costoInstalacion, autoDeportivo);
		autoDeportivo.setAccesorio(Accesorios.ALARMA);
		autoDeportivo.quitarAccesorio(Accesorios.ALARMA);
		assertEquals(valorEsperado, autoDeportivo.getPrecioTotal(), 0.01);
	}

	@Test
	public void crearUnVehiculoYAgragarleTodosLosAccesoriosYLuegoQuitarleLAAlarma() {
		Double valorAlarma = 50000.0;
		Double valorEstereo = 30000.0;
		Double valorNitro = 100000.0;
		Double valorLevantaVidrios = 25000.0;
		Double valorPulido = 50000.0;
		Double valorEsperado = 1480000.0;
		Vehiculo autoBasico = new Auto(1000000.0, 4, 130, 6.6);

		autoBasico.setAccesorio(Accesorios.ALARMA);
		Accesorios.ALARMA.setCostoAdicional(30000.0);
		Accesorios.ALARMA.setCostoInstalacion(valorAlarma, autoBasico);
		autoBasico.setAccesorio(Accesorios.ESTEREO);
		Accesorios.ESTEREO.setCostoAdicional(25000.0);
		Accesorios.ESTEREO.setCostoInstalacion(valorEstereo, autoBasico);
		autoBasico.setAccesorio(Accesorios.KIT_NITRO);
		Accesorios.KIT_NITRO.setCostoInstalacion(valorNitro, autoBasico);
		autoBasico.setAccesorio(Accesorios.LEVANTA_VIDRIOS);
		Accesorios.LEVANTA_VIDRIOS.setCostoInstalacion(valorLevantaVidrios, autoBasico);
		autoBasico.setAccesorio(Accesorios.PULIDO);
		Accesorios.PULIDO.setCostoAdicional(5000.0);
		Accesorios.PULIDO.setCostoInstalacion(valorPulido, autoBasico);
		assertEquals(valorEsperado, autoBasico.getPrecioTotal(), 0.01);
		autoBasico.quitarAccesorio(Accesorios.ALARMA);
		assertEquals(1430000.0, autoBasico.getPrecioTotal(), 0.01);
	}

	@Test
	public void crearUnAutoyCargarleAccesoriosYAplicarleDescuentoPorcentual() {
		Double valorAlarma = 50000.0;
		Double valorEstereo = 30000.0;
		Double valorNitro = 100000.0;
		Double valorLevantaVidrios = 25000.0;
		Double valorPulido = 50000.0;
		Double valorEsperado = 1406000.0;
		Double descuento = 0.05;
		Vehiculo autoBasico = new Auto(1000000.0, 4, 130, 6.6);

		autoBasico.setAccesorio(Accesorios.ALARMA);
		Accesorios.ALARMA.setCostoAdicional(30000.0);
		Accesorios.ALARMA.setCostoInstalacion(valorAlarma, autoBasico);
		autoBasico.setAccesorio(Accesorios.ESTEREO);
		Accesorios.ESTEREO.setCostoAdicional(25000.0);
		Accesorios.ESTEREO.setCostoInstalacion(valorEstereo, autoBasico);
		autoBasico.setAccesorio(Accesorios.KIT_NITRO);
		Accesorios.KIT_NITRO.setCostoInstalacion(valorNitro, autoBasico);
		autoBasico.setAccesorio(Accesorios.LEVANTA_VIDRIOS);
		Accesorios.LEVANTA_VIDRIOS.setCostoInstalacion(valorLevantaVidrios, autoBasico);
		autoBasico.setAccesorio(Accesorios.PULIDO);
		Accesorios.PULIDO.setCostoAdicional(5000.0);
		Accesorios.PULIDO.setCostoInstalacion(valorPulido, autoBasico);
		// assertEquals(valorEsperado, autoBasico.getPrecioTotal(), 0.01);
		autoBasico.setDescuento(TipoDescuento.PORCENTUAL, descuento);
		assertEquals(valorEsperado, autoBasico.getPrecioConDescuento(), 0.01);
	}

	@Test
	public void crearUnAutoyCargarleAccesoriosYAplicarleDescuentonNominal() {
		Double valorAlarma = 50000.0;
		Double valorEstereo = 30000.0;
		Double valorNitro = 100000.0;
		Double valorLevantaVidrios = 25000.0;
		Double valorPulido = 50000.0;
		Double valorEsperado = 1380000.0;
		Double precioTotal = 1480000.0;
		Double descuento = 100000.0;
		Vehiculo autoBasico = new Auto(1000000.0, 4, 130, 6.6);

		autoBasico.setAccesorio(Accesorios.ALARMA);
		Accesorios.ALARMA.setCostoAdicional(30000.0);
		Accesorios.ALARMA.setCostoInstalacion(valorAlarma, autoBasico);
		autoBasico.setAccesorio(Accesorios.ESTEREO);
		Accesorios.ESTEREO.setCostoAdicional(25000.0);
		Accesorios.ESTEREO.setCostoInstalacion(valorEstereo, autoBasico);
		autoBasico.setAccesorio(Accesorios.KIT_NITRO);
		Accesorios.KIT_NITRO.setCostoInstalacion(valorNitro, autoBasico);
		autoBasico.setAccesorio(Accesorios.LEVANTA_VIDRIOS);
		Accesorios.LEVANTA_VIDRIOS.setCostoInstalacion(valorLevantaVidrios, autoBasico);
		autoBasico.setAccesorio(Accesorios.PULIDO);
		Accesorios.PULIDO.setCostoAdicional(5000.0);
		Accesorios.PULIDO.setCostoInstalacion(valorPulido, autoBasico);
		assertEquals(precioTotal, autoBasico.getPrecioTotal(), 0.01);
		autoBasico.setDescuento(TipoDescuento.NOMINAL, descuento);
		assertEquals(valorEsperado, autoBasico.getPrecioConDescuento(), 0.01);
	}

	@Test
	public void ejercicioDelEnunciado() {
		Auto autoEnunciado = new Auto(5000000.0, 4, 170, 5.0);
		Double levantaVidrios = 30000.0;
		Double instalacionEstereo = 15000.0;
		Double precioParlante = 20000.0;
		Double pulido = 25000.0;
		Double valorEsperado = 5315000.0;

		autoEnunciado.setAccesorio(Accesorios.LEVANTA_VIDRIOS);
		Accesorios.LEVANTA_VIDRIOS.setCostoInstalacion(levantaVidrios, autoEnunciado);
		autoEnunciado.setAccesorio(Accesorios.ESTEREO);
		Accesorios.ESTEREO.setCostoAdicional(precioParlante);
		Accesorios.ESTEREO.setCostoInstalacion(instalacionEstereo, autoEnunciado);
		autoEnunciado.setAccesorio(Accesorios.PULIDO);
		Accesorios.PULIDO.setCostoAdicional(5000.0);
		Accesorios.PULIDO.setCostoInstalacion(pulido, autoEnunciado);
		assertEquals(valorEsperado, autoEnunciado.getPrecioTotal(), 0.01);
	}
	
	@Test
	public void ejercicioDelEnunciadoDiezPorCeinteDeDescuento() {
		Auto autoEnunciado = new Auto(5000000.0, 4, 170, 5.0);
		Double levantaVidrios = 30000.0;
		Double instalacionEstereo = 15000.0;
		Double precioParlante = 20000.0;
		Double pulido = 25000.0;
		Double valorEsperado = 4783500.0;
		Double valorDescuento = 0.10;

		autoEnunciado.setAccesorio(Accesorios.LEVANTA_VIDRIOS);
		Accesorios.LEVANTA_VIDRIOS.setCostoInstalacion(levantaVidrios, autoEnunciado);
		autoEnunciado.setAccesorio(Accesorios.ESTEREO);
		Accesorios.ESTEREO.setCostoAdicional(precioParlante);
		Accesorios.ESTEREO.setCostoInstalacion(instalacionEstereo, autoEnunciado);
		autoEnunciado.setAccesorio(Accesorios.PULIDO);
		Accesorios.PULIDO.setCostoAdicional(5000.0);
		Accesorios.PULIDO.setCostoInstalacion(pulido, autoEnunciado);
		autoEnunciado.getPrecioTotal();
		autoEnunciado.setDescuento(TipoDescuento.PORCENTUAL, valorDescuento);
		assertEquals(valorEsperado, autoEnunciado.getPrecioConDescuento(), 0.01);
	}
	
	@Test
	public void ejercicioDelEnunciadoDoscientosmilPesosDeDescuento() {
		Auto autoEnunciado = new Auto(5000000.0, 4, 170, 5.0);
		Double levantaVidrios = 30000.0;
		Double instalacionEstereo = 15000.0;
		Double precioParlante = 20000.0;
		Double pulido = 25000.0;
		Double valorEsperado = 5115000.0;
		Double valorDescuento =200000.0;

		autoEnunciado.setAccesorio(Accesorios.LEVANTA_VIDRIOS);
		Accesorios.LEVANTA_VIDRIOS.setCostoInstalacion(levantaVidrios, autoEnunciado);
		autoEnunciado.setAccesorio(Accesorios.ESTEREO);
		Accesorios.ESTEREO.setCostoAdicional(precioParlante);
		Accesorios.ESTEREO.setCostoInstalacion(instalacionEstereo, autoEnunciado);
		autoEnunciado.setAccesorio(Accesorios.PULIDO);
		Accesorios.PULIDO.setCostoAdicional(5000.0);
		Accesorios.PULIDO.setCostoInstalacion(pulido, autoEnunciado);
		autoEnunciado.getPrecioTotal();
		autoEnunciado.setDescuento(TipoDescuento.NOMINAL, valorDescuento);
		assertEquals(valorEsperado, autoEnunciado.getPrecioConDescuento(), 0.01);
	}
}
