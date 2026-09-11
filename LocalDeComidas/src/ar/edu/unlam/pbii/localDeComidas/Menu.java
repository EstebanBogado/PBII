package ar.edu.unlam.pbii.localDeComidas;

import java.util.Arrays;

public class Menu {
	private String nombreMenu;
	private Plato[] platos = new Plato[2];
	int cantidad = 0;

	public Menu(String nombreMenu) {
		this.setNombreMenu(nombreMenu);
		for (int i = 0; i < this.platos.length; i++)
			this.platos[i] = null;
	}

	public String getNombreMenu() {
		return nombreMenu;
	}

	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public void setPlato(Plato plato) {
		for (int i = 0; i < this.platos.length; i++) {
			if (this.platos[i] == null) {
				this.platos[i] = plato;
				cantidad++;
				return;
			}
//			if (this.cantidad < this.platos.length && this.platos[i] == null) {
//				this.platos[cantidad] = plato;
//				cantidad++;
//				return;
//			}
			if (this.cantidad == this.platos.length) {
				this.platos = Arrays.copyOf(this.platos, this.platos.length * 2);
			}
		}
	}

	public Integer getPlatos() {
		return this.cantidad;
	}

//	public void eliminarPlato(Plato plato) {
//		for (int i = 0; i < this.cantidad; i++) {
//			if (this.platos[i] == plato) {
//				this.platos[i] = null;
//				cantidad--;
//			}
//		}
//	}
	
	public void eliminarPlato(Plato plato) {
	    for (int i = 0; i < this.cantidad; i++) {
	        if (this.platos[i] == plato) {
	            // corro todos los elementos siguientes un lugar hacia atrás
	            for (int j = i; j < this.cantidad - 1; j++) {
	                this.platos[j] = this.platos[j + 1];
	            }
	            this.platos[this.cantidad - 1] = null; // limpio la última posición ocupada
	            cantidad--;
	            return; // ya encontré y eliminé, no sigo buscando
	        }
	    }
	}

//	@Override
//	public String toString() {
//		return "Nnombre Menu= " + this.nombreMenu + "\n Platos= \n" + Arrays.toString(platos) + ", cantidad= " + this.cantidad
//				+ "\n";
//	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Nombre Menu= ").append(this.nombreMenu).append("\n Platos= \n");
	    for (int i = 0; i < this.platos.length; i++) {
	        if (this.platos[i] != null) {          // <- acá está la clave
	            sb.append(this.platos[i].toString()).append("\n");
	        }
	    }
	    sb.append("cantidad= ").append(this.cantidad).append("\n");
	    return sb.toString();
	}
}
