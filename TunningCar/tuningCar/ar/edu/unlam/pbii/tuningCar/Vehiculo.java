package ar.edu.unlam.pbii.tuningCar;

public abstract class Vehiculo {
	protected Double precioBase;
	protected Integer cantPuertas;
	protected Integer velMax;
	protected Double superficie;
	protected Boolean kitNitro;
	protected Boolean nitro = false;
	protected Accesorios accesorio;

	public Vehiculo(Double precioBase, Integer cantPuertas, Integer velMax, Double superficie) {
		this.precioBase = precioBase;
		this.cantPuertas = cantPuertas;
		this.velMax = velMax;
		this.superficie = superficie;
		esVeloz();
		esDeportivo();
	}

	public Boolean esVeloz() {
		if (this.velMax >= 140 || this.nitro) {
			return true;
		}
		return false;
	}

	public Boolean esDeportivo() {
		if (this.velMax >= 160 && this.cantPuertas == 2) {
			return true;
		}
		return false;
	}

	public void setAccesorio(Accesorios accesorio) {
		this.accesorio = accesorio;
	}

	public void setKitNitro(Boolean nitro) {
		this.nitro = nitro;
	}

	public abstract void quitarAccesorio(Accesorios accesorio);

	public abstract void listarAccesorios();

	public abstract Double getCostoAccesorios(Vehiculo vehiculo);

	public abstract Double getPrecioTotal();

	public abstract Double getPrecioConDescuento();

	public abstract void setDescuento(TipoDescuento tipoDescuento, Double descuento);

}
