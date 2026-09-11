package ar.edu.unlam.pbii.salaDeCineTest;

import ar.edu.unlam.pbii.salaDeCine.Genero;
import ar.edu.unlam.pbii.salaDeCine.Pelicula;
import ar.edu.unlam.pbii.salaDeCine.SalaDeCine;

public class Test {

	public static void main(String[] args) {
		SalaDeCine sala1 = new SalaDeCine(6, 5);
		SalaDeCine sala2 = new SalaDeCine(7, 4);
		Pelicula starWars = new Pelicula("Star Wars", Genero.SUSPENSO, 180, 16);
		Pelicula toyStory5 = new Pelicula("Toy Story 5", Genero.INFANTIL, 90, 0);

		sala1.proyectarPelicula(starWars);
		sala2.proyectarPelicula(toyStory5);

		sala2.mensajeDeVenta(sala2.venderBoleto(3, 2, 12));
		sala2.mensajeDeVenta(sala2.venderBoleto(3, 3, 12));
		sala2.mensajeDeVenta(sala2.venderBoleto(3, 3, 12));
		sala2.imprimirButacas(sala2.getEstadoButacas());

		sala1.mensajeDeVenta(sala1.venderBoleto(0, 0, 17));
		sala1.imprimirButacas(sala1.getEstadoButacas());

		sala1.mensajeDeVenta(sala1.venderBoleto(0, 0, 17));
		sala1.imprimirButacas(sala1.getEstadoButacas());

		sala1.mensajeDeVenta(sala1.venderBoleto(1, 1, 17));
		sala1.imprimirButacas(sala1.getEstadoButacas());

		sala1.mensajeDeVenta(sala1.venderBoleto(5, 4, 17));
		sala1.imprimirButacas(sala1.getEstadoButacas());

		sala1.mensajeDeVenta(sala1.venderBoleto(4, 4, 16));
		sala1.imprimirButacas(sala1.getEstadoButacas());

	}

}
