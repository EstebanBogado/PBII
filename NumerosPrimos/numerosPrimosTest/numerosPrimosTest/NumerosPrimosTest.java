package numerosPrimosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import numerosPrimos.NumerosPrimos;

public class NumerosPrimosTest {

	@Test
	public void ingresarUnNumer0ParYQueNoSeaPrimo() {
		NumerosPrimos primos = new NumerosPrimos(4);
		assertFalse(primos.esPrimo());
	}

	@Test
	public void ingresarUnNumerImparPrimoYQueSeaTrue() {
		NumerosPrimos primos = new NumerosPrimos(347847551);
		assertTrue(primos.esPrimo());
	}

	@Test
	public void ingresarUnNumerImparNoPrimoYQueSeaFalse() {
		NumerosPrimos primos = new NumerosPrimos(347864531);
		assertFalse(primos.esPrimo());
	}
	
	@Test
	public void demostrarQue137NoEsPrimo() {
		NumerosPrimos primos = new NumerosPrimos(137);
		assertTrue(primos.esPrimo());
	}
}