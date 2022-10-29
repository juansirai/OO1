package ar.edu.unlp.info.oo1.Ejercicio18_liquidacionHaberes;

import java.time.LocalDate;

public abstract class Contrato {
	private LocalDate inicio;
	private Empleado empleado;
	
	public Contrato(LocalDate inicio, Empleado e) {
		this.inicio = inicio;
		this.empleado = e;
	}
	
	abstract double calcularMontoBasico();
	
	abstract boolean esVencido();
	
	public LocalDate getInicio() {
		return this.inicio;
	}
	
	protected Empleado empleado() {
		return this.empleado;
	}
	

}
