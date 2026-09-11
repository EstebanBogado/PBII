package ar.edu.unlam.pbii.cuentaTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edulunlam.pbii.banco.Banco;
import ar.edulunlam.pbii.banco.CuentaDuplicadaException;
import ar.edulunlam.pbii.banco.MontoInvalidoException;

class CuentaTest {

	private Banco banco;

	@BeforeEach
	public void setUp() throws Exception {
		banco = new Banco();
	}

	@Test
	public void intentarCrearUnaCuentaDuplicadaYQueNoLoPermita()
			throws MontoInvalidoException, CuentaDuplicadaException {
		banco.registrarCuenta("CA-1234", 1_000.0);

		assertThrows(CuentaDuplicadaException.class, () -> {
			banco.registrarCuenta("CA-1234", 1_500.0);
		});
	}

	@Test
	public void intentarRetirarDeUnaCuentaUnMontoMayorAlSaldo()
			throws Exception { //MontoInvalidoException, CuentaDuplicadaException {
		banco.registrarCuenta("CA-1234", 1_000.0);

		assertThrows(MontoInvalidoException.class, () -> {
			banco.retirar("CA-1234", 1_500.0);
		});
	}

}
