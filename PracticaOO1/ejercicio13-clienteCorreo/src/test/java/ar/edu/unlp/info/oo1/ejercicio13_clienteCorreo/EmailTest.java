package ar.edu.unlp.info.oo1.ejercicio13_clienteCorreo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {
	private Email email;
	
	@BeforeEach
	void setUp() {
		email = new Email("Hola a todes", "Este es un email de saludo");
	}
	
	@Test
	void testTamanio() {
		assertEquals(5, email.tamanio());
		Archivo archivoUno = new Archivo("A", 10);
		Archivo archivoDos = new Archivo("B",30);
		email.adjuntar(archivoUno);
		email.adjuntar(archivoDos);
		assertEquals(45, email.tamanio());
		email.desadjuntar(archivoUno);
		assertEquals(35, email.tamanio());
	}
	
	@Test
	void testTitulo() {
		assertEquals("Hola a todes", email.getTitulo());
	}
	
	@Test
	void testCuerpo() {
		assertEquals("Este es un email de saludo", email.getCuerpo());
	}
	
	@Test
	void testAdjuntos() {
		List<Archivo> adjuntos = new ArrayList<Archivo>();
		Archivo archivoUno = new Archivo("A", 10);
		Archivo archivoDos = new Archivo("B",30);
		adjuntos.add(archivoUno);
		adjuntos.add(archivoDos);
		email.adjuntar(archivoUno);
		email.adjuntar(archivoDos);
		assertEquals(adjuntos, email.adjuntos());
	}
}
