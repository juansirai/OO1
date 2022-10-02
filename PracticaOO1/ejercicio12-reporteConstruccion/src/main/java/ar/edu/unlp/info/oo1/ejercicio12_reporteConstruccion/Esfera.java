package ar.edu.unlp.info.oo1.ejercicio12_reporteConstruccion;

public class Esfera extends Pieza{
	private int radio;
	
	public Esfera(String material, String color, int radio) {
		super(material, color);
		this.radio = radio;
	}
	
	public int radio() {
		return this.radio;
	}
	
	
	public double getVolumen() {
		return (double)(4.0/3.0) * Math.PI * Math.pow(this.radio, 3);
	}
	
	public double getSuperficie() {
		return 4 * Math.PI * Math.pow(radio, 2);
	}
}
