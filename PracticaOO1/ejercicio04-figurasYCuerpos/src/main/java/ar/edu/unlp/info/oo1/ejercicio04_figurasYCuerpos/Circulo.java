package ar.edu.unlp.info.oo1.ejercicio04_figurasYCuerpos;

public class Circulo extends Figura{
	private double radio;
	
	public Circulo(double r) {
		this.radio = r;
	}
	
	public Circulo() {};
	
	public double getDiametro() {
		return this.radio * 2 ;
	}

	
	public void setRadio(double r) {
		this.radio = r;
	}
	public double getRadio() {
		return this.radio;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radio, 2);
	}
	
	public double getPerimetro() {
		return Math.PI * this.getDiametro();
	}
}
