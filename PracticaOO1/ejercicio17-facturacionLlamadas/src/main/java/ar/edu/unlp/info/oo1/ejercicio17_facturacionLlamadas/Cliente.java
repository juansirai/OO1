package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private String nombre;
	private String direccion;
	private String numeroAsignado;
	private List<Llamada> llamadas;
	
	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.llamadas = new ArrayList<Llamada>();
	}
	
	public void asignarNumero(String numero) {
		this.numeroAsignado=numero;
	}
	
	public void agregarLlamada(Llamada llamada) {
		this.llamadas.add(llamada);
	}
	
	public String getNumeroAsignado() {
		return this.numeroAsignado;
	}
	
	
	public double calcularMontoAdeudado(LocalDateTime ini, LocalDateTime fin) {
		return this.llamadas.stream()
				.mapToDouble(llam -> llam.getCosto())
				.sum();
	}
}
