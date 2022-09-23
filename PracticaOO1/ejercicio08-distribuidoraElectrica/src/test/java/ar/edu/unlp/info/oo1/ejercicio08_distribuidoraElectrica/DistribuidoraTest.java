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
	  
	  
	  
}
	  /*Se ejecuta el metodo de la clase Empleado Jerarquico, el cual llama a la de la clase Empleado.
	   * La clase empleado invoca a Aportes y Monto Basico, que se ejecutan desde la clase Gerente.
	   * Luego se adicionan los 8000 del bono por categoria.*/
