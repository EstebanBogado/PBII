package ar.edu.unlam.pbii.collatz;

import java.util.Scanner;

public class ListadoDeCollatz {

	public static void main(String[] args) {
		System.out.println("Ingrese un número entero positivo: ");
		Integer numero = 0;

		Scanner teclado = new Scanner(System.in);
		numero = teclado.nextInt();

		Collatz collatz = new Collatz(numero);

		collatz.conjetura();
		System.out.println("Estos son los números de la serie de Collatz: ");
		collatz.listarConjetura();
		teclado.close();
	}
}
