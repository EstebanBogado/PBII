package ar.edu.unlam.pbii.amarras;

public abstract class Barco implements EsAmarrable {
	protected String nombre;
	protected Double eslora;
	protected Double manga;
	protected Boolean motor;

	public Barco(String nombre, Double eslora, Double manga) {
		this.nombre = nombre;
		this.eslora = eslora;
		this.manga = manga;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Double getEslora() {
		return this.eslora;
	}

	public Double getManga() {
		return this.manga;
	}
	
	public Boolean getMotor() {
		return this.motor;
	}

	public Boolean sePuedeAmarrar(Amarra amarra) throws NoSePuedeAmarrarException {
		Double supYate = this.eslora * this.manga;
		try {
			return supYate <= amarra.getSupAmarra() && amarra.getAmarraLibre();

		} catch (Exception e) {
			throw new NoSePuedeAmarrarException("La superficie del barco excede la de la amarra");

		}
		}}
