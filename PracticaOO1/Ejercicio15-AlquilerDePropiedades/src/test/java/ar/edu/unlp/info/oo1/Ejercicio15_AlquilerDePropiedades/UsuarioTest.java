package ar.edu.unlp.info.oo1.Ejercicio15_AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	private Usuario propietario;
	private Usuario inquilino;
	private Reserva reservaUno;
	private Reserva reservaDos;
	private Reserva reservaTres;
	private Propiedad propiedadUno;
	private Propiedad propiedadDos;
	private Propiedad propiedadTres;
	
	@BeforeEach
	void setUp() {
		
		this.propietario = new Usuario("Juan", "22 y 60",  37260);
		this.propiedadUno = new Propiedad("El depto","Cerca de la pana",150,
										  "22 y 60", this.propietario);
		this.propiedadDos = new Propiedad("Un PH","En otro lado",180,
				  						  "22 y 30", this.propietario);
		this.propiedadTres = new Propiedad("La baticueva","En la luna",200,
				  						   "Marte", this.propietario);

		this.inquilino = new Usuario("Pedro", "23 y 50", 2367);
		this.reservaUno = new Reserva(LocalDate.of(2022, 12, 1), LocalDate.of(2022, 12, 31), this.propiedadUno); //30 dias
		this.reservaDos = new Reserva(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), this.propiedadUno); //30 dias
		this.reservaTres = new Reserva(LocalDate.of(2022, 12, 1), LocalDate.of(2022, 12, 31), this.propiedadTres); // 30 dias
	}
	
	@Test
	void testAgregarEliminarReserva() {
		this.inquilino.agregarReserva(reservaUno);
		this.inquilino.agregarReserva(reservaDos);
		assertEquals(2,this.inquilino.getReservas().size());
		this.inquilino.eliminarReserva(reservaDos);
		assertEquals(1, this.inquilino.getReservas().size());
	}
	
	@Test
	void testIngresos() {
		this.propiedadUno.agregarReserva(reservaUno);
		this.propiedadUno.agregarReserva(reservaDos);
		this.propiedadTres.agregarReserva(reservaTres);
		
		this.propietario.agregarPropiedad(propiedadUno);
		this.propietario.agregarPropiedad(propiedadDos);
		this.propietario.agregarPropiedad(propiedadTres);

		// 30 * 150 + 30*150 + 30 * 200 = 15000
		assertEquals(15000, this.propietario.calcularIngresos(LocalDate.of(2022, 11, 30), LocalDate.of(2024, 1, 1)));
		assertEquals(10500, this.propietario.calcularIngresos(LocalDate.of(2022, 11, 30), LocalDate.of(2023, 1, 1)));
	}
}
