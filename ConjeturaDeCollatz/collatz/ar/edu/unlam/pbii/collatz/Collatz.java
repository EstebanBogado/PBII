package ar.edu.unlam.pbii.collatz;

import java.util.ArrayList;

public class Collatz {

	private Integer numero;
	private ArrayList<Integer> coleccion = new ArrayList<Integer>();

	public Collatz(Integer numero) {
		this.numero = numero;
		numValido();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Boolean numValido() {
		if (this.numero <= 0) {
			System.out.println("Número inválido, ingrese un entero mayor que cero!!!");
			return false;
		}
		return true;
	}

	public void conjetura() {
		
		int contador = 0;
		do {
			contador++;
			if (this.numero % 2 == 0) {
				this.numero = this.numero / 2;
			} else {
				this.numero = (this.numero * 3) + 1;
			}
			coleccion.add(this.numero);
		} while (!(coleccion.contains(4) && coleccion.contains(2) && coleccion.contains(1)));
	}

	public void listarConjetura() {
		for (Integer c : coleccion) {
			System.out.println(c);
		}
	}
}
