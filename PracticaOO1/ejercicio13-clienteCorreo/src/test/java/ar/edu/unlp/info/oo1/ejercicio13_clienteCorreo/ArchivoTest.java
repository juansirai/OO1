package ar.edu.unlp.info.oo1.ejercicio13_clienteCorreo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArchivoTest {
	private Archivo archivo;
	
	@BeforeEach
	void setUp() {
		archivo = new Archivo("UnArchivo", 10);
	}
	
	@Test
	void testTamanio() {
		assertEquals(10, archivo.tamanio());
	}
	
	@Test
	void testNombre() {
		assertEquals("UnArchivo", archivo.getNombre());
	}
}
