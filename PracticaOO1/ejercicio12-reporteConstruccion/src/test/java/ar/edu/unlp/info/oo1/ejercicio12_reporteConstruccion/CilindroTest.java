package ar.edu.unlp.info.oo1.ejercicio12_reporteConstruccion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class CilindroTest {
	private Cilindro cilindro;
	
	@BeforeEach
    void setUp() {
    	cilindro = new Cilindro("Hierro","Rojo",20,15);
    } 
	
	@Test
	void testConstructor() {
		assertEquals("Hierro", cilindro.getMaterial());
		assertEquals("Rojo", cilindro.getColor());
		assertEquals(20, cilindro.radio());
		assertEquals(15, cilindro.altura());
	}
	
	@Test 
	void testSuperficie() {
		assertEquals(4398.2297, cilindro.getSuperficie(),4);
	}
	
	@Test
	void testVolumen() {
		assertEquals(18849.5559, cilindro.getVolumen(),4);
	}
}
