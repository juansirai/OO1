package ar.edu.unlp.info.oo1.ejercicio04_figurasYCuerpos;

public class Cuadrado extends Figura{
	private double lado;
	
	public Cuadrado(double lado) {
		this.lado = lado;
	}
	public Cuadrado() {};
	
	public double getLado() {
		return this.lado;
	}
	public void setLado(double lado) {
		this.lado = lado;
	}
	
	
	public double getArea() {
		return this.lado * this.lado;
	}
	
	public double getPerimetro() {
		return this.lado * 4;
	}
	
}
