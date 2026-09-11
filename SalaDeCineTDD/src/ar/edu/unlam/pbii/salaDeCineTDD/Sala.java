package ar.edu.unlam.pbii.salaDeCineTDD;

public class Sala {

	private Butaca[][] butacas;
	private Pelicula pelicula;
	private Integer cantButacas = 0;
	private Integer butacasOcupadas = 0;
	private Integer filas;
	private Integer columnas;

	public Sala(Integer filas, Integer columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.butacas = new Butaca[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				this.butacas[i][j] = new Butaca();
				cantButacas++;
			}
		}
	}

	public void proyectarPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public Integer getCantButacas() {
		return this.cantButacas;
	}

	public Integer butacasDisponibles() {
		return cantButacas - this.butacasOcupadas;
	}

	public Integer butacasOcupadas() {
		return this.butacasOcupadas;
	}

	public void cambiarPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public void venderBoleto(Integer fila, Integer columna, Integer edad) {
		if (fila >= this.filas || fila < 0 || columna >= this.columnas || columna < 0)
			return;
		if (butacas[fila][columna].estaOcupada())
			return;
		if (edad < pelicula.getEdadMinima() || edad < 0)
			return;
		butacas[fila][columna].ocuparButaca();
		this.butacasOcupadas++;
	}

	public void devolverBoleto(Integer fila, Integer columna) {
		if (fila >= this.filas || fila < 0 || columna >= this.columnas || columna < 0)
			return;
		if (!butacas[fila][columna].estaOcupada())
			return;
		butacas[fila][columna].liberarButaca();
		this.butacasOcupadas--;
	}
}
