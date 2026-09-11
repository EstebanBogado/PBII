package ar.edu.unlam.pbii.gimnasioTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pbii.gimnasio.Adicionales;
import ar.edu.unlam.pbii.gimnasio.CrearPlan;
import ar.edu.unlam.pbii.gimnasio.Descuento;
import ar.edu.unlam.pbii.gimnasio.Intensidad;
import ar.edu.unlam.pbii.gimnasio.Plan;
import ar.edu.unlam.pbii.gimnasio.Socio;
import ar.edu.unlam.pbii.gimnasio.TipoPlan;

public class EnunciadoTest {

	@Test
	public void enunciadoSinEntrenamientoFuncional() {
		Double valorEsperado = 630000.0;
		Double valorDescuentoDiezPorCiento = 567000.0;
		Socio socioEnunciado = new Socio("Gómez", 123456, Intensidad.ALTA, 5, 10);
		Plan planEnunciado = CrearPlan.crearPlan(400000.0, socioEnunciado.getIntensidad(),
				socioEnunciado.getSesionesSemanales(), socioEnunciado.getDuracion());

		planEnunciado.setAdicionales(Adicionales.NUTRICIONISTA);
		planEnunciado.setAdicionales(Adicionales.SUPLEMENTOS);
		planEnunciado.setAdicionales(Adicionales.MASAJES_RECUPERATIVOS);

		assertNotNull(planEnunciado);
		assertEquals(TipoPlan.INTENSIVO, planEnunciado.getTipoPlan());
		assertEquals(valorEsperado, planEnunciado.getPrecioFinal());
		assertEquals(valorDescuentoDiezPorCiento, planEnunciado.getPrecioConDescuento(Descuento.PORCENTUAL, 0.10));

	}

	@Test
	public void ennciadoConEntrenamientoFuncional() {
		Double valorEsperado = 655000.0;
		Double valorDescuentoNominal = 605000.0;
		Socio socioEnunciado = new Socio("Gómez", 123456, Intensidad.ALTA, 5, 10);
		Plan planEnunciado = CrearPlan.crearPlan(400000.0, socioEnunciado.getIntensidad(),
				socioEnunciado.getSesionesSemanales(), socioEnunciado.getDuracion());

		planEnunciado.setAdicionales(Adicionales.NUTRICIONISTA);
		planEnunciado.setAdicionales(Adicionales.SUPLEMENTOS);
		planEnunciado.setAdicionales(Adicionales.MASAJES_RECUPERATIVOS);
		planEnunciado.setAdicionales(Adicionales.ENTRENAMIENTO_FUNCIONAL);

		assertNotNull(planEnunciado);
		assertEquals(TipoPlan.INTENSIVO, planEnunciado.getTipoPlan());
		assertEquals(valorEsperado, planEnunciado.getPrecioFinal());
		assertEquals(valorDescuentoNominal, planEnunciado.getPrecioConDescuento(Descuento.NOMINAL, 50000.0));
	}

}
