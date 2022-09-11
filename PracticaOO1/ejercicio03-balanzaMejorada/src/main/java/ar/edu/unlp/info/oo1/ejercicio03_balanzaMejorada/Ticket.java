package ar.edu.unlp.info.oo1.ejercicio03_balanzaMejorada;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private List<Producto> productos;
	
	
	public Ticket(List<Producto> productos) {
		this.fecha = LocalDate.now();
		this.productos = productos;
	}
	
	
	public double impuesto() {
		double imp = this.getPrecioTotal() * 0.21;
		return imp;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}
	
	
	public double getPrecioTotal() {
		double result = this.productos.stream()
			     		.mapToDouble(p -> p.getPrecio()).sum();
		return result;
	}
	
	
	public double getPesoTotal() {
		double result = this.productos.stream()
				        .mapToDouble(p -> p.getPeso()).sum();
		return result;
	}
		
	public List<Producto> getProductos(){
		return this.productos;
	}
}