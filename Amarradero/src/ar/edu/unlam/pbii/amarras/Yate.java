package ar.edu.unlam.pbii.amarras;

public class Yate extends Barco implements EsAmarrable{

	public Yate(String nombre, Double eslora, Double manga) {
		super(nombre, eslora, manga);
		this.motor = true;
	}



	
}
