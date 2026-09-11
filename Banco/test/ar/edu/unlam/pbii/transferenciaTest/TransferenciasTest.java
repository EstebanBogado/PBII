package ar.edu.unlam.pbii.transferenciaTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edulunlam.pbii.banco.Banco;
import ar.edulunlam.pbii.banco.CuentaDuplicadaException;
import ar.edulunlam.pbii.banco.MontoInvalidoException;
import ar.edulunlam.pbii.banco.TransferenciaInvalidaException;

class TransferenciasTest {
	private Banco banco;

	@BeforeEach
	public void setUp() {
		banco = new Banco();
	}

	@Test
	public void realizarUnaTransferenciaEntreDosCuentasConMontoNegativo()
			throws TransferenciaInvalidaException, MontoInvalidoException, CuentaDuplicadaException {
		banco.registrarCuenta("CA-1234", 1_000.0);
		banco.registrarCuenta("CC-1234", 2_000.0);

		assertThrows(MontoInvalidoException.class, () -> {
			banco.transferir("CA-1234", "CC-1234", -500.0);
		});
	}

	@Test
	public void realizarUnaTransferenciaEntreDosCuentasConMontoMayorAlSaldoDisponibleEnCBUOrigen()
			throws TransferenciaInvalidaException, MontoInvalidoException, CuentaDuplicadaException {
		banco.registrarCuenta("CA-1234", 1_000.0);
		banco.registrarCuenta("CC-1234", 2_000.0);

		assertThrows(MontoInvalidoException.class, () -> {
			banco.transferir("CA-1234", "CC-1234", 1_500.0);
		});
	}

	@Test
	public void realizarUnaTransferenciaEntreDosCuentasConMismoCBU()
			throws TransferenciaInvalidaException, MontoInvalidoException, CuentaDuplicadaException {
		banco.registrarCuenta("CA-1234", 1_000.0);
		banco.registrarCuenta("CC-1234", 2_000.0);

		assertThrows(TransferenciaInvalidaException.class, () -> {
			banco.transferir("CA-1234", "CA-1234", 500.0);
		});
	}

	@Test
	public void realizarUnaTransferenciaSatisfactoriamenteYMostrarLosSaldosNuevos()
			throws TransferenciaInvalidaException, MontoInvalidoException, CuentaDuplicadaException {
		Double saldoFinalOrigen = 300.0;
		Double saldoFinalDestino = 2_700.0;

		banco.registrarCuenta("CA-1234", 1_000.0);
		banco.registrarCuenta("CC-1234", 2_000.0);
		banco.transferir("CA-1234", "CC-1234", 700.0);

		assertEquals(saldoFinalOrigen, banco.getSaldo("CA-1234"));
		assertEquals(saldoFinalDestino, banco.getSaldo("CC-1234"));
	}

	@Test
	public void realizarUnaTransferenciaConErrorYQueLoAtrapeElCatch() 
			throws TransferenciaInvalidaException, MontoInvalidoException, CuentaDuplicadaException {

		banco.registrarCuenta("CA-1234", 1_000.0);
		banco.registrarCuenta("CC-1234", 2_000.0);
		
		assertTrue(banco.transferirConTryCatch("CA-1234", "CC-1234", -700.0));

		
	}
}