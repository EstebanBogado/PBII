package ar.edu.unlam.pbii.empresaTransporte;

public class Bicicleta extends Vehiculo {
	private Double cargaTotal = 0.0;
	private Double volumenTotal = 0.0;
	private Integer cantPaquetes = 0;
	private String destinoInicial = null;

	Paquete[] paquete = new Paquete[2];

	public Bicicleta(Double cargaMaxima, Double volumenMaximo) {
		super(cargaMaxima, volumenMaximo);
		for (int i = 0; i < this.paquete.length; i++) {
			this.paquete[i] = null;
		}
	}

	@Override
	public void setCarga(Paquete paquete) {

		if (validarCarga(paquete) && this.paquete[this.cantPaquetes] == null) {
			this.paquete[this.cantPaquetes] = paquete;
			this.cantPaquetes++;
		}
	}

	@Override
	public Boolean validarCarga(Paquete paquete) {
		Double nuevaCarga = this.cargaTotal + paquete.getPeso();
		Double nuevoVolumen = this.volumenTotal + paquete.getVolumen();

		if (nuevaCarga > this.cargaMaxima || nuevoVolumen > this.volumenMaximo || (!validarDestino(paquete)
				&& this.destinoInicial != null)) {
			return false;
		}
		this.cargaTotal = nuevaCarga;
		this.volumenTotal = nuevoVolumen;
		setDestinoInicial(paquete.getDestino());
		return true;
	}

	@Override
	public Integer getPaquete() {
		// TODO Auto-generated method stub
		return this.paquete.length;
	}

	@Override
	public Integer cantPaquetes() {
		// TODO Auto-generated method stub
		return this.cantPaquetes;
	}

	@Override
	public void listarPaquetes() {
		for (int i = 0; i < paquete.length; i++) {
			if(paquete[i] != null)
			System.out.println("Paquete " + (i + 1) + " " + paquete[i].toString());
		}
	}

	@Override
	public void setDestinoInicial(String destino) {
		if (this.destinoInicial == null) {
			this.destinoInicial = destino;
		}
	}

	@Override
	public Boolean validarDestino(Paquete paquete) {
		return paquete.getDestino().equalsIgnoreCase(this.destinoInicial);
	}

}
