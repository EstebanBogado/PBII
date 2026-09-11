package ar.edu.unlam.pbii.empresaTransporte;

public abstract class Vehiculo {
	protected Double cargaMaxima;
	protected Double volumenMaximo;

	public Vehiculo(Double cargaMaxima, Double volumenMaximo) {
		this.cargaMaxima = cargaMaxima;
		this.volumenMaximo = volumenMaximo;
	}

	public abstract void setCarga(Paquete paquete);

	public abstract Boolean validarCarga(Paquete paquete);

	public abstract Integer getPaquete();

	public abstract Integer cantPaquetes();

	public abstract void listarPaquetes();

	public abstract void setDestinoInicial(String destino);

	public abstract Boolean validarDestino(Paquete paquete);
}
