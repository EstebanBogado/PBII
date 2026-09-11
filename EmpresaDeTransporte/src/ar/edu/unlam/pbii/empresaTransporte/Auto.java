package ar.edu.unlam.pbii.empresaTransporte;

import java.util.Arrays;

public class Auto extends Vehiculo {

	private Double cargaTotal = 0.0;
	private Double volumenTotal = 0.0;
	private Paquete[] paquete = new Paquete[3];
	private Integer cantidad = 0;

	public Auto(Double cargaMaxima, Double volumenMaximo) {
		super(cargaMaxima, volumenMaximo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setCarga(Paquete paquete) {

		if (validarCarga(paquete) && cantidad < this.paquete.length) {
			this.paquete[cantidad] = paquete;
			cantidad++;
			if (cantidad == this.paquete.length) {
				this.paquete = Arrays.copyOf(this.paquete, this.paquete.length * 2);
			}
		}
	}

	@Override
	public Boolean validarCarga(Paquete paquete) {
		Double nuevaCarga = this.cargaTotal + paquete.getPeso();
		Double nuevoVolumen = this.volumenTotal + paquete.getVolumen();

		if (nuevaCarga > this.cargaMaxima || nuevoVolumen > this.volumenMaximo || !validarDestino(paquete)) {
//			if (nuevaCarga > this.cargaMaxima) 
//				System.out.println("Peso Completo");
//			if (nuevoVolumen > this.volumenMaximo)
//				System.out.println("Volumen Completo");
			return false;			
		}
		this.cargaTotal = nuevaCarga;
		this.volumenTotal = nuevoVolumen;
		return true;
	}

	@Override
	public Integer getPaquete() {
		// TODO Auto-generated method stub
		return this.paquete.length;
	}

	@Override
	public Integer cantPaquetes() {
		return this.cantidad;
	}

	@Override
	public void listarPaquetes() {
		for (int i = 0; i < paquete.length; i++) {
			if (paquete[i] != null)
				System.out.println("Paquete " + (i + 1) + " " + paquete[i].toString());
		}
	}

	@Override
	public void setDestinoInicial(String destino) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean validarDestino(Paquete paquete) {
		for (int i = 0; i < this.cantidad; i++) {
			if (paquete.getDestino().equals(this.paquete[i].getDestino()))
				return false;
		}
		return true;
	}

}
