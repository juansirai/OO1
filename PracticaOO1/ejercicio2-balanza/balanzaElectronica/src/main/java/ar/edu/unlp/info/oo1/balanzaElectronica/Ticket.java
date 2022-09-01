package ar.edu.unlp.info.oo1.balanzaElectronica;

import java.time.LocalDate;

public class Ticket {
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	
	public Ticket(int cantidadProductos, double precioTotal, double pesoTotal) {
		this.fecha = LocalDate.now();
		this.cantidadDeProductos = cantidadProductos;
		this.precioTotal = precioTotal;
		this.pesoTotal = pesoTotal;
	}
	
	
	public double impuesto() {
		double imp = this.precioTotal * 0.21;
		return imp;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	public void setFecha(LocalDate d) {
		this.fecha = d;
	}
	
	public int getCantidadDeProductos() {
		return this.cantidadDeProductos;
	}
	public void setCantidadDeProductos(int p) {
		this.cantidadDeProductos = p;
	}
	
	public double getPrecioTotal() {
		return this.precioTotal ;
	}
	public void setPrecioTotal(double p) {
		this.precioTotal = p;
	}
	
	public double getPesoTotal() {
		return this.pesoTotal;
	}
	public void setPesoTotal(double p) {
		this.pesoTotal = p;
	}
}
