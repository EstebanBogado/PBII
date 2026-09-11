package ar.edu.unlam.pbii.salaDeCineTDDTest;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unlam.pbii.salaDeCineTDD.Butaca;
import ar.edu.unlam.pbii.salaDeCineTDD.Pelicula;
import ar.edu.unlam.pbii.salaDeCineTDD.Sala;
import ar.edu.unlam.pbii.salaDeCineTDD.Tipo;

class Test {

	@org.junit.jupiter.api.Test
	void crearUnaButacaYQueEsteDisponible() {
		Butaca butaca = new Butaca();
		assertFalse(butaca.estaOcupada());

	}

	@org.junit.jupiter.api.Test
	void crearUnaPeliculaConTodosSusParametros() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		assertNotNull(starWars);
	}

	@org.junit.jupiter.api.Test
	void crearUnaSalaDeCineConSusButacasYUnaPeliculaEnCartelera() {
		Sala sala1 = new Sala(7, 4);
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		assertEquals(28, sala1.getCantButacas());
		sala1.proyectarPelicula(starWars);
		assertNotNull(sala1.getPelicula());
	}

	@org.junit.jupiter.api.Test
	void crearUnaSalaDeCineConSusButacasYCambiarLaPeliculaProextada() {
		Sala sala1 = new Sala(7, 4);
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		Pelicula toyStory = new Pelicula("Toy Story", 89, 0, Tipo.INFANTIL);
		sala1.proyectarPelicula(starWars);
		sala1.cambiarPelicula(toyStory);
		assertNotNull(sala1.getPelicula());
	}

	@org.junit.jupiter.api.Test
	void crearUnaSalaDeCineConSusButacasYProyectarUnaPeliculaYVenderBoletos() {
		Sala sala1 = new Sala(7, 4);
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		sala1.proyectarPelicula(starWars);
		sala1.venderBoleto(5, 3, 17);
		assertEquals(27, sala1.butacasDisponibles());
	}

	@org.junit.jupiter.api.Test
	void crearUnaSalaDeCineConSusButacasYProyectarUnaPeliculaYVenderButacasInexistentes() {
		Sala sala1 = new Sala(7, 4);
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		sala1.proyectarPelicula(starWars);
		sala1.venderBoleto(-7, 3, 17);
		assertEquals(28, sala1.butacasDisponibles());
	}

	@org.junit.jupiter.api.Test
	void crearUnaSalaDeCineConSusButacasYProyectarUnaPeliculaYVenderButacasYDevolverla() {
		Sala sala1 = new Sala(7, 4);
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		sala1.proyectarPelicula(starWars);
		sala1.venderBoleto(6, 3, 17);
		assertEquals(27, sala1.butacasDisponibles());
		sala1.devolverBoleto(6, 3);
		assertEquals(28, sala1.butacasDisponibles());
	}

	@org.junit.jupiter.api.Test
	void crearUnaPeliculaYAgregarleLaSinopsis() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		starWars.setSinopsis("Pelicula de ciencia ficción y fantasía!!!");
		assertNotNull(starWars.getSinopsis());
		System.out.println("Sinopsis: " + starWars.getSinopsis());
	}
}
