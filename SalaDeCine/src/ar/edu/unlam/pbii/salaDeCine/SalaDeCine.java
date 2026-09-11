package ar.edu.unlam.pbii.salaDeCine;

public class SalaDeCine {

	Butaca[][] butacas;
	Pelicula pelicula;

	public SalaDeCine(Integer filas, Integer columnas) {
		this.butacas = new Butaca[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				this.butacas[i][j] = new Butaca();
			}
		}
	}

	public void proyectarPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	public void cambiarPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public Butaca[][] getEstadoButacas() {
		return this.butacas;
	}

	public Boolean venderBoleto(Integer fila, Integer columna, Integer edad) {
		if (this.butacas[fila][columna].getEstadoButaca()) {
			System.out.println("Butaca ocupada");
			return false;
		}
		if (pelicula.puedeVerla(edad)) {
			System.out.println("Edad incorrecta");
			return false;
		}
		this.butacas[fila][columna].ocupar();
		return this.butacas[fila][columna].getEstadoButaca();
	}
	
	public void imprimirButacas(Butaca[][] butacas) {
		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[0].length; j++) {
				System.out.print(butacas[i][j] + " ");
			}
			System.out.println("");

		}
	}
	
	public void mensajeDeVenta(Boolean sePudo) {
		if (sePudo) {
			System.out.println("Venta realizada correctamente");
		} else {
			System.out.println("No pudo realizarse la venta");
		}
	}

}
