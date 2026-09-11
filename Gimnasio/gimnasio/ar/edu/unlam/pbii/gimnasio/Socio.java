package ar.edu.unlam.pbii.gimnasio;

public class Socio {
	private String apeNom;
	private Integer nroSocio;
	private Intensidad intensidad;
	private Integer sesionesSemanales;
	private Integer duracionPlan;

	public Socio(String apeNom, Integer nroSocio, Intensidad intensidad, Integer sesionesSemanales, Integer duracionPlan) {
		this.apeNom = apeNom;
		this.nroSocio = nroSocio;
		this.intensidad = intensidad;
		this.sesionesSemanales = sesionesSemanales;
		this.duracionPlan = duracionPlan;
	}

	public String getApeNOm() {
		return this.apeNom;
	}

	public Integer getNroSocio() {
		return this.nroSocio;
	}

	public Intensidad getIntensidad() {
		return this.intensidad;
	}

	public Integer getSesionesSemanales() {
		return this.sesionesSemanales;
	}

	public Integer getDuracion() {
		return this.duracionPlan;
	}

}
