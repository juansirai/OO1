package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDateTime;

public abstract class Llamada{
	private LocalDateTime comienzo;
	private int duracion;
	private String llamador;
	private String receptor;
	
	public Llamada(LocalDateTime comienzo, int duracion, String llamador, String receptor) {
		this.comienzo = comienzo;
		this.duracion = duracion;
		this.llamador = llamador;
		this.receptor = receptor;
	}
	
	abstract double getCosto();
	
	public int getDuracionMinutos() {
		return this.duracion;
	}
	
	protected boolean esDiurna() {
		return this.comienzo.getHour()>=8 && this.comienzo.getHour()<20;
	}
}
