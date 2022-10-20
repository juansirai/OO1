package ar.edu.unlp.info.oo1.Ejercicio15_AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadTest {
	private Propiedad propiedadConReservas;
	private Propiedad propiedadLibre;
	private Usuario propietario;
	private Reserva reservaUno;
	private Reserva reservaDos;
	private Reserva reservaTres;
	
	@BeforeEach
	void setUp() {
		this.propietario = new Usuario("Juan", "22 y 60",  37260);
		this.propiedadLibre = new Propiedad("El depto","En frente de la pana",150,
											"22 y 60",propietario);
		
		this.propiedadConReservas = new Propiedad("El PH","Calle 7",150,
												  "7 y 32",propietario);
		this.reservaUno = new Reserva(LocalDate.of(2022, 12, 1), LocalDate.of(2022, 12, 31), this.propiedadConReservas); //30 dias
		this.reservaDos = new Reserva(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), this.propiedadConReservas); //30 dias
		this.reservaTres = new Reserva(LocalDate.of(2022, 11, 1), LocalDate.of(2022, 11, 30), this.propiedadConReservas); // 29 dias
		
		this.propiedadConReservas.agregarReserva(reservaUno);
		this.propiedadConReservas.agregarReserva(reservaDos);
		this.propiedadConReservas.agregarReserva(reservaTres);
		this.propietario.agregarPropiedad(propiedadConReservas);
	}
	
	@Test
	void testDisponibilidad() {
		assertTrue(this.propiedadConReservas.estaDisponible(LocalDate.of(2022, 10, 1),LocalDate.of(2022, 10, 30)));
		assertTrue(this.propiedadConReservas.estaDisponible(LocalDate.of(2023, 1, 1),LocalDate.of(2023, 11, 30)));
		assertFalse(this.propiedadConReservas.estaDisponible(LocalDate.of(2022, 10, 1),LocalDate.of(2022, 11, 2)));
		assertFalse(this.propiedadConReservas.estaDisponible(LocalDate.of(2022, 11, 2),LocalDate.of(2023, 2, 2)));
		
		assertTrue(this.propiedadLibre.estaDisponible(LocalDate.of(2022, 10, 1),LocalDate.of(2022, 10, 30)));
	}
	
	@Test
	void testIngresos() {
		assertEquals(13350, this.propiedadConReservas.calcularIngresos(LocalDate.of(2022, 11, 1),LocalDate.of(2023, 12, 31)));
		assertEquals(9000,this.propiedadConReservas.calcularIngresos(LocalDate.of(2022, 12, 1),LocalDate.of(2023, 12, 31))); 
	}
}
