package ar.edu.unlam.pb2.cajaFuerteTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.cajaFuerte.CajaFuerte;

public class CajaFuerteTest {

	// AL CREARSE UNA CAJA FUERTE NUEVA, POR DEFECTO SU ESTADO ES ABIERTA
	CajaFuerte cajaNueva = new CajaFuerte();

	@Test
	public void crearUnaCajaFuerteYQueEsteAbierta() {
		Boolean cajaFuerteAbierta = null;
		cajaFuerteAbierta = cajaNueva.getStatusInicial();
		assertTrue(cajaFuerteAbierta);
	}

	@Test
	public void cerrarLaCajaSoloConElCodigoCorrecto() {
		// En esta operación,la caja estaba abierta por defecto y se procedió a generar
		// un código y cerrarla
		cajaNueva.generarClave('#', '*', 1234);
		cajaNueva.setClaveIngresada(1234);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		assertTrue(cajaNueva.cerrada());
	}

	@Test
	public void ingresarUnCodigoIncorrectoYQueNoseCierre() {
		// En esta operación,la caja estaba abierta por defecto y se procedió a generar
		// un código y cerrarla
		cajaNueva.generarClave('#', '*', 1234);
		cajaNueva.setClaveIngresada(1);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		assertFalse(cajaNueva.cerrada());
	}

	@Test
	public void unaVezCerradaLaCajaPoderAbrirlaConElCodigoCorrecto() {
		cajaNueva.generarClave('#', '*', 1234);
		// En esta operación,la caja estaba abierta por defecto y se procedió a cerrarla
		cajaNueva.cerrarCajaFuerte();
		// En esta operación, la caja estaba cerrada y se procedió a abrirla con el
		// código
		cajaNueva.setClaveIngresada(1234);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		assertTrue(cajaNueva.abierta());
	}

	@Test
	public void ingresarUnaClaveErroneaYQueNoAbra() {
		// se cierra la caja y luego se introduce un código incorrecto y la caja
		// permanece cerrada
		cajaNueva.generarClave('#', '*', 1234);
		cajaNueva.cerrarCajaFuerte();
		cajaNueva.setClaveIngresada(1);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		assertTrue(cajaNueva.cerrada());
	}

	@Test
	public void ingresarUnaClaveErroneaTresVecesYQueSeBloquee() {
		cajaNueva.generarClave('#', '*', 1234);
		// se cierra la caja y luego se introduce tres veces un código incorrecto y la
		// caja bloqueada
		cajaNueva.setClaveIngresada(1);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		cajaNueva.setClaveIngresada(2);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		cajaNueva.setClaveIngresada(3);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		assertTrue(cajaNueva.getBloqueada());
	}

	@Test
	public void unaVezBloqueadaLaCajaNoSePuedaAbrir() {
		cajaNueva.generarClave('#', '*', 1234);
		// se cierra la caja y luego se introduce tres veces un código incorrecto y la
		// caja bloqueada y no puede abrirse con la clave correcta
		cajaNueva.setClaveIngresada(1);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		cajaNueva.setClaveIngresada(2);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		cajaNueva.setClaveIngresada(3);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		cajaNueva.setClaveIngresada(1234);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		assertTrue(cajaNueva.getBloqueada());
	}

	@Test
	public void desbloquearResetearClaveDeLaCajaConlaMasterKey() {
		Integer claveMaestra = 1111;
		cajaNueva.generarClave('#', '*', 1234);
		// se cierra la caja y luego se introduce tres veces un código incorrecto y la
		// caja bloqueada y no puede abrirse con la clave correcta
		cajaNueva.setClaveIngresada(1);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		cajaNueva.setClaveIngresada(2);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		cajaNueva.setClaveIngresada(3);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		cajaNueva.setClaveIngresada(1234);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		cajaNueva.masterKey('*', claveMaestra);
		assertFalse(cajaNueva.getBloqueada());
		assertNull(cajaNueva.getClaveUsuario()); 
	}

	@Test
	public void resetearContadorIntentosFallidos() {
		// se cierra la caja y luego se introduce dos veces un código incorrecto y luego
		// un código correcto y la caja se abre y el contador de intentos fallidos
		// vuelve a cero
		int valorEsperado = 0;
		int valorObtenido;

		cajaNueva.generarClave('#', '*', 1234);
		cajaNueva.setClaveIngresada(1234);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		cajaNueva.setClaveIngresada(1);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		cajaNueva.setClaveIngresada(2);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		cajaNueva.setClaveIngresada(1234);
		cajaNueva.ingresarCodigo(cajaNueva.getClaveIngresada());
		valorObtenido = cajaNueva.getContador();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void ingresarUnaClavePorPrimeraVezYValidarQueSeaDistintaALaClaveMaestra() {
		Integer claveNueva = 2345;
		cajaNueva.generarClave('#', '*', claveNueva);

	}

	@Test
	public void chequearEstadoAbierta() {
		cajaNueva.abrirCajaFuerte();
		assertTrue(cajaNueva.abierta());
	}

	@Test
	public void chequearEstadoCerrada() {
		cajaNueva.cerrarCajaFuerte();
		assertTrue(cajaNueva.cerrada());
	}
}