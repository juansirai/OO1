package ar.edu.unlp.info.oo1.ejercicio14_intervalosTiempo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse implements InterfaceDate{
	private LocalDate from;
	private LocalDate to;
	

	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public LocalDate getFrom() {
		return this.from;
	}
	
	@Override
	public LocalDate getTo() {
		return this.to;
	}
	
	@Override
	public int sizeInDays() {
		return (int) ChronoUnit.DAYS.between(this.getFrom(), this.getTo());
	}
	
	@Override
	public boolean includesDate(LocalDate date) {
		return (date.isAfter(this.getFrom()) && date.isBefore(this.getTo())) ||
				date.isEqual(this.getFrom()) ||
				date.isEqual(this.getTo());
	}
	
	public boolean overLaps(LocalDate ini, LocalDate fin) {
		return this.includesDate(ini) || this.includesDate(fin);
	}

}
