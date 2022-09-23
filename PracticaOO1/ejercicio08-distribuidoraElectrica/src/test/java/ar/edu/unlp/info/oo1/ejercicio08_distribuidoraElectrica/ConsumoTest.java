package ar.edu.unlp.info.oo1.ejercicio08_distribuidoraElectrica;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsumoTest {
	private Consumo consumo;
	
	  @BeforeEach
	  void setUp() throws Exception {
	    this.consumo = new Consumo(10, 12);
	  }
	  
	  @Test
	  void testConstructor() {
		  assertEquals(10, this.consumo.consumoEnergiaActiva());
		  assertEquals(12, this.consumo.consumoEnergiaReactiva());
	  }
	  
	  @Test
	  void testFactorDePotencia() {
		  assertEquals(0.64, Math.round(this.consumo.factorDePotencia() * 100)/100d);
	  }
	  
	  @Test
	  void costoEnBaseA() {
		  assertEquals(100 ,this.consumo.costoEnBaseA(10));
	  }

}
