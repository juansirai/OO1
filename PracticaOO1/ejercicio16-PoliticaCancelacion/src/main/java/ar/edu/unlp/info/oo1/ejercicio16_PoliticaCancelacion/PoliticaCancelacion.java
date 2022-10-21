package ar.edu.unlp.info.oo1.ejercicio16_PoliticaCancelacion;

import java.time.LocalDate;

public interface PoliticaCancelacion {
	
	abstract double montoReembolsar(Reserva reserva, LocalDate fecha);
}
