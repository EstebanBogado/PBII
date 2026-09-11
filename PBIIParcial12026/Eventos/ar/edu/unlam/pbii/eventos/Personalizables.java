package ar.edu.unlam.pbii.eventos;

public interface Personalizables {
	public Double getCostoAdicionales();

	public Double getPrecioTotalConDescuento(Descuentos descuento, Double monto);
}
