package ar.edu.unlp.info.oo1.balanzaElectronica;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public Producto(double peso, double precio, String desc) {
		this.peso = peso;
		this.precioPorKilo =precio;
		this.descripcion = desc;
	}
	public Producto() {};
	
	public void setPrecioPorKilo(double precio) {
		this.precioPorKilo = precio;
	}
	public double getPrecioPorKilo() {
		return this.precioPorKilo;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPeso() {
		return this.peso;
	}
	
	public void setDescripcion(String d) {
		this.descripcion = d;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public double getPrecio() {
		
		return this.getPeso() * this.getPrecioPorKilo();
	}
}
