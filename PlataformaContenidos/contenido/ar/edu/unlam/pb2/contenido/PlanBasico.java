package ar.edu.unlam.pb2.contenido;

public class PlanBasico extends Plan {
	Integer limiteMensual = 3;

	public PlanBasico(CategoriaPlan categoria) {
		super(categoria);
	}

	@Override
	public Double costoAdicionales() {
		return 0.0;
	}

	@Override
	public Double getCostoPlan() {
		// TODO Auto-generated method stub
		return this.categoria.getPrecioBase();
	}

	@Override
	public Double getAdicional() {
		return this.categoria.getAdicional();
	}

	@Override
	public Double getDescuento() {
		// TODO Auto-generated method stub
		return this.categoria.getDescuentoPlan();
	}

	@Override
	public Double getCostoTotal(Usuario usuario) {
		// TODO Auto-generated method stub
		return getCostoPlan() + usuario.costoAdicionales();
	}

	@Override
	public Integer getLimiteMensual() {
		// TODO Auto-generated method stub
		return this.limiteMensual;
	}

	@Override
	public Integer getCantUsuariosPlan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaPlan getCategoria() {
		// TODO Auto-generated method stub
		return this.categoria;
	}
}
