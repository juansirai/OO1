package ar.edu.unlp.info.oo1.ejercicio12_reporteConstruccion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrismaTest {
	private PrismaRectangular prisma;
	
	@BeforeEach
	void setUp() {
		prisma = new PrismaRectangular("Madera", "Verde",20,10,15);
	}
	
	@Test
	void testConstructor() {
		assertEquals("Madera", prisma.getMaterial());
		assertEquals("Verde", prisma.getColor());
		assertEquals(20, prisma.ladoMayor());
		assertEquals(10, prisma.ladoMenor());
		assertEquals(15, prisma.altura());
	}
	
	@Test
	void testVolumen() {
		assertEquals(3000,prisma.getVolumen());
	}
	
	@Test
	void testSuperficie() {
		assertEquals(1300, prisma.getSuperficie());
	}
}
