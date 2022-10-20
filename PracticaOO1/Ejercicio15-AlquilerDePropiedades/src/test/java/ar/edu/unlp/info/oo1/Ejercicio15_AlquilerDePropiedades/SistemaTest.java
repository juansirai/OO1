package ar.edu.unlp.info.oo1.Ejercicio15_AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	private Sistema OOBnB;
	
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
		this.OOBnB = new Sistema();
		this.propietario = this.OOBnB.registrarUsuario("Juan", "22 y 60",  37260);
		this.inquilino = this.OOBnB.registrarUsuario("Pedro", "22 y 60",  34260);
		this.propiedadUno = this.OOBnB.registrarPropiedad("El depto","Cerca de la pana",150,
										  "22 y 60", this.propietario);
		this.propiedadDos = this.OOBnB.registrarPropiedad("Un PH","En otro lado",180,
				  						  "22 y 30", this.propietario);
		this.propiedadTres = this.OOBnB.registrarPropiedad("La baticueva","En la luna",200,
				  						   "Marte", this.propietario);

		this.reservaUno = this.OOBnB.efectuarReserva(LocalDate.of(2022, 12, 1), LocalDate.of(2022, 12, 31), this.propiedadUno, inquilino); //30 dias
		this.reservaDos = this.OOBnB.efectuarReserva(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), this.propiedadUno, inquilino); //30 dias
		this.reservaTres = this.OOBnB.efectuarReserva(LocalDate.of(2021, 12, 1), LocalDate.of(2021, 12, 31), this.propiedadTres, inquilino); 	
	}
	
	@Test
	void testRegistrarUsuario() {
		this.OOBnB.registrarUsuario("Roberto", "22 y 60",  37260);
		this.OOBnB.registrarUsuario("Patricio", "23 y 50", 2367);
		assertEquals(4, this.OOBnB.getUsuarios().size());
	}
	
	@Test
	void testRegistrarPropiedad() {
		this.OOBnB.registrarPropiedad("Una nueva","Cerca de la pana",150,
										  "22 y 60", this.propietario);
		assertEquals(4, this.OOBnB.getPropiedades().size());
	}
	
	@Test
	void testEfectuarReserva() {
		// testeo sobre propiedades
		this.OOBnB.efectuarReserva(LocalDate.of(2022, 11, 1), LocalDate.of(2022,11, 30), this.propiedadUno, this.inquilino);
		this.OOBnB.efectuarReserva(LocalDate.of(2023, 9, 1), LocalDate.of(2023,9, 30), this.propiedadUno, this.inquilino);
		this.OOBnB.efectuarReserva(LocalDate.of(2021, 12, 1), LocalDate.of(2021, 12, 15), this.propiedadTres, this.inquilino); //esta no se efectua
		assertEquals(5, this.OOBnB.obtenerReservasUsuario(this.inquilino).size());
		// los de eliminar no los puedo testear ya que no tengo el puntero a la Reserva.
		this.OOBnB.eliminarReserva(reservaDos);
		assertEquals(4, this.OOBnB.obtenerReservasUsuario(this.inquilino).size());
		this.OOBnB.eliminarReserva(reservaTres); //esta no se elimina pq es anterior a fecha actual
		assertEquals(4, this.OOBnB.obtenerReservasUsuario(this.inquilino).size());
	}
	
	@Test
	void testReservasUsuario() {
		assertEquals(3, this.OOBnB.obtenerReservasUsuario(inquilino).size());
	}
	
	@Test
	void testIngresosPropietario() {
		assertEquals(9000, this.OOBnB.calcularIngresosPropietario(propietario, LocalDate.of(2022, 12, 1), LocalDate.of(2023, 12, 31)));
	}
}
