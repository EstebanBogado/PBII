package ar.edu.unlam.pbii.cuentaBancariaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pbii.cuentaBancaria.CajaAhorro;
import ar.edu.unlam.pbii.cuentaBancaria.Cuenta;
import ar.edu.unlam.pbii.cuentaBancaria.TipoDeCuenta;

public class CajaDeAhorroTest {

	@Test
	public void crearUnaCajaDeAhorroYQueSepaDevolverSusDatos() {
		Cuenta cajaAhorro = new CajaAhorro(TipoDeCuenta.CAJA_DE_AHORRO, 4321, 0.0);
		Double valorEsperado = 0.0;
		Integer nroCuenta = 4321;

		assertEquals(valorEsperado, cajaAhorro.getSaldo());
		assertEquals(Integer.valueOf(nroCuenta), cajaAhorro.getNroCuentas());
	}

	@Test
	public void queHabiendoUnaCajaDeAhorroValideElSaldoYCobreLaComisionDespuesDeLaQuintaExtraccion() {
		Cuenta cajaAhorro = new CajaAhorro(TipoDeCuenta.CAJA_DE_AHORRO, 4321, 0.0);
		Double valorEsperado = 29988.0;
		TipoDeCuenta.CAJA_DE_AHORRO.setComision(6.0);

		cajaAhorro.depositar(100000.0);
		for (int i = 0; i <= 6; i++) {
			cajaAhorro.extraer(10000.0);
		}
		assertEquals(valorEsperado, cajaAhorro.getSaldo());
	}

	@Test
	public void realizarExtraccionesEInformarOperacionInvalidaPorFaltaDeSaldo() {
		Cuenta cajaAhorro = new CajaAhorro(TipoDeCuenta.CAJA_DE_AHORRO, 4321, 0.0);
		Double valorEsperado = 0.0;
		TipoDeCuenta.CAJA_DE_AHORRO.setComision(6.0);
		cajaAhorro.depositar(100000.0);
		cajaAhorro.extraer(110000.0);
		assertEquals(valorEsperado, cajaAhorro.getSaldo());
	}
}
