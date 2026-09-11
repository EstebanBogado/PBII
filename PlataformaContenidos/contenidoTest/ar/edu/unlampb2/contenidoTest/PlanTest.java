package ar.edu.unlampb2.contenidoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.contenido.CategoriaPlan;
import ar.edu.unlam.pb2.contenido.Contenido;
import ar.edu.unlam.pb2.contenido.Documental;
import ar.edu.unlam.pb2.contenido.Pelicula;
import ar.edu.unlam.pb2.contenido.Plan;
import ar.edu.unlam.pb2.contenido.PlanBasico;
import ar.edu.unlam.pb2.contenido.PlanFamiliar;
import ar.edu.unlam.pb2.contenido.PlanPremium;
import ar.edu.unlam.pb2.contenido.Serie;
import ar.edu.unlam.pb2.contenido.Usuario;

public class PlanTest {

	@Test
	public void crearUnUsuarioPremiumYQueNoTengaAdicionales() {
		Double costoPlan = 12.0;
		Plan premium = new PlanPremium(CategoriaPlan.PLAN_PREMIUM);
		Usuario usuPremium = new Usuario("usuPremium", premium);

		Contenido peli1 = new Pelicula("101 Dálmatas", 15.0);
		Contenido docu1 = new Documental("Océanos", 20.0);

		usuPremium.setContenidoVisto(peli1);
		usuPremium.setContenidoVisto(docu1);

		// usuPremium.getContenidoVisto();

		assertEquals(costoPlan, usuPremium.getPlan().getCostoTotal(usuPremium));

	}

	@Test
	public void crearUnUsuarioBasicoYQueTengaAdicionalesSumadosAlCostoTotal() {
		Double costoPlan = 5.0;
		Double costoTotal = 45.0;
		Plan basico = new PlanBasico(CategoriaPlan.PLAN_BASICO);
		Usuario usuBasico = new Usuario("usuPremium", basico);

		Contenido peli1 = new Pelicula("101 Dálmatas", 15.0);
		Contenido docu1 = new Documental("Océanos", 20.0);
		Contenido serie1 = new Serie("Breaking Bad", 20.0);
		Contenido peli2 = new Pelicula("Frozen", 20.0);

		usuBasico.setContenidoVisto(peli1);
		usuBasico.setContenidoVisto(peli2);
		usuBasico.setContenidoVisto(docu1);
		usuBasico.setContenidoVisto(serie1);
		usuBasico.setContenidoVisto(peli2);

		usuBasico.getContenidoVisto();

		assertEquals(costoPlan, usuBasico.getPlan().getCostoPlan(), 0.01);
		assertEquals(costoTotal, usuBasico.getPlan().getCostoTotal(usuBasico), 0.01);
	}

	@Test
	public void crearUnPlanFamiliarYQueSumeLosAdicionalesAlCostoTotalSiLosHubiera() {
		Double costoPlan = 5.0;
		Double costoTotal = 38.25;
		Plan familiar = new PlanFamiliar(CategoriaPlan.PLAN_FAMILIAR);
		Usuario usuFamiliar = new Usuario("usuPremium", familiar);

		Contenido peli1 = new Pelicula("101 Dálmatas", 15.0);
		Contenido docu1 = new Documental("Océanos", 20.0);
		Contenido serie1 = new Serie("Breaking Bad", 20.0);
		Contenido peli2 = new Pelicula("Frozen", 20.0);

		usuFamiliar.setContenidoVisto(peli1);
		usuFamiliar.setContenidoVisto(peli2);
		usuFamiliar.setContenidoVisto(docu1);
		usuFamiliar.setContenidoVisto(serie1);
		usuFamiliar.setContenidoVisto(peli2);

		usuFamiliar.getContenidoVisto();

		assertEquals(costoPlan, usuFamiliar.getPlan().getCostoPlan(), 0.01);
		assertEquals(costoTotal, usuFamiliar.getPlan().getCostoTotal(usuFamiliar), 0.01);
	}

	@Test
	public void crearUnPlanDeCadaCategoriaYQueDevuelvanSosCostosTotales() {
		Double costoPremium = 12.0;
		Double costoBasico = 45.0;
		Double costoFamiliar = 38.25;
		Plan premium = new PlanPremium(CategoriaPlan.PLAN_PREMIUM);
		Plan basico = new PlanBasico(CategoriaPlan.PLAN_BASICO);
		Plan familiar = new PlanFamiliar(CategoriaPlan.PLAN_FAMILIAR);
		Usuario usuPremium = new Usuario("usuPremium", premium);
		Usuario usuBasico = new Usuario("usuPremium", basico);
		Usuario usuFamiliar = new Usuario("usuPremium", familiar);

		Contenido peli1 = new Pelicula("101 Dálmatas", 15.0);
		Contenido docu1 = new Documental("Océanos", 20.0);
		Contenido serie1 = new Serie("Breaking Bad", 20.0);
		Contenido peli2 = new Pelicula("Frozen", 20.0);

		usuPremium.setContenidoVisto(peli1);
		usuPremium.setContenidoVisto(peli2);
		usuPremium.setContenidoVisto(docu1);
		usuPremium.setContenidoVisto(serie1);
		usuPremium.setContenidoVisto(peli2);

		usuBasico.setContenidoVisto(peli1);
		usuBasico.setContenidoVisto(peli2);
		usuBasico.setContenidoVisto(docu1);
		usuBasico.setContenidoVisto(serie1);
		usuBasico.setContenidoVisto(peli2);

		usuFamiliar.setContenidoVisto(peli1);
		usuFamiliar.setContenidoVisto(peli2);
		usuFamiliar.setContenidoVisto(docu1);
		usuFamiliar.setContenidoVisto(serie1);
		usuFamiliar.setContenidoVisto(peli2);
		
		usuFamiliar.getContenidoVisto();
		System.out.println("**************************");
		usuPremium.getContenidoVisto();
		System.out.println("**************************");
		usuBasico.getContenidoVisto();
		
		assertEquals(costoPremium, usuPremium.getPlan().getCostoTotal(usuPremium));
		assertEquals(costoBasico, usuBasico.getPlan().getCostoTotal(usuBasico));
		assertEquals(costoFamiliar	, usuFamiliar.getPlan().getCostoTotal(usuFamiliar));
	}
}
