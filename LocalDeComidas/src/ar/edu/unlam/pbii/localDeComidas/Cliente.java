package ar.edu.unlam.pbii.localDeComidas;

public class Cliente {
	private String nombreCliente;
	private String catCli;

	public Cliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setCatCliente(String catCli) {
		this.catCli = catCli;
	}

	public String getCatCli() {
		return this.catCli;
	}
}
