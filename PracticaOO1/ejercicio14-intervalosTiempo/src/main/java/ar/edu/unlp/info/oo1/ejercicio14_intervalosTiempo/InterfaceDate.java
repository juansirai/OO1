package ar.edu.unlp.info.oo1.ejercicio14_intervalosTiempo;

import java.time.LocalDate;

public interface InterfaceDate {
	
	abstract LocalDate getFrom();
	abstract LocalDate getTo();
	abstract int sizeInDays();
	abstract boolean includesDate(LocalDate date);
	

}
