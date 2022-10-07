package ar.edu.unlp.info.oo1.ejercicio13_clienteCorreo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarpetaTest {
	private Carpeta unaCarpeta;
	
	@BeforeEach
	void setUp() {
		unaCarpeta = new Carpeta("Inbox");
		Email mailVacio = new Email("Un mail", "Para probar");
		Email mailAdjuntos = new Email("Otro email", "Mas pesado que el anterior");
		Email mailTercero = new Email("Un tercero", "Hay que seguir probando");
		
		Archivo archivo = new Archivo("adjunto", 20);
		mailAdjuntos.adjuntar(archivo);
		
		unaCarpeta.agregarEmail(mailVacio);
		unaCarpeta.agregarEmail(mailAdjuntos);
		unaCarpeta.agregarEmail(mailTercero);
	}
	
	@Test
	void testTamanio() {
		assertEquals(35, unaCarpeta.tamanio());
	}
	
	@Test
	void testBorrar() {
		assertEquals(35, unaCarpeta.tamanio());
		Email mailBorrar = new Email("Un Cuarto", "Mail a borrar");
		unaCarpeta.agregarEmail(mailBorrar);
		assertEquals(40, unaCarpeta.tamanio());
		assertTrue(unaCarpeta.eliminarEmail(mailBorrar));
		assertEquals(35, unaCarpeta.tamanio());
		
	}
	
	@Test
	void testBuscar() {
		Email mailBuscar = new Email("Un tercero", "Hay que seguir probando");
		assertEquals(mailBuscar.getTitulo(), unaCarpeta.buscar("Hay que seguir probando").getTitulo());
		assertEquals(mailBuscar.getCuerpo(),unaCarpeta.buscar("Hay que seguir probando").getCuerpo());
		
		assertNull(unaCarpeta.buscar("Este no existe"));
	}
}
