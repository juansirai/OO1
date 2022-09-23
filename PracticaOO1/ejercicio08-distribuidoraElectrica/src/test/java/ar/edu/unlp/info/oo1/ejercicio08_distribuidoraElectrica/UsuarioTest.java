package ar.edu.unlp.info.oo1.ejercicio08_distribuidoraElectrica;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	private Usuario usuario;
	
	@BeforeEach
	void setUp() throws Exception{
		this.usuario = new Usuario("22 y 60", "Juan");
	}
	
	@Test
	void ultimoConsumoActiva() {
		Consumo cUno = new Consumo(124,1203);
		Consumo cDos = new Consumo(214, 342);
		Consumo cTres = new Consumo(353, 352);
		
		this.usuario.agregarMedicion(cUno);
		this.usuario.agregarMedicion(cDos);
		this.usuario.agregarMedicion(cTres);
		
		assertEquals(353, this.usuario.ultimoConsumoActiva());
	}
}
