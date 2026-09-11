package ar.edulunlam.pbii.banco;

public class TransferenciaInvalidaException extends Exception {
	private static final long serialVersionUID = 1L;

	public TransferenciaInvalidaException(String mensaje) {
		super(mensaje);
	}
}
