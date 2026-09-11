package ar.edu.unlam.pbii.amarras;

public class NoSePuedeAmarrarException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSePuedeAmarrarException(String mensaje) {
		super(mensaje);
	}
}
