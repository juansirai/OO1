package ar.edu.unlp.info.oo1.ejercicio08_distribuidoraElectrica;

import java.time.LocalDate;

public class Factura {

	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	public Factura(double EA, double desc, Usuario usuario) {
		this.fecha = LocalDate.now();
		this.montoEnergiaActiva = EA;
		this.descuento = desc;
		this.usuario = usuario;
	}
	
	public Factura(double EA, double desc) {
		this.fecha = LocalDate.now();
		this.montoEnergiaActiva = EA;
		this.descuento = desc;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public double montoTotal() {
		return this.montoEnergiaActiva * (1-this.descuento);
	}
	
	public double descuento() {
		return this.montoEnergiaActiva * this.descuento;
	}
	
	public LocalDate fecha() {
		return this.fecha;
	}
	
	public Usuario usuario() {
		return this.usuario;
	}
}
