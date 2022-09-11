package ar.edu.unlp.info.oo1.ejercicio04_figurasYCuerpos;

public class Cuerpo3D {
	private Figura caraBasal;
	private double altura;
	
	public Cuerpo3D(Figura caraBasal, double altura) {
		this.altura = altura;
		this.caraBasal = caraBasal;
	}
	
	public Cuerpo3D() {};
	
	public void setAltura(double a) {
		this.altura = a;
	}
	public double getAltura() {
		return this.altura;
	}
	
	public void setCaraBasal(Figura cara) {
		this.caraBasal = cara;
	}
	
	public double getVolumen() {	
		return this.caraBasal.getArea() * this.altura;
	}
	
	public double getSuperficieExterior() {
		return 2 * this.caraBasal.getArea() + this.caraBasal.getPerimetro() * this.altura;
	}
}
