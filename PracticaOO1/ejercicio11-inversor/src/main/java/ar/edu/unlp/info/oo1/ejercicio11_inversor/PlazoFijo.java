package ar.edu.unlp.info.oo1.ejercicio11_inversor;

import java.time.LocalDate;
import java.time.Period;

public class PlazoFijo implements Inversion{
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo() {
	}
	
	public PlazoFijo(double monto, double interes) {
		this.fechaDeConstitucion = LocalDate.now();
		this.montoDepositado = monto;
		this.porcentajeDeInteresDiario = interes;
	}
	
	public double valorActual() {
		Period period = Period.between(fechaDeConstitucion, LocalDate.now());
		int days = period.getDays();
		double interes = this.porcentajeDeInteresDiario * this.montoDepositado *days;
		return interes + montoDepositado;
	}
	
	public void modificarFecha(LocalDate fecha) {
		/*solo a efectos de poder testear luego con otra fecha la generacion de interes*/
		this.fechaDeConstitucion = fecha;
	}
	
	public double getMontoInicial() {
		return this.montoDepositado;
	}
	
	public double getInteresDiario() {
		return this.porcentajeDeInteresDiario;
	}
}
