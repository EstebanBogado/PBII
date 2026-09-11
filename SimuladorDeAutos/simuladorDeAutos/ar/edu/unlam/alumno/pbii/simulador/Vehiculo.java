package ar.edu.unlam.alumno.pbii.simulador;

public abstract class Vehiculo {
	protected Double precioBase;
	protected final Integer cantPuertas;
	protected Integer velMax;
	protected final Double superficie;
	protected Boolean esVeloz = false;
	protected Boolean esDeportivo = false;
	protected Boolean kitNitro = false;

	public Vehiculo(Double precioBase, Integer cantPuertas, Integer velMax, Double superficie) {
		this.precioBase = precioBase;
		this.cantPuertas = cantPuertas;
		this.velMax = velMax;
		this.superficie = superficie;
		esVeloz();
		esDeportivo();	
	}

	public void setKitNitro(Boolean valor) {
		this.kitNitro = valor;
	}

	public Boolean getKitNitro() {
		return this.kitNitro;
	}

	public Double getPrecioBase() {
		return this.precioBase;
	}

	public Integer getCantPuertas() {
		return cantPuertas;
	}

	public Double getSuperficie() {
		return superficie;
	}

	public Boolean esVeloz() {
		if (this.velMax >= 140 || this.kitNitro) {
			return true;
		}
		return false;
	}

	public Boolean esDeportivo() {
		if (this.cantPuertas == 2 && this.getVelMax() >= 160) {
			return true;
		}
		return false;
	}

	public Integer getVelMax() {
		return this.velMax;
	}

	public abstract Double getPrecioFinal();

	public Double getDescuento(Descuentos descuento) {
		// TODO Auto-generated method stub
		return null;
	}
}
