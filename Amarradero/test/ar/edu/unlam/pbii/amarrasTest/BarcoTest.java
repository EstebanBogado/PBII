package ar.edu.unlam.pbii.amarrasTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unlam.pbii.amarras.Amarra;
import ar.edu.unlam.pbii.amarras.Barco;
import ar.edu.unlam.pbii.amarras.NoSePuedeAmarrarException;
import ar.edu.unlam.pbii.amarras.Velero;

class BarcoTest {

	@Test
	public void crearUnYateAVelaYQueSeaAmarrable() throws NoSePuedeAmarrarException {
		Barco velero = new Velero("Velero 1", 3.5, 8.0);

		Amarra amarra = new Amarra(1, 40.0);
		assertTrue(velero.sePuedeAmarrar(amarra));
	}

}
