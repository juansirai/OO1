package ar.edu.unlp.info.oo1.ejercicio11_inversor;

public class InversionEnAcciones implements Inversion{
	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	
	public InversionEnAcciones() {}
	public InversionEnAcciones(String nombre, int cantidad, double VU) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valorUnitario = VU;
	}
	
	public void nombre(String nombre) {
		this.nombre = nombre;
	}
	public void cantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void valorUnitario(double VU) {
		this.valorUnitario = VU;
	}
	
	public double valorActual() {
		return this.cantidad * this.valorUnitario;
	}
	public int getCantidad() {
		// TODO Auto-generated method stub
		return this.cantidad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public double getValorUnitario() {
		return this.valorUnitario;
	}
}
