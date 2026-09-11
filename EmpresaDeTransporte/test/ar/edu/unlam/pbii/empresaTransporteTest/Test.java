package ar.edu.unlam.pbii.empresaTransporteTest;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unlam.pbii.empresaTransporte.Auto;
import ar.edu.unlam.pbii.empresaTransporte.Bicicleta;
import ar.edu.unlam.pbii.empresaTransporte.Camion;
import ar.edu.unlam.pbii.empresaTransporte.Paquete;
import ar.edu.unlam.pbii.empresaTransporte.Vehiculo;

class Test {

	@org.junit.jupiter.api.Test
	void crearUnVehículoDeTransporteYQueNoSeaNull() {
		Vehiculo bicicleta = new Bicicleta(15.0, 0.125);
		Bicicleta bicicleta2 = new Bicicleta(15.0, 0.125);
		assertNotNull(bicicleta);
		assertNotNull(bicicleta2);
	}
	
	@org.junit.jupiter.api.Test
	public void crearUnaBicicleta() {
		Bicicleta bicicleta = new Bicicleta(15.0, 0.125);
		assertNotNull(bicicleta);
	}

	@org.junit.jupiter.api.Test
	void crearUnaBicicletaDeTransporteYQueValideSiLaCargaMaximaEsValida() {
		Integer valorEsperado = 2;
		Vehiculo bicicleta = new Bicicleta(15.0, 0.125);
		((Bicicleta) bicicleta).setDestinoInicial("castelar");
		Paquete paquete1 = new Paquete(65.0, 0.075);
		paquete1.setDestino("Ramos Mejía");
		Paquete paquete2 = new Paquete(7.0, 0.04);
		paquete2.setDestino("Castelar");
		Paquete paquete3 = new Paquete(8.0, 0.05);
		paquete3.setDestino("Morón");
		Paquete paquete4 = new Paquete(8.0, 0.07, "casteLAR");
		bicicleta.setCarga(paquete1);
		bicicleta.setCarga(paquete2);
		bicicleta.setCarga(paquete3);
		bicicleta.setCarga(paquete4);
		assertEquals(Integer.valueOf(valorEsperado), bicicleta.cantPaquetes());
	}

	@org.junit.jupiter.api.Test
	void crearUnaBicicletaDeTransporteYValidarQueElDestinoDeLasCargasSeaElMismo() {
		Integer valorEsperado = 2;
		Vehiculo bicicleta = new Bicicleta(15.0, 0.125);
		((Bicicleta) bicicleta).setDestinoInicial("haedo");
		Paquete paquete1 = new Paquete(5.0, 0.075, "Haedo");
		Paquete paquete2 = new Paquete(6.0, 0.04);
		paquete2.setDestino("San Justo");
		Paquete paquete3 = new Paquete(8.0, 0.05);
		paquete3.setDestino("Haedo");
		bicicleta.setCarga(paquete1);
		bicicleta.setCarga(paquete2);
		bicicleta.setCarga(paquete3);
		assertEquals(Integer.valueOf(valorEsperado), bicicleta.cantPaquetes());
	}

	@org.junit.jupiter.api.Test
	void crearUnAutoDeTransporteYQueNoSeaNull() {
		Auto auto = new Auto(500.0, 2.0);
		assertNotNull(auto);
	}

	@org.junit.jupiter.api.Test
	void crearUnAutoDeTransporteYCargarleUnPqueteValido() {
		Integer valorEsperado = 1;
		Auto auto = new Auto(500.0, 2.0);
		Paquete paquete = new Paquete(150.0, 1.25, "Morón");
		auto.setCarga(paquete);
		assertEquals(Integer.valueOf(valorEsperado), auto.cantPaquetes());
	}

	@org.junit.jupiter.api.Test
	void crearUnAutoDeTransporteYCargarleUnPqueteDeMasYQueIncrementeElTamanioDelArray() {
		Integer valorEsperado = 4;
		Auto auto = new Auto(500.0, 2.0);
		Paquete paquete1 = new Paquete(150.0, 1.25, "Morón");
		Paquete paquete2 = new Paquete(50.0, 0.25, "Ramos Mejía");
		Paquete paquete3 = new Paquete(80.0, 0.15, "Haedo");
		Paquete paquete4 = new Paquete(70.0, 0.25, "San Justo");
		auto.setCarga(paquete1);
		auto.setCarga(paquete2);
		auto.setCarga(paquete3);
		auto.setCarga(paquete4);
		assertEquals(Integer.valueOf(valorEsperado), auto.cantPaquetes());
	}

	@org.junit.jupiter.api.Test
	void crearUnAutoDeTransporteYCargarleTresPaquetesYQueLosSeteeEnLaCarga() {
		Integer valorEsperado = 3;
		Auto auto = new Auto(500.0, 2.0);
		Paquete paquete1 = new Paquete(150.0, 1.25, "Morón");
		Paquete paquete2 = new Paquete(50.0, 0.25, "Ramos Mejía");
		Paquete paquete3 = new Paquete(80.0, 0.15, "Haedo");
		auto.setCarga(paquete1);
		auto.setCarga(paquete2);
		auto.setCarga(paquete3);
		assertEquals(Integer.valueOf(valorEsperado), auto.cantPaquetes());
	}

