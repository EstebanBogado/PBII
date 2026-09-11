package ar.edu.unlam.pb2.contenido;

public class PlanFamiliar extends Plan {
	Integer limiteMensual = 3;


	public PlanFamiliar(CategoriaPlan categoria) {
		super(categoria);
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
		return this.categoria.getDescuentoPlan();
	}

	@Override
	public Double getCostoTotal(Usuario usuario) {
		// TODO Auto-generated method stub
		Double costoTotal = getCostoPlan() + usuario.costoAdicionales();
		return costoTotal -= costoTotal * getDescuento();
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
	public Double costoAdicionales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaPlan getCategoria() {
		// TODO Auto-generated method stub
		return this.categoria;
	}

}
