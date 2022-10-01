package ar.edu.unlp.info.oo1.ejercicio11_inversor;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PersonaTest {
	private Persona persona;
	private PlazoFijo pf;
	private InversionEnAcciones acciones;
	
	@BeforeEach
	void SetUp() {
		acciones = new InversionEnAcciones("Balanz", 20,30);
		pf = new PlazoFijo(200, 0.05);
		pf.modificarFecha(LocalDate.of(2022, 9, 20));
		persona = new Persona("Juan");
		
		persona.agregarInversion(acciones);
		persona.agregarInversion(pf);
	}
	
	@Test
	void testValorActual() {
		assertEquals(910, persona.valorActual());
	}

    
    
}
