package ar.edulunlam.pbii.banco;

public class MontoInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public MontoInvalidoException(String mensaje) {
		super(mensaje);
	}
}
