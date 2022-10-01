package ar.edu.unlp.info.oo1.ejercicio11_inversor;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	String nombre;
	List<Inversion> inversiones;
	
	public Persona() {
		this.inversiones = new ArrayList<Inversion>();
	}
	public Persona(String nombre) {
		this.nombre = nombre;
		this.inversiones = new ArrayList<Inversion>();
	}
	
	
	public void agregarInversion(Inversion i) {
		this.inversiones.add(i);
	}
	
	public double valorActual() {
		double result = this.inversiones.stream()
				.mapToDouble(inversion -> inversion.valorActual())
				.sum();
		return result;
	}
}
