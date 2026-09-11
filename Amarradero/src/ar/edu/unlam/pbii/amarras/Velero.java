package ar.edu.unlam.pbii.amarras;

public class Velero extends Barco implements EsAmarrable{


	public Velero(String nombre, Double eslora, Double manga) {
		super(nombre, eslora, manga);
		this.motor = false;
	}

	

}
