package ar.edu.unlp.info.oo1.ejercicio14_intervalosTiempo;

import java.time.LocalDate;

public class DateLapseAlt implements InterfaceDate{
	private LocalDate from;
	private int sizeInDays;
	
	public DateLapseAlt(LocalDate from, int sizeInDays) {
		this.from = from;
		this.sizeInDays = sizeInDays;
	}
	
	
	@Override
	public LocalDate getFrom() {
		// TODO Auto-generated method stub
		return this.from;
	}
	@Override
	public LocalDate getTo() {
		// TODO Auto-generated method stub
		return this.from.plusDays(this.sizeInDays());
	}
	@Override
	public int sizeInDays() {
		// TODO Auto-generated method stub
		return this.sizeInDays;
	}
	@Override
	public boolean includesDate(LocalDate date) {
		// TODO Auto-generated method stub
		return (date.isAfter(this.getFrom()) && date.isBefore(this.getTo())) ||
				date.isEqual(this.getFrom()) ||
				date.isEqual(this.getTo());
	}
}
