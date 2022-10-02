package ar.edu.unlp.info.oo1.ejercicio12_reporteConstruccion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EsferaTest {
	private Esfera esfera;
	
	@BeforeEach
	void setup() {
		this.esfera = new Esfera("Madera", "Roja", 20);
	}
	
	@Test
	void testConstructor() {
		assertEquals("Madera", esfera.getMaterial());
		assertEquals("Roja", esfera.getColor());
		assertEquals(20, esfera.radio());
	}
	
	@Test
	void testVolumen() {
		assertEquals(33510.3216, esfera.getVolumen(), 4);
	}
	
	@Test
	void testSuperficie() {
		assertEquals(5026.5482, esfera.getSuperficie(), 4);
	}
	
}
