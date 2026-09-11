package ar.edu.unlam.pb2.contenido;

public abstract class Plan {
	protected CategoriaPlan categoria;

	public Plan(CategoriaPlan categoria) {
		this.categoria = categoria;
	}

	public abstract Double getCostoPlan();

	public abstract Double getAdicional();

	public abstract Double getDescuento();

	public abstract Double getCostoTotal(Usuario usuario);

	public abstract Integer getLimiteMensual();

	public abstract Integer getCantUsuariosPlan();

	public abstract Double costoAdicionales();

	public abstract CategoriaPlan getCategoria();

}
