package ar.edu.unlam.pb2.tddCalculadora;

import static org.junit.Assert.*;

import org.junit.Test;

import calculadora.CalculadoraDescuento;
import cliente.Cliente;
import cliente.Categoria;

public class CalculadoraDescuentoTest {

	@Test
	public void test() {

	}

	@Test
	public void descuentoDelDiezPorcientoSiElMontoEsDeCien() {
		// Preparacion
		CalculadoraDescuento calc = new CalculadoraDescuento();
		// Ejecucion
		Double resultado = calc.aplicarDescuento(100.00);
		// Contrastacion
		assertEquals(90.0, resultado, 0.01);
		// Limpieza

	}

	@Test
	public void sinDescuentoSiElMontoEsMenorACincuenta() {
		// Preparacion
		CalculadoraDescuento calc = new CalculadoraDescuento();
		// Ejecucion
		Double resultado = calc.aplicarDescuento(40.00);
		// Contrastacion
		assertEquals(40.0, resultado, 0.01);
		// Limpieza

	}

	@Test
	public void siMontoMayorADoscientosElDescuentoEsDelVeintePorciento() { 
		// Preparacion
		CalculadoraDescuento calc = new CalculadoraDescuento();
		// Ejecucion
		Double resultado = calc.aplicarDescuento(250.00);
		// Contrastacion
		assertEquals(200.0, resultado, 0.01);
		// Limpieza

	}
	
	@Test
	public void siElClienteEsMarceloAplicarQuincePorcientoDeDescuento() { 
		// Preparacion
		Cliente marcelo = new Cliente("Marcelo", 0.15);
		CalculadoraDescuento calc = new CalculadoraDescuento(marcelo.getNombre(), marcelo.getDescuento());
		// Ejecucion
		Double resultado = calc.descuentoPersonalizado(250.0);
		// Contrastacion
		assertEquals(212.50, resultado, 0.01);
		// Limpieza

	}
	
	@Test
	public void siElClienteEsEstefaniaAplicarReglaGeneralDeDescuento() { 
		// Preparacion
		Cliente estefania = new Cliente("Estefania", 0.00);
		
		CalculadoraDescuento calc = new CalculadoraDescuento(estefania.getNombre(), estefania.getDescuento());
		// Ejecucion
		Double resultado = calc.descuentoPersonalizado(200.00);
		// Contrastacion
		assertEquals(200.00, resultado, 0.01);
		// Limpieza

	}

	@Test
	public void aplicarDescuentoSegunSeaLaCategoriadelCliente() { 
		// Preparacion 
		Cliente juan = new Cliente();
		juan.setCatCli(Categoria.DIAMANTE);
		CalculadoraDescuento calc = new CalculadoraDescuento();
		// Ejecucion
		Double resultado = calc.calcular(300.00, juan.getCatCli().getPorcentaje());		
		// Contrastacion
		assertEquals(210.00, resultado, 0.01);
		// Limpieza

	}
	
}
