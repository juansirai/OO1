package ar.edu.unlp.info.oo1.ejercicio12_reporteConstruccion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteTest {
	private ReporteDeConstruccion reporte;
	private Esfera esfera;
	private PrismaRectangular prisma;
	private Cilindro cilindro;
	
	@BeforeEach
	void setUp() {
		this.reporte = new ReporteDeConstruccion();
		this.esfera = new Esfera("Madera", "Rojo", 20);
		this.prisma = new PrismaRectangular("Madera", "Verde",20,10,15);
		this.cilindro = new Cilindro("Hierro","Rojo",20,15);
		this.reporte.agregarPieza(cilindro);
		this.reporte.agregarPieza(esfera);
		this.reporte.agregarPieza(prisma);
	}
	
	@Test
	void testVolumenDeMaterial() {
		assertEquals(36510.3216, reporte.volumenDeMaterial("Madera"),4);
	}
	
	@Test
	void testSuperficieDeColor() {
		assertEquals(9424.7779, reporte.superficieDeColor("Rojo"),4);
	}
}
