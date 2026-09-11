package ar.edulunlam.pbii.banco;

import java.util.HashMap;
import java.util.Map;

public class Banco {
	private Map<String, Cuenta> cuentas = new HashMap<>();

	public void registrarCuenta(String cbu, Double saldoInicial)
			throws MontoInvalidoException, CuentaDuplicadaException {
		if (saldoInicial < 0) {
			throw new MontoInvalidoException("No se puede dar de alta una cuenta con saldo inicial negativo.");
		}
		if (cuentas.containsKey(cbu)) {
			throw new CuentaDuplicadaException("No se puede crear dos cuestos con el mismo CBU");
		}
		this.cuentas.put(cbu, new Cuenta(cbu, saldoInicial));
	}

	public Double getSaldo(String cbu) {
		return buscarCuenta(cbu).getSaldo();
	}

	private Cuenta buscarCuenta(String cbu) {
		return this.cuentas.get(cbu);
	}

	public void depositar(String cbu, Double monto) throws MontoInvalidoException, CuentaDuplicadaException {
		buscarCuenta(cbu).depositar(monto);
	}

	public void retirar(String cbu, Double monto) throws MontoInvalidoException, CuentaDuplicadaException {
		buscarCuenta(cbu).retirar(monto);
	}

	public Boolean transferirConTryCatch(String cbuOrigen, String cbuDestino, Double monto) {
		// throws TransferenciaInvalidaException, MontoInvalidoException {
		Boolean transfErronea = true;
		try {
			if (cbuOrigen.equals(cbuDestino)) {
				throw new TransferenciaInvalidaException("No se puede transferir a la misma cuenta");
			}
			if (monto <= 0) {
				throw new MontoInvalidoException("El monto a transferir debe ser mayor a cero");
			}
			if (monto > getSaldo(cbuOrigen)) {
				throw new MontoInvalidoException("El monto a transferir debe ser menor o igual al saldo disponible");
			}
			buscarCuenta(cbuOrigen).retirar(monto);
			buscarCuenta(cbuDestino).depositar(monto);
		} catch (MontoInvalidoException e) {
			return transfErronea;
		} catch (TransferenciaInvalidaException t) {
			return transfErronea;
		}
		return transfErronea = false;
	}

	public void transferir(String cbuOrigen, String cbuDestino, Double monto)
			throws TransferenciaInvalidaException, MontoInvalidoException {
		if (cbuOrigen.equals(cbuDestino)) {
			throw new TransferenciaInvalidaException("No se puede transferir a la misma cuenta");
		}
		if (monto <= 0) {
			throw new MontoInvalidoException("El monto a transferir debe ser mayor a cero");
		}
		if (monto > getSaldo(cbuOrigen)) {
			throw new MontoInvalidoException("El monto a transferir debe ser menor o igual al saldo disponible");
		}
		buscarCuenta(cbuOrigen).retirar(monto);
		buscarCuenta(cbuDestino).depositar(monto);

	}

}