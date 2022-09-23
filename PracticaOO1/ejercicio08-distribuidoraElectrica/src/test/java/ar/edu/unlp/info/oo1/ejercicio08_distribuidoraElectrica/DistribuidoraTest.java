package ar.edu.unlp.info.oo1.ejercicio08_distribuidoraElectrica;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DistribuidoraTest {
	 private Distribuidora distribuidora;
	  
	  

	  @BeforeEach
	  void setUp() throws Exception {
	    this.distribuidora = new Distribuidora(125);

	  }

	  @Test
	  void testConstructor() {
		  assertEquals(125, this.distribuidora.precioKWh());
	  }
	  
	  @Test
	  void testAgregarUsuario() {
		  Usuario u = new Usuario("Calle 22", "Juan");
		  this.distribuidora.agregarUsuario(u);
		  
		  assertEquals(u, this.distribuidora.ultimoUsuario());
	  }
	  
	  @Test
	  void testConsumoTotal() {
		  Usuario d = new Usuario("Calle 22", "Juan");
		  Usuario e = new Usuario("Calle f", "Pedro");
		  Usuario g = new Usuario("Callesa f", "Ramon");
		  Consumo a = new Consumo(123, 421);
		  Consumo b = new Consumo(125, 222);
		  Consumo c = new Consumo(111, 353);
		  
		  d.agregarMedicion(a);
		  e.agregarMedicion(b);
		  g.agregarMedicion(c);
		  
		  this.distribuidora.agregarUsuario(d);
		  this.distribuidora.agregarUsuario(e);
		  this.distribuidora.agregarUsuario(g);
		  
		  assertEquals(123 + 125 + 111, this.distribuidora.consumoTotalActiva());
		  
	  }
	  
}
