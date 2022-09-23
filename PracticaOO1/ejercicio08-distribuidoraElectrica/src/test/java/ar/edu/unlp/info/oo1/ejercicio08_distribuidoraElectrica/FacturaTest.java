package ar.edu.unlp.info.oo1.ejercicio08_distribuidoraElectrica;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacturaTest {
	private Factura factura;
	
	@BeforeEach
	 void setUp() throws Exception {
	   this.factura = new Factura(1200, 0.1);
	   Usuario user = new Usuario("22 y 60", "Juan");
	   this.factura.setUsuario(user);
	 }
	
	@Test
	void montoTotal() {
		assertEquals(1080, this.factura.montoTotal());
	}
}
