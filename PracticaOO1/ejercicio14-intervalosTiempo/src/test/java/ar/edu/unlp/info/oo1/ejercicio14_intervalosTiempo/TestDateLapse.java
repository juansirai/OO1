package ar.edu.unlp.info.oo1.ejercicio14_intervalosTiempo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDateLapse {
	private DateLapse intervalo;
	private LocalDate from = LocalDate.of(2020, 9, 3);
	private LocalDate to = LocalDate.of(2020, 9, 27);
	
	@BeforeEach
	void setUp() {
		intervalo = new DateLapse(from, to);
	}
	
	@Test
	void testFrom() {
		assertEquals(from, intervalo.getFrom());
	}
	
	@Test
	void testTo() {
		assertEquals(to, intervalo.getTo());
	}
	
	@Test
	void testDays() {
		assertEquals(24, intervalo.sizeInDays());
	}
	
	@Test
	void testIncludes() {
		LocalDate esta = LocalDate.of(2020, 9, 10);
		LocalDate noEsta = LocalDate.of(2020, 9, 30);
		assertTrue(intervalo.includesDate(esta));
		assertFalse(intervalo.includesDate(noEsta));
	}
}
