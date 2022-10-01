package ar.edu.unlp.info.oo1.ejercicio11_inversor;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversionAccionesTest {
	private InversionEnAcciones inversion;
	
    @BeforeEach
    void setUp() {
    	inversion = new InversionEnAcciones("Balanz", 20, 30);
    } 
    
    @Test
    void testConstructor() {
    	assertEquals("Balanz", inversion.getNombre());
    	assertEquals(20, inversion.getCantidad());
    	assertEquals(30, inversion.getValorUnitario());
    }
    
    @Test
    void testValorActual() {
    	assertEquals(600, inversion.valorActual());
    }
}
