package ar.edu.unlampb2.contenidoTest;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import ar.edu.unlam.pb2.contenido.CategoriaPlan;
import ar.edu.unlam.pb2.contenido.Contenido;
import ar.edu.unlam.pb2.contenido.Documental;
import ar.edu.unlam.pb2.contenido.Pelicula;
import ar.edu.unlam.pb2.contenido.Plan;
import ar.edu.unlam.pb2.contenido.PlanFamiliar;
import ar.edu.unlam.pb2.contenido.PlanPremium;
import ar.edu.unlam.pb2.contenido.Serie;
import ar.edu.unlam.pb2.contenido.Usuario;

public class UsuarioTest {

	@Test
	public void crearUnUsuarioYQueDuvuelvaSuNombreYElPlanSuscripto() {
		String nombre = "Pepe";
		Plan plan = new PlanFamiliar(CategoriaPlan.PLAN_FAMILIAR);
		Double costoBase = 5.0;

		Usuario usuario = new Usuario("Pepe", plan);

		assertEquals(nombre, usuario.getNombre());
		assertEquals(plan, usuario.getPlan());
		assertEquals(costoBase, usuario.getPlan().getCostoPlan());
	}

	@Test
	public void crearUnUsuarioYQueDuvuelvaSuNombreYElPlanSuscriptoYPoderCambiarElPlan() {
		String nombre = "Pepe";
		Plan categoria = new PlanFamiliar(CategoriaPlan.PLAN_FAMILIAR);
		Plan categoriaNueva = new PlanPremium(CategoriaPlan.PLAN_PREMIUM);

		Double costoBase = 5.0;

		Usuario usuario = new Usuario("Pepe", categoria);

		assertEquals(nombre, usuario.getNombre());
		assertEquals(categoria, usuario.getPlan());
		assertEquals(costoBase, usuario.getPlan().getCostoPlan());

		usuario.setPlan(categoriaNueva);
		assertEquals(categoriaNueva, usuario.getPlan());
	}

	@Test
	public void crearUnUsuarioYQueSeGuardenTodosLosContenidosVistos() {
		Plan categoria = new PlanFamiliar(CategoriaPlan.PLAN_FAMILIAR);

		Usuario usuario = new Usuario("Pepe", categoria);
		Contenido serie = new Serie("Breaking Bad", 25.0);
		Contenido pelicula = new Pelicula("Titanic", 22.0);
		Contenido documental = new Documental("Océanos", 45.0);

		usuario.setContenidoVisto(serie);
		usuario.setContenidoVisto(pelicula);
		usuario.setContenidoVisto(documental);

		assertEquals(Integer.valueOf(3), usuario.getTotalVistos());

	}
}
