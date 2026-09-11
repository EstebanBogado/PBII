package cliente;

public enum Categoria {
	
	
	REGULAR(0.03), BRONCE(0.07), PLATA(0.18), ORO(0.22), DIAMANTE(0.30);

	private final Double porcentaje;

	Categoria(Double porcentaje){
		this.porcentaje = porcentaje;
	}
	
	public Double getPorcentaje() {
		return this.porcentaje;
	}

}