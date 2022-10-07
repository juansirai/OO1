package ar.edu.unlp.info.oo1.ejercicio13_clienteCorreo;

public class Archivo {
	private String nombre;
	private double tamanio;
	
	public Archivo(String nombre, double tamanio) {
		this.nombre = nombre;
		this.tamanio = tamanio;
	}
	
	public Archivo(double tamanio) {
		this.tamanio = tamanio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	
	public double tamanio() {
		return this.tamanio;
	}
}
