package ar.edu.unlp.info.oo1.ejercicio16_PoliticaCancelacion;


import java.time.LocalDate;

import ar.edu.unlp.info.oo1.ejercicio14_intervalosTiempo.DateLapse;

public class Reserva {
	private DateLapse periodo;
	private Propiedad propiedad;
	
	public Reserva(LocalDate ini, LocalDate fin, Propiedad propiedad) {
		// Como hago para que directamente retorne null al objeto reserva??
		// actualmente lo checkea Propiedad y Usuario, pero no correspondería a reserva?
		this.periodo = new DateLapse(ini, fin);
		this.propiedad = propiedad;
	}
	
	public boolean overlapea(LocalDate ini, LocalDate fin) {
		return this.periodo.overLaps(ini, fin);
	}
	
	public int diasReservados() {
		return this.periodo.sizeInDays();	
	}
	
	public double getCosto() {
		return this.diasReservados() * this.propiedad.getPrecioNoche();
	}
	
	public Boolean mayorFechaActual() {
		return this.periodo.getFrom().isAfter(LocalDate.now());
	}
	
	public Boolean entreFechas(LocalDate ini, LocalDate fin) {
		return //this.periodo.getFrom().isAfter(ini) && this.periodo.getTo().isBefore(fin);
			   this.periodo.getFrom().compareTo(ini)>=0 && this.periodo.getTo().compareTo(fin)<=0;
	}
	
	public boolean esPosteriorA(LocalDate fecha) {
		return fecha.isBefore(this.periodo.getFrom());
	}
	
	public int evaluateStartDate(LocalDate fecha) {
		return this.periodo.compareWithFrom(fecha);
	}
}
