package ar.edu.unlp.info.oo1.ejercicio13_clienteCorreo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ClienteTest {
	private ClienteDeCorreo unCliente;
	private Carpeta unaCarpeta;
	
	@BeforeEach
	void setUp() {
		unCliente = new ClienteDeCorreo();
		
		Email mailVacio = new Email("Un mail", "Para probar");
		Email mailAdjuntos = new Email("Otro email", "Mas pesado que el anterior");
		Email mailTercero = new Email("Un tercero", "De Prueba");
		
		Archivo archivo = new Archivo("adjunto", 20);
		mailAdjuntos.adjuntar(archivo);
		
		unCliente.recibir(mailVacio);
		unCliente.recibir(mailAdjuntos);
		unCliente.recibir(mailTercero);
	}
	
	@Test
	void testMover() {
		unaCarpeta = new Carpeta("CarpetaSecundaria");
		unCliente.nuevaCarpeta(unaCarpeta);
		assertEquals(3, unCliente.getInbox().getEmails().size());
		Email mailCuarto = new Email("A mover", "Hay que seguir probando");
		unCliente.recibir(mailCuarto);
		assertEquals(4, unCliente.getInbox().getEmails().size());
		unCliente.mover(mailCuarto, unCliente.getInbox(), unaCarpeta);
		assertEquals(3, unCliente.getInbox().getEmails().size());
		assertEquals(1, unaCarpeta.getEmails().size());
	}
	
	@Test
	void testEspacio() {
		assertEquals(35, unCliente.espacioOcupado());
		unaCarpeta = new Carpeta("CarpetaSecundaria");
		unCliente.nuevaCarpeta(unaCarpeta);
		Email mailCuarto = new Email("A mover", "Hay que seguir probando");
		unCliente.recibir(mailCuarto);
		unCliente.mover(mailCuarto, unCliente.getInbox(), unaCarpeta);
		assertEquals(40, unCliente.espacioOcupado());
		
	}
	
	@Test
	void testBuscar() {
		unaCarpeta = new Carpeta("CarpetaSecundaria");
		unCliente.nuevaCarpeta(unaCarpeta);
		Email mailCuarto = new Email("A mover", "Hay que seguir probando");
		unCliente.recibir(mailCuarto);
		assertEquals(mailCuarto, unCliente.buscar("Hay que seguir probando"));
		unCliente.mover(mailCuarto, unCliente.getInbox(), unaCarpeta);
		assertEquals(mailCuarto, unCliente.buscar("A mover"));
		Email mailQuinto = new Email("No esta", "Devuelve null");
		assertNull(unCliente.buscar("No esta"));
	}
	
	
}
