package ar.edu.unlam.pbii.tuningCar;

import java.util.HashSet;
import java.util.Set;

public class Auto extends Vehiculo {
	private Set<Accesorios> accesorios = new HashSet<Accesorios>();
	private Double descuento;
	private TipoDescuento tipoDescuento;

	public Auto(Double precioBase, Integer cantPuertas, Integer velMax, Double superficie) {
		super(precioBase, cantPuertas, velMax, superficie);

	}

	@Override
	public void setAccesorio(Accesorios accesorio) {
		accesorios.add(accesorio);
	}

	@Override
	public void listarAccesorios() {
		for (Accesorios a : accesorios) {
			System.out.println(a);
		}
	}

	@Override
	public Double getPrecioTotal() {
		return this.precioBase + getCostoAccesorios(this);
	}

	@Override
	public void setDescuento(TipoDescuento tipoDescuento, Double descuento) {
		this.tipoDescuento = tipoDescuento;
		this.descuento = descuento;
	}
 
	@Override
	public Double getPrecioConDescuento() {
		Double precioConDescuento = 0.0;
		switch (this.tipoDescuento) {
		case NOMINAL:
			precioConDescuento = getPrecioTotal() - this.descuento;
			break;
		case PORCENTUAL:
			precioConDescuento = getPrecioTotal() - (getPrecioTotal() * this.descuento);
			break;
		default:
			return getPrecioTotal();	
		}
		return precioConDescuento; 
	}

	@Override
	public Double getCostoAccesorios(Vehiculo vehiculo) {
		Double costoAccesorios = 0.0;
		for (Accesorios a : accesorios) {
			costoAccesorios += a.getCostoAccesorio(vehiculo);
		}
		return costoAccesorios;
	}

	@Override
	public void quitarAccesorio(Accesorios accesorio) {
		accesorios.remove(accesorio);
	}
}
