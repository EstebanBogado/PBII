package ar.edu.unlam.pbii.localDeComidasTest;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unlam.pbii.localDeComidas.Cliente;
import ar.edu.unlam.pbii.localDeComidas.Local;
import ar.edu.unlam.pbii.localDeComidas.Menu;
import ar.edu.unlam.pbii.localDeComidas.Plato;

class Test {

	@org.junit.jupiter.api.Test
	void crearUnLocalYQúeNoSeaNull() {
		Local central = new Local("Casa Central");

		assertNotNull(central);
		assertEquals("Casa Central", central.getNombreDelLocal());
	}

	@org.junit.jupiter.api.Test
	void crearUnClienteYQueTengaCategoriaEstandard() {
		Cliente cliente1 = new Cliente("Pedro");
		cliente1.setCatCliente("Standard");

		assertNotNull(cliente1);
		assertEquals("Standard", cliente1.getCatCli());

	}

	@org.junit.jupiter.api.Test
	void crearUnLocalYArmarleUnMenu() {
		Local central = new Local("Casa Central");
		Menu menuCasaCentral = new Menu("Menu Casa Central");
		Plato hamburguesaClasica = new Plato("Burga Clásica", "Lechuga tomate", "", 10.0);
		Plato hamburguesaEspecial = new Plato("Super Burga", "Doble bacon", "Papas Fritas", 15.0);
		Plato sangucheMilanesaBasico = new Plato("Mila Básica", "Milanesa", "", 8.0);

		menuCasaCentral.setPlato(sangucheMilanesaBasico);
		menuCasaCentral.setPlato(hamburguesaEspecial);
//		menuCasaCentral.setPlato(hamburguesaClasica);

		central.setMenu(menuCasaCentral);

		assertEquals(Integer.valueOf(2), central.getMenu());

	}

	@org.junit.jupiter.api.Test
	void crearUnLocalYArmarleUnMenuYQueSePUedaAumentarElTamanio() {
		Local central = new Local("Casa Central");
		Menu menuCasaCentral = new Menu("Menu Casa Central");
		Plato hamburguesaClasica = new Plato("Burga Clásica", "Lechuga tomate", "", 10.0);
		Plato hamburguesaEspecial = new Plato("Super Burga", "Doble bacon", "Papas Fritas", 15.0);
		Plato sangucheMilanesaBasico = new Plato("Mila Básica", "Milanesa", "", 8.0);

		menuCasaCentral.setPlato(sangucheMilanesaBasico);
		menuCasaCentral.setPlato(hamburguesaEspecial);
		central.setMenu(menuCasaCentral);

		assertEquals(Integer.valueOf(2), central.getMenu());

		menuCasaCentral.setPlato(hamburguesaClasica);
		central.setMenu(menuCasaCentral);
		central.listarMenu();

		assertEquals(Integer.valueOf(3), central.getMenu());

	}

	@org.junit.jupiter.api.Test
	void crearUnLocalYArmarleUnMenuYQueSePUedaEliminarUnPlato() {
		Local central = new Local("Casa Central");
		Menu menuCasaCentral = new Menu("Menu Casa Central");
		Plato hamburguesaClasica = new Plato("Burga Clásica", "Lechuga tomate", "", 10.0);
		Plato hamburguesaEspecial = new Plato("Super Burga", "Doble bacon", "Papas Fritas", 15.0);
		Plato sangucheMilanesaBasico = new Plato("Mila Básica", "Milanesa", "", 8.0);
		Plato sangucheMilanesaCompleto = new Plato("Mila Campleta", "Milanesa lechuga tomate", "Papas Fritas", 12.0);

		menuCasaCentral.setPlato(sangucheMilanesaBasico);
		menuCasaCentral.setPlato(hamburguesaEspecial);
		menuCasaCentral.setPlato(hamburguesaClasica);
		central.setMenu(menuCasaCentral);
		assertEquals(Integer.valueOf(3), central.getMenu());
		central.listarMenu();

		menuCasaCentral.eliminarPlato(hamburguesaClasica);
		central.setMenu(menuCasaCentral);
		menuCasaCentral.setPlato(sangucheMilanesaCompleto);
		assertEquals(Integer.valueOf(3), central.getMenu());
		central.listarMenu();

	}

}
