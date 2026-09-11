package ar.edu.unlam.pbii.cuentaBancariaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pbii.cuentaBancaria.Cuenta;
import ar.edu.unlam.pbii.cuentaBancaria.CuentaCorriente;
import ar.edu.unlam.pbii.cuentaBancaria.TipoDeCuenta;

public class CuentaCorrienteTest {

	@Test
	public void crearUnaCuentaCorrienteYQueDevuelvaElSaldoInicialYQueSePuedaSetearElSaldoEnDescubierto() {
		Cuenta cuentaCorriente = new CuentaCorriente(TipoDeCuenta.CUENTA_CORRIENTE, 1234, 0.0, 10000.0);
		Double saldoEsperado = 0.0;
		Double disponibleEsperado = 10000.0;

		assertEquals(saldoEsperado, cuentaCorriente.getSaldo());
		assertEquals(disponibleEsperado, cuentaCorriente.getDescubierto());
	}

	@Test
	public void creadaLaCCPermitirQueSinSaldoSePuedaExtraerHastaElLimiteDescubierto() {
		Cuenta cuentaCorriente = new CuentaCorriente(TipoDeCuenta.CUENTA_CORRIENTE, 1234, 5000.0, 10000.0);
		Double saldoEsperado1 = -8400.0;
		Double saldoEsperado2 = -10500.0;
		Double saldoEsperado3 = 4500.0;
		Double descubiertoEsperado2 = 10000.0;
		Double deposito = 15000.0;

		cuentaCorriente.extraer(13000.0);
		assertEquals(saldoEsperado1, cuentaCorriente.getSaldo());
		cuentaCorriente.extraer(2000.0);
		assertEquals(saldoEsperado2, cuentaCorriente.getSaldo());
		cuentaCorriente.depositar(deposito);
		assertEquals(saldoEsperado3, cuentaCorriente.getSaldo());
		assertEquals(descubiertoEsperado2, cuentaCorriente.getDescubierto());
	}

	@Test
	public void creadaLaCCPermitirQueSinSaldoSePuedaExtraerHastaElLimiteDescubiertoYCalculaLosPunitorios() {
		Cuenta cuentaCorriente = new CuentaCorriente(TipoDeCuenta.CUENTA_CORRIENTE, 1234, 5000.0, 10000.0);
		Double saldoEsperado1 = -8400.0;
		Double saldoEsperado2 = -10500.0;
		Double saldoEsperado3 = 4500.0;
		Double descubiertoEsperado = 10000.0;
		Double deposito = 15000.0;

		cuentaCorriente.extraer(13000.0);
		System.out.println(cuentaCorriente.getDescubierto());
		System.out.println(cuentaCorriente.getSaldo());
		assertEquals(saldoEsperado1, cuentaCorriente.getSaldo());
		cuentaCorriente.extraer(2000.0);
		assertEquals(saldoEsperado2, cuentaCorriente.getSaldo());
		cuentaCorriente.depositar(deposito);
		assertEquals(saldoEsperado3, cuentaCorriente.getSaldo());
		assertEquals(descubiertoEsperado, cuentaCorriente.getDescubierto());
	}
}
