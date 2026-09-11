package ar.edu.unlam.alumno.pbii.simulador;

import java.util.ArrayList;

public class Auto extends Vehiculo implements EsMejorable {

	private ArrayList<Accesorios> accesorios = new ArrayList<Accesorios>();
	private Double descuento = 0.0;
	private Descuentos tipoDescuento;

	public Auto(Double precioBase, Integer cantPuertas, Integer velMax, Double superficie) {
		super(precioBase, cantPuertas, velMax, superficie);
//		esVeloz();
//		esDeportivo();	
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	@Override
	public Double getPrecioBase() {
		return this.precioBase;
	}

	@Override
	public Double getPrecioFinal() {

		return this.precioBase + getCostoAccesorio(this);

	}

	public Double getPrecioConDescuento() {
		return getPrecioFinal() - getDescuento(tipoDescuento);
	}

	public void setAccesorio(Accesorios accesorios) {
		this.accesorios.add(accesorios);
	}

	public void quitarAccesorio(Accesorios accesorio) {
		this.accesorios.remove(accesorio);
		if (accesorio.equals(Accesorios.KIT_NITRO)) {
			this.setKitNitro(false);
		}
	}

	@Override
	public Double getCostoAccesorio(Vehiculo vehiculo) {
		Double costoAccesorios = 0.0;
		for (Accesorios acces : accesorios) {
			costoAccesorios += acces.getCostoAccesorio(vehiculo);
		}
		return costoAccesorios;
	}

	@Override
	public Double getDescuento(Descuentos descuento) {
		this.tipoDescuento = descuento;
		return descuento.aplicar(this, this.descuento);
	}
}
