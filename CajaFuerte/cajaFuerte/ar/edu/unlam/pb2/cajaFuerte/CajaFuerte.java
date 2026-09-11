package ar.edu.unlam.pb2.cajaFuerte;

public class CajaFuerte {

	private final static Integer MASTER_KEY = 1111;
	private final static Character TOKEN = '*';
	private Integer clave = null;
	private Boolean cajaAbierta;
	private Boolean cajaCerrada;
	private int intentoFallido = 0;
	private boolean bloqueada = false;
	private Integer claveIngresada;

	public CajaFuerte() {
		this.cajaAbierta = true;
		this.cajaCerrada = false;
	}

	public Boolean abierta() {
		return this.cajaAbierta;
	}

	public Boolean cerrada() {
		return this.cajaCerrada;
	}

	public void cerrarCajaFuerte() {
		this.cajaAbierta = false;
		this.cajaCerrada = true;
	}

	public void abrirCajaFuerte() {
		this.cajaCerrada = false;
		this.cajaAbierta = true;
	}

	public void ingresarCodigo(Integer claveAcceso) {
		if (this.clave.equals(claveAcceso) && !this.bloqueada) {
			if (abierta()) {
				cerrarCajaFuerte();
				this.intentoFallido = 0;
			} else {
				if (cerrada()) {
					abrirCajaFuerte();
					this.intentoFallido = 0;
				}
			}
		} else {
			this.intentoFallido++;
		}

		if (this.intentoFallido == 3) {
			this.bloqueada = true;
		}
	}

	public void generarClave(char a, char b, Integer claveNueva) {
		if (a == '#' && b == '*' && !CajaFuerte.MASTER_KEY.equals(claveNueva)) {
			this.clave = claveNueva;
		}
	}
	
	public Integer getClaveUsuario() {
		return this.clave;
	}

	public Integer getClaveIngresada() {
		return this.claveIngresada;
	}

	public void setClaveIngresada(Integer claveIngresada) {
		this.claveIngresada = claveIngresada;
	}

	public Boolean getStatusInicial() {
		return this.cajaAbierta = true;
	}

	public Boolean getBloqueada() {
		return this.bloqueada;
	}

	public int getContador() {
		return this.intentoFallido;
	}

	public void masterKey(char token, Integer claveMaestra) {
		if(CajaFuerte.TOKEN.equals(token) && CajaFuerte.MASTER_KEY.equals(claveMaestra)) {
			this.bloqueada = false;
			this.clave = null;
		}
	}
}