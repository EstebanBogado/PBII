package ar.edu.unlam.pbii.hechizosTest;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.pbii.hechizos.Agrandar;
import ar.edu.unlam.pbii.hechizos.Animal;
import ar.edu.unlam.pbii.hechizos.Expelliarmus;
import ar.edu.unlam.pbii.hechizos.Hechizable;
import ar.edu.unlam.pbii.hechizos.Hechizo;
import ar.edu.unlam.pbii.hechizos.LibroDeHechizos;
import ar.edu.unlam.pbii.hechizos.Mueble;

public class HechizosTest {

	@Test
	public void queSePuedeAgregarUnHechizoAlLibro() {
		LibroDeHechizos libro = new LibroDeHechizos();
		Hechizo desarme = new Expelliarmus();
		libro.agregarHechizo(desarme);

		Assert.assertEquals(desarme, libro.buscar("expelliarmus"));
	}

	@Test
	public void verSiUnHechizableEstaHechizado() {
		LibroDeHechizos libro = new LibroDeHechizos();
		Expelliarmus desarme = new Expelliarmus();
		Hechizable perro = new Animal();	
		libro.agregarHechizo(desarme);
		Hechizo hechizo = libro.buscar("expelliarmus");
		hechizo.aplicarHechizo(perro);
		Assert.assertEquals("Estoy desarmado", perro.getEstado());
	}
	
	@Test
	public void verSiUnHechizableCrece() {
	LibroDeHechizos libro = new LibroDeHechizos();
	Hechizo crecer = new Agrandar();
	Hechizable mesa = new Mueble();
	libro.agregarHechizo(crecer);
	Hechizo hechizo =libro.buscar("enormuvus");
	hechizo.aplicarHechizo(mesa);
	Assert.assertEquals("Ahora soy más grande", mesa.getEstado());
	}

}
