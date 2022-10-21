package ar.edu.unlp.info.oo1.ejercicio16_PoliticaCancelacion;

import java.time.LocalDate;

public class Moderada implements PoliticaCancelacion{
	/* Si una propiedad tiene política de cancelación moderada, se reembolsará 
	 * el monto total si la cancelación se hace hasta una semana antes y 50% 
	 * si se hace hasta 2 días antes*/
	
	public double montoReembolsar(Reserva reserva, LocalDate fecha) {
		double resultado=0;
		if(reserva.evaluateStartDate(fecha)<=-7)
			resultado = reserva.getCosto();
		else
			resultado = reserva.getCosto() * 0.5;
				
		return resultado;
	}
}
