package ar.edu.unlam.pbii.cuentaBancariaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pbii.cuentaBancaria.Cuenta;
import ar.edu.unlam.pbii.cuentaBancaria.CuentaSueldo;
import ar.edu.unlam.pbii.cuentaBancaria.TipoDeCuenta;

public class CuentaSueldoTest {

	@Test
	public void crearUnaCuentaSueldoYQueDevuelvaSuSaldoYNroDeCuenta() {
		Cuenta cuentaSueldo = new CuentaSueldo(TipoDeCuenta.CUENTA_SUELDO, 1234, 0.0);
		Double saldo = 0.0;
		Integer nroCuenta = 1234;

		assertEquals(saldo, cuentaSueldo.getSaldo(), 0.01);
		assertEquals(Integer.valueOf(nroCuenta), Integer.valueOf(cuentaSueldo.getNroCuentas()));
	}

	@Test
	public void creadaLaCuentaSueldoHacerUnDeposito() {
		Cuenta cuentasSueldo = new CuentaSueldo(TipoDeCuenta.CUENTA_SUELDO, 1234, 0.0);
		Double valorEsperado = 100000.0;
		Double importe = 100000.0;

		cuentasSueldo.depositar(importe);
		assertEquals(valorEsperado, cuentasSueldo.getSaldo());

	}

	@Test
	public void existiendoUnaCuentaSueldoNoPermitaExtraccionesMayoresAlSaldo() {
		Cuenta cuentaSueldo = new CuentaSueldo(TipoDeCuenta.CUENTA_SUELDO, 1234, 199999.0);
		Double importe = 200000.0;

		cuentaSueldo.extraer(importe);
		assertTrue(cuentaSueldo.operacionInvalida());
	}

}
