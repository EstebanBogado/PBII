package ar.edu.unlam.pbii.localDeComidas;

public class Local {
	private String nombreDelLocal;
	private Menu menu;

	public Local(String nombreDelLocal) {
		this.nombreDelLocal = nombreDelLocal;
	}

	public String getNombreDelLocal() {
		return this.nombreDelLocal;
	}

	public void setMenu(Menu menuCasaCentral) {
		this.menu = menuCasaCentral;
	}

	public Integer getMenu() {
		return menu.getPlatos();
	}
	
	public void listarMenu() {
		System.out.println(this.menu.toString());
	}
}
