package ar.edu.unlp.info.oo1.Ejercicio18_liquidacionHaberes;

import java.time.LocalDate;

public class ContratoPorHoras extends Contrato{
	private double valorHora;
	private int horasMes;
	private LocalDate fechaFin;
	
	public ContratoPorHoras(LocalDate inicio, double valorHora, int horasMes, LocalDate fechaFin, Empleado e) {
		super(inicio, e);
		this.valorHora = valorHora;
		this.horasMes = horasMes;
		this.fechaFin = fechaFin;
	}

	@Override
	double calcularMontoBasico() {
		return this.valorHora * this.horasMes;
	}

	@Override
	boolean esVencido() {
		// TODO Auto-generated method stub
		return !this.fechaFin.isAfter(LocalDate.now());
				
	}

}