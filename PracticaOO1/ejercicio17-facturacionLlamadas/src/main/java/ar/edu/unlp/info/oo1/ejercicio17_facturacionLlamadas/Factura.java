package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Factura {
	Cliente cliente;
	LocalDate fechaFactura;
	LocalDateTime inicio;
	LocalDateTime fin;
	double monto;
	
	public Factura(Cliente cliente, LocalDateTime inicio, LocalDateTime fin, double monto) {
		
		this.cliente = cliente;
		this.fechaFactura = LocalDate.now();
		this.inicio = inicio;
		this.fin = fin;
		this.monto = monto;
	}
}
