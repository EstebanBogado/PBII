package ar.edu.unlam.pbii.eventos;

import java.util.HashSet;
import java.util.Set;

public abstract class Evento implements Personalizables {
	protected Double precioBase;
	protected final Integer cantInvitados;
	protected Double duracion;
	protected final Integer superficieSalon;
	protected Boolean masivo = false;
	protected Boolean vip = false;
	protected Set<Adicional> adicionales = new HashSet<Adicional>();

	public Evento(Double precioBase, Integer cantInvitados, Double duracion, Integer superficieSalon) {
		this.precioBase = precioBase;
		this.cantInvitados = cantInvitados;
		this.duracion = duracion;
		this.superficieSalon = superficieSalon;
		this.masivo = esMasivo();
		this.vip = esVip();
	}

	@Override
	public Double getPrecioTotalConDescuento(Descuentos descuento, Double monto) {
		switch (descuento) {
		case NOMINAL:
			return getPrecioTotal() - monto;
		case PORCENTUAL:
			return (getPrecioTotal() - (getPrecioTotal() * monto));
		default:
			getPrecioTotal();
		}
		return null;
	}

	public Double getPrecioBase() {
		return this.precioBase;
	}

	public void setPrecioBase(Double precio) {
		this.precioBase = precio;
	}

	public Integer getCantInvitados() {
		return this.cantInvitados;
	}

	public Double getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}

	public Integer getSuperficieSalon() {
		return this.superficieSalon;
	}

	public Boolean getVip() {
		return this.vip;
	}

	public Boolean getMasivo() {
		return this.masivo;
	}

	public abstract Double getPrecioFinal();

	public Boolean esMasivo() {
		if (this.cantInvitados > 500 && this.superficieSalon > 1000)
			return true;
		return false;
	}

	public Boolean esVip() {
		if (this.precioBase > 1500000 && this.cantInvitados < 100)
			return true;
		return false;
	}

	public void setAdicionales(Adicional adicional) {
		this.adicionales.add(adicional);
	}

	@Override
	public Double getCostoAdicionales() {
		// TODO Auto-generated method stub
		return null;
	}

	public abstract Double getPrecioTotal();
}
