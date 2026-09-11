package ar.edu.unlam.pbii.gimnasioTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pbii.gimnasio.Adicionales;
import ar.edu.unlam.pbii.gimnasio.CrearPlan;
import ar.edu.unlam.pbii.gimnasio.Intensidad;
import ar.edu.unlam.pbii.gimnasio.Plan;
import ar.edu.unlam.pbii.gimnasio.Socio;
import ar.edu.unlam.pbii.gimnasio.TipoPlan;

public class GimnasioTest {

	@Test
	public void crearPlanGenericoDesdeDatosDeSocio() {
		Double precioEsperado = 200000.0;
		Socio socio = new Socio("Esteban Bogado", 1234, Intensidad.ALTA, 4, 0);
		Plan planSocio = CrearPlan.crearPlan(200000.0, socio.getIntensidad(), socio.getSesionesSemanales(),
				socio.getDuracion());

		assertNotNull(planSocio);
		assertEquals(TipoPlan.GENERICO, planSocio.getTipoPlan());
		assertEquals(precioEsperado, planSocio.getPrecioFinal());
	}

	@Test
	public void crearPlanIntensivoDesdeDatosDeSocio() {
		Double precioEsperado = 200000.0;
		Socio socio = new Socio("Esteban Bogado", 1234, Intensidad.ALTA, 6, 10);
		Plan planSocio = CrearPlan.crearPlan(200000.0, socio.getIntensidad(), socio.getSesionesSemanales(),
				socio.getDuracion());

		assertNotNull(planSocio);
		assertEquals(TipoPlan.INTENSIVO, planSocio.getTipoPlan());
		assertEquals(precioEsperado, planSocio.getPrecioFinal());
	}

	@Test
	public void crearPlanPersonalizadoDesdeDatosDeSocio() {
		Socio socio = new Socio("Esteban Bogado", 1234, Intensidad.BAJA, 6, 10);
		Plan planSocio = CrearPlan.crearPlan(200000.0, socio.getIntensidad(), socio.getSesionesSemanales(),
				socio.getDuracion());

		assertNotNull(planSocio);
		assertEquals(TipoPlan.PERSONALIZADO, planSocio.getTipoPlan());
	}

	@Test
	public void crearPlanPersonalizadoDesdeDatosDeSocioYAgregarleAdicionales() {
		Double precioEsperado = 420000.0;
		Socio socio = new Socio("Esteban Bogado", 1234, Intensidad.BAJA, 6, 10);
		Plan planSocio = CrearPlan.crearPlan(200000.0, socio.getIntensidad(), socio.getSesionesSemanales(),
				socio.getDuracion());

		planSocio.setAdicionales(Adicionales.NUTRICIONISTA);
		planSocio.setAdicionales(Adicionales.SUPLEMENTOS);
		planSocio.setAdicionales(Adicionales.ENTRENAMIENTO_FUNCIONAL);
		assertNotNull(planSocio);
		assertEquals(TipoPlan.PERSONALIZADO, planSocio.getTipoPlan());
		assertEquals(precioEsperado, planSocio.getPrecioFinal());
	}

}
