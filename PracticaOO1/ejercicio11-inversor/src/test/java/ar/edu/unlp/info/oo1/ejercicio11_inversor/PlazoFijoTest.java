package ar.edu.unlp.info.oo1.ejercicio11_inversor;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PlazoFijoTest {
	private PlazoFijo plazoFijo;
	
    @BeforeEach
    void setUp() {
    	plazoFijo = new PlazoFijo(200, 0.05);
    } 
    
    @Test
    void testContructor() {
    	assertEquals(200, plazoFijo.getMontoInicial());
    	assertEquals(0.05, plazoFijo.getInteresDiario());
    }
    
    @Test
    void testValorActual() {
    	/*a efectos de testear modificamos la fecha de constitucion*/
    	plazoFijo.modificarFecha(LocalDate.of(2022, 9, 20));
    	assertEquals(310, plazoFijo.valorActual());
    }
}
