package ar.edulunlam.pbii.bancoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edulunlam.pbii.banco.Banco;
import ar.edulunlam.pbii.banco.MontoInvalidoException;

class BancoTest {
	private Banco banco;

	@BeforeEach
	public void setUp() throws Exception {
		banco = new Banco();
	}

	@Test
	public void registrarCuentaYConsultarSaldoExitosamente() throws Exception {
		banco.registrarCuenta("CBU-123", 1_000.0);
		assertEquals(1_000.0, banco.getSaldo("CBU-123"));
	}

	@Test
	public void rechazarAltaDeCuentaConSaldoNegativo() throws Exception {
		assertThrows(MontoInvalidoException.class, () -> {
			banco.registrarCuenta("CBU-123", -1_000.0);
		});
	}

	@Test
	public void hacerDepositoYRetiroDeUnaCuentaYBuscarlaPorCBU() throws Exception {
		banco.registrarCuenta("CBU-123", 1_000.0);

		assertThrows(MontoInvalidoException.class, () -> {
			banco.depositar("CBU-123", -500.0);
		});

		assertThrows(MontoInvalidoException.class, () -> {
			banco.retirar("CBU-123", 5_500.0);
		});
	}
}
