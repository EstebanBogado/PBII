package ar.edu.unlam.pb2.contenido;

public class PlanPremium extends Plan {
	
	public PlanPremium(CategoriaPlan categoria) {
		super(categoria);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double getCostoPlan() {
		// TODO Auto-generated method stub
		return this.categoria.getPrecioBase();
	}

	@Override
	public Double getAdicional() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public Double getDescuento() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public Double getCostoTotal(Usuario usuario) {
		// TODO Auto-generated method stub
		return this.getCostoPlan() + costoAdicionales() - getDescuento();
	}

	@Override
	public Integer getLimiteMensual() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer getCantUsuariosPlan() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Double costoAdicionales() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public CategoriaPlan getCategoria() {
		// TODO Auto-generated method stub
		return this.categoria;
	}

}
