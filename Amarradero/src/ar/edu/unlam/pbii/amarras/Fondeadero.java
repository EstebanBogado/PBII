package ar.edu.unlam.pbii.amarras;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Fondeadero {
	private Integer cantAmarras;
	private SortedSet<Amarra> amarras = new TreeSet<Amarra>(Comparator.comparing(Amarra::getNroAmarra));
	private Map<Integer, Barco> fondeadero = new HashMap<Integer, Barco>();

	public Fondeadero(Integer cantAmarras) {
		this.cantAmarras = cantAmarras;
	}

	public Integer getAmarrasCreadas() {
		return this.cantAmarras;
	}

	public Integer getAmarrasOcupadas() {
		Integer amarrasOcupadas = 0;
		for (Amarra a : amarras) {
			if (!a.getAmarraLibre()) {
				amarrasOcupadas++;
			}
		}
		return amarrasOcupadas;
	}

	public Integer getAmarrasLibres() {
		Integer amarrasLibres = 0;
		for (Amarra a : amarras) {
			if (a.getAmarraLibre()) {
				amarrasLibres++;
			}
		}
		return amarrasLibres;
	}

	public void agregarAmarra(Amarra amarraNueva) throws AmarraExistenteException, CantMaximaAmarrasException {
		if (amarras.contains(amarraNueva)) {
			amarraNueva = null;
			throw new AmarraExistenteException("La amarra que intenta crear ya existe");
		}
		if (amarras.size() >= this.cantAmarras) {
			amarraNueva = null;
			throw new CantMaximaAmarrasException("Se ha creado la totalidad de amarras posible");
		}
		amarras.add(amarraNueva);
	}

	public void amarrarBarco(Barco barco, Amarra amarra) throws NoSePuedeAmarrarException {

		if (barco.sePuedeAmarrar(amarra) && amarra.getAmarraLibre()) {
			amarra.amarraOcupada();
			fondeadero.put(amarra.getNroAmarra(), barco);
		} else {
			throw new NoSePuedeAmarrarException("La amarra no está disponible o el tamanio del barco se excede.");
		}
	}

	public void liberarAmarra(Amarra amarra) {
		if (fondeadero.containsKey(amarra.getNroAmarra()) && !amarra.getAmarraLibre()) {
			amarra.amarraLiberada();
			fondeadero.replace(amarra.getNroAmarra(), null);
		}
	}

	public Double precioAlquilerAmarra(Barco barco) {
		Double precioConMotor = 10_000.00;
		Double precioSinMotor = 9_000.00;
		Double esloraHastaveinte = 2_000.00;
		Double esloraMayorVeinte = 3_000.00;
		Double precio = 0.0;

		if (barco.getMotor() && barco.getEslora() <= 20.0) {
			precio = precioConMotor + esloraHastaveinte;
		} else {
			if (barco.getMotor() && barco.getEslora() > 20.0) {
				precio = precioConMotor + esloraMayorVeinte;
			}
		}
		if (!barco.getMotor() && barco.getEslora() <= 20.0) {
			precio = precioSinMotor + esloraHastaveinte;
		} else {
			if (!barco.getMotor() && barco.getEslora() > 20.0) {
				precio = precioSinMotor + esloraMayorVeinte;
			}
		}
		return precio;
	}

	public Double fecturacionTotal() {
		Double facturacionTotal = 0.0;
		for (Barco b : fondeadero.values()) {
			if (b != null) {
				facturacionTotal += precioAlquilerAmarra(b);
			}
		}
		return facturacionTotal;
	}

}
