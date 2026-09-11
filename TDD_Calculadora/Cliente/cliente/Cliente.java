package cliente;

public class Cliente {

	private String nombre;
	private Double descuento;
	private Categoria categoria = null;

	public Cliente() {

	}

	public Cliente(String nombre, Double descuento) {
		this.nombre = nombre;
		this.descuento = descuento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Double getDescuento() {
//		switch (categoria) {
//		case REGULAR:
//			return categoria.getPorcentaje();
//		case BRONCE:
//			return this.descuento = 0.07;
//		case PLATA:
//			return this.descuento = 0.18;
//		case ORO:
//			return this.descuento = 0.22;
//		case DIAMANTE:
//			return this.descuento = 0.30;
//		case null:
//			return this.descuento;
//		}
		return this.descuento;
	}

	public void setCatCli(Categoria catCli) {
		this.categoria = catCli;
	}

	public Categoria getCatCli() {
		return this.categoria;
	}
}