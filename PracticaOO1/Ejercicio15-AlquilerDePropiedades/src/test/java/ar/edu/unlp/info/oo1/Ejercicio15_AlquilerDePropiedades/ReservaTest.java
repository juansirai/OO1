package ar.edu.unlp.info.oo1.Ejercicio15_AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReservaTest {
	private Reserva unaReserva;
	private Reserva reservaFutura;
	private Propiedad propiedadUno;
	private Usuario propietarioUno;
	
	@BeforeEach
	void setUp() {
		this.propietarioUno = new Usuario("Juan","22 y 60",37260);
		this.propiedadUno = new Propiedad("El depto","En frente de la pana",105.10,
										  "Calle 22 y 60",this.propietarioUno);
		this.propietarioUno.agregarPropiedad(propiedadUno);
		this.unaReserva = new Reserva(LocalDate.of(2022,2,14), LocalDate.of(2023,2,14), this.propiedadUno);
		
		this.reservaFutura = new Reserva(LocalDate.of(2023, 1, 2), LocalDate.of(2023, 5, 20), this.propiedadUno);
	}
	
	
	@Test
	void testOverlap() {
		assertTrue(this.unaReserva.overlapea(LocalDate.of(2022,2, 10), LocalDate.of(2022, 2, 28)));
		assertTrue(this.unaReserva.overlapea(LocalDate.of(2022, 3, 11), LocalDate.of(2023, 5, 20)));
		assertFalse(this.unaReserva.overlapea(LocalDate.of(2022, 2, 5), LocalDate.of(2022, 2, 13)));
	}
	
	@Test
	void testDiasReservados() {
		assertEquals(365, this.unaReserva.diasReservados());
	}
	
	@Test
	void testCostoReserva() {
		assertEquals(38361.5, this.unaReserva.getCosto());
	}
	
	@Test
	void testMayorA() {
		assertFalse(this.unaReserva.mayorFechaActual());
		assertTrue(this.reservaFutura.mayorFechaActual());
	}
	
	@Test
	void testEntreFechas() {
		LocalDate fechaUno = LocalDate.of(2022,2, 10);
		LocalDate fechaDos = LocalDate.of(2023, 5, 28);
		LocalDate fechaTres = LocalDate.of(2023, 1, 3);
		assertTrue(this.unaReserva.entreFechas(fechaUno, fechaDos));
		assertFalse(this.reservaFutura.entreFechas(fechaTres, fechaDos));
	}
	
}
