package ar.edu.unlampb2.contenidoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.contenido.Documental;

public class DocumentalTest {

	@Test
	public void alConsultarElCostoDeUnDocumentalDebeSumarElCostoIDRAAlCostoBase() {
		Documental documental = new Documental("Our Planet", 0.5);
		Documental.setCanonIDRA(0.5);
		Double costoObtenido = documental.getCostoTotal();
		assertEquals(1.0, costoObtenido, 0.01);
	}

}
