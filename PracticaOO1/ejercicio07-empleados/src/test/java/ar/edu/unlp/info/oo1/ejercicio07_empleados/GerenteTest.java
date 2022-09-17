package ar.edu.unlp.info.oo1.ejercicio07_empleados;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GerenteTest {
	 private Gerente gerente;
	  
	  

	  @BeforeEach
	  void setUp() throws Exception {
	    this.gerente = new Gerente("Ale");

	  }

	  @Test
	  void testConstructor() {
		  assertEquals("Ale", this.gerente.nombre());
	  }
	  
	  @Test
	  void testAportes() {
		  assertEquals( 2850 , this.gerente.aportes());
	  }
	  
	  @Test
	  void testSueldoBasico() {
		  assertEquals( 67850 , this.gerente.sueldoBasico());
	  }
	  /*Se ejecuta el metodo de la clase Empleado Jerarquico, el cual llama a la de la clase Empleado.
	   * La clase empleado invoca a Aportes y Monto Basico, que se ejecutan desde la clase Gerente.
	   * Luego se adicionan los 8000 del bono por categoria.*/
}	


