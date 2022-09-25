package ar.edu.unlp.info.oo1.ejercicio09_cuentaConGanchos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCajaDeAhorro {
	private CajaDeAhorro caja;
	private CajaDeAhorro caja2;
	
	@BeforeEach
	 void setUp() throws Exception {
	   this.caja = new CajaDeAhorro();
	   this.caja2 = new CajaDeAhorro();
	 }
	
	@Test
	void depositar() {
		this.caja.depositar(100);
		assertEquals(98, caja.getSaldo());
	}
	
	@Test
	void extraer() {
		this.caja.depositar(100);
		assertFalse(caja.extraer(100));
		assertTrue(caja.extraer(96));
	}
	
	@Test
	void transferir() {
		this.caja.depositar(150); /*quedan 147 en el saldo*/
		assertFalse(this.caja.transferirACuenta(147, caja2));
		assertTrue(this.caja.transferirACuenta(50, caja2));
		assertEquals(49,this.caja2.getSaldo());
		assertEquals(96, this.caja.getSaldo());
	}
}