	@org.junit.jupiter.api.Test
	void crearUnAutoDeTransporteYCargarlePesoDemasYQueNoAgregueElExceso() {
		Integer valorEsperado = 3;
		Auto auto = new Auto(500.0, 2.0);
		Paquete paquete1 = new Paquete(150.0, 1.25, "Morón");
		Paquete paquete2 = new Paquete(50.0, 0.25, "Ramos Mejía");
		Paquete paquete3 = new Paquete(80.0, 0.15, "Haedo");
		Paquete paquete4 = new Paquete(370.0, 0.25, "San Justo");
		auto.setCarga(paquete1);
		auto.setCarga(paquete2);
		auto.setCarga(paquete3);
		auto.setCarga(paquete4);
		assertEquals(Integer.valueOf(valorEsperado), auto.cantPaquetes());
	}

	@org.junit.jupiter.api.Test
	void crearUnAutoDeTransporteYCargarleVolumenDemasYQueNoAgregueElExceso() {
		Integer valorEsperado = 3;
		Auto auto = new Auto(500.0, 2.0);
		Paquete paquete1 = new Paquete(150.0, 1.25, "Morón");
		Paquete paquete2 = new Paquete(50.0, 0.25, "Ramos Mejía");
		Paquete paquete3 = new Paquete(80.0, 0.15, "Haedo");
		Paquete paquete4 = new Paquete(70.0, 1.25, "San Justo");
		auto.setCarga(paquete1);
		auto.setCarga(paquete2);
		auto.setCarga(paquete3);
		auto.setCarga(paquete4);
		assertEquals(Integer.valueOf(valorEsperado), auto.cantPaquetes());
	}

	@org.junit.jupiter.api.Test
	void crearUnCamionDeTransporteYQueNoSeaNull() {
		Vehiculo camion = new Camion(16000.0, 20.0);
		assertNotNull(camion);
	}

	@org.junit.jupiter.api.Test
	void crearUnCamionDeTransporteYValidarQuePuedeRecibirUnaCarga() {
		Integer valorEsperado = 1;
		Vehiculo camion = new Camion(16000.0, 20.0);
		Paquete paquete = new Paquete(16000.0, 2.5, "Morón");
		camion.setCarga(paquete);
		assertEquals(Integer.valueOf(valorEsperado), camion.cantPaquetes());
	}

	@org.junit.jupiter.api.Test
	void crearUnCamionDeTransporteYValidarQuePuedeRecibirVariasCargasPeroNoExcedeSucapacidadMaxima() {
		Integer valorEsperado = 4;
		Vehiculo camion = new Camion(16000.0, 20.0);
		Paquete paquete = new Paquete(6000.0, 2.5, "Morón");
		Paquete paquete1 = new Paquete(4000.0, 2.5, "Morón");
		Paquete paquete2 = new Paquete(3000.0, 2.5, "Morón");
		Paquete paquete3 = new Paquete(2000.0, 2.5, "Morón");
		Paquete paquete4 = new Paquete(6000.0, 2.5, "Morón");
		camion.setCarga(paquete);
		camion.setCarga(paquete1);
		camion.setCarga(paquete2);
		camion.setCarga(paquete3);
		camion.setCarga(paquete4);
		assertEquals(Integer.valueOf(valorEsperado), camion.cantPaquetes());
	}

	@org.junit.jupiter.api.Test
	void crearUnCamionDeTransporteYValidarQuePuedeRecibirVariasCargasPeroNoExcedeSuVolumenMaximo() {
		Integer valorEsperado = 4;
		Vehiculo camion = new Camion(16000.0, 20.0);
		Paquete paquete = new Paquete(6000.0, 2.5, "Morón");
		Paquete paquete1 = new Paquete(4000.0, 2.5, "Haedo");
		Paquete paquete2 = new Paquete(3000.0, 12.5, "Ramos Mejía");
		Paquete paquete3 = new Paquete(2000.0, 2.5, "Castelar");
		Paquete paquete4 = new Paquete(1000.0, 2.5, "Ituzaingó");
		camion.setCarga(paquete);
		camion.setCarga(paquete1);
		camion.setCarga(paquete2);
		camion.setCarga(paquete3);
		camion.setCarga(paquete4);
		assertEquals(Integer.valueOf(valorEsperado), camion.cantPaquetes());
	}

	@org.junit.jupiter.api.Test
	void crearUnCamionDeTransporteYValidarQuePuedeRecibirVariasCargas() {
		Integer valorEsperado = 8;
		Vehiculo camion = new Camion(16000.0, 20.0);
		Paquete paquete = new Paquete(2000.0, 2.5, "Morón");
		Paquete paquete1 = new Paquete(2000.0, 2.5, "Haedo");
		Paquete paquete2 = new Paquete(2000.0, 2.5, "Ramos Mejía");
		Paquete paquete3 = new Paquete(2000.0, 2.5, "Castelar");
		Paquete paquete4 = new Paquete(1000.0, 2.5, "Ituzaingó");
		Paquete paquete5 = new Paquete(3000.0, 2.5, "Ramos Mejía");
		Paquete paquete6 = new Paquete(2000.0, 2.5, "Castelar");
		Paquete paquete7 = new Paquete(1000.0, 2.5, "Ituzaingó");
		camion.setCarga(paquete);
		camion.setCarga(paquete1);
		camion.setCarga(paquete2);
		camion.setCarga(paquete3);
		camion.setCarga(paquete4);
		camion.setCarga(paquete5);
		camion.setCarga(paquete6);
		camion.setCarga(paquete7);
		assertEquals(Integer.valueOf(valorEsperado), camion.cantPaquetes());
		assertEquals(Integer.valueOf(12), camion.getPaquete());
	}

	@org.junit.jupiter.api.Test
	void prueba() {
		Paquete paquete = new Paquete(5.0, 0.125);
		assertNotNull(paquete);
	}

}
