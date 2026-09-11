package ar.edu.unlam.pbii.amarrasTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pbii.amarras.Amarra;

class AmarraTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void crearUnaAmarra() {
		Amarra amarra = new Amarra(1, 10.0);
		assertNotNull(amarra);
	}

}
