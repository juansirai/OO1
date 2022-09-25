package ar.edu.unlp.info.oo1.ejercicio09_cuentaConGanchos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCuentaCorriente {
	private CuentaCorriente cuentaUno;
	private CuentaCorriente cuentaDos;
	
	@BeforeEach
	 void setUp() throws Exception {
		this.cuentaUno = new CuentaCorriente();
		this.cuentaDos = new CuentaCorriente();
		
		this.cuentaUno.setLimiteDescubierto(20);
		this.cuentaDos.setLimiteDescubierto(30);
	 }
	
	@Test
	void extraer() {
		this.cuentaUno.depositar(100);
		assertFalse(this.cuentaUno.extraer(130));
		assertTrue(this.cuentaUno.extraer(120));
		this.cuentaDos.depositar(100);
		assertFalse(this.cuentaDos.extraer(131));
		assertTrue(this.cuentaDos.extraer(130));
	}
	
	@Test
	void transferir() {
		this.cuentaUno.depositar(100);
		assertFalse(this.cuentaUno.transferirACuenta(130, cuentaDos));
		assertTrue(this.cuentaUno.transferirACuenta(120, cuentaDos));
		assertEquals(-20, this.cuentaUno.getSaldo());
		assertEquals(120, this.cuentaDos.getSaldo());
	}
}
