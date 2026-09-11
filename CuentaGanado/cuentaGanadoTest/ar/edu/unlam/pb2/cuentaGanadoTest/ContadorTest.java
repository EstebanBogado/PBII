package ar.edu.unlam.pb2.cuentaGanadoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.cuentaGanado.Contador;

public class ContadorTest {



	@Test
	public void crearUnCuentaGanadoYQueEsteEnCero() {
		Integer esperado = 0;
		Contador contadorUno = new Contador();
		assertEquals(Integer.valueOf(esperado), contadorUno.getCantidad());
	}

	@Test
	public void crearUnCuentaGanadoYQueCuenteUno() {
		Integer esperado = 1;
		Contador contadorUno = new Contador();
		assertEquals(Integer.valueOf(esperado), contadorUno.sumarUno());
	}

	@Test
	public void crearUnCuentaGanadoYQueCuenteDiez() {
		Integer esperado = 10;
		Contador contador = new Contador();
		for (int i = 0; i < 10; i++) {
			contador.sumador();
		}
		assertEquals(Integer.valueOf(esperado), contador.getCantidad());
	}

	@Test
	public void crearUnCuentaGanadoYQueSePuedaResetear() {
		Integer esperado = 0;
		Contador contador = new Contador();
		for (int i = 0; i < 10; i++) {
			contador.sumador();
		}
		contador.resetearContador();
		assertEquals(Integer.valueOf(esperado), contador.getCantidad());
	}

	@Test
	public void crearUnCuentaGanadoYQueSeReseteeSiLlegaAlLimite() {
		Integer esperado = 0;
		Integer cantidadDePrueba = 9999;
		Contador contador = new Contador();
		for (int i = 0; i < cantidadDePrueba; i++) {
			contador.sumador();
		}
		contador.sumador();
		contador.autoReset(contador.getCantidad());
		assertEquals(Integer.valueOf(esperado), contador.getCantidad());
	}
}