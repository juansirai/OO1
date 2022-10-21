package ar.edu.unlp.info.oo1.ejercicio16_PoliticaCancelacion;

import java.time.LocalDate;

public class Flexible implements PoliticaCancelacion{
	
	public double montoReembolsar(Reserva reserva, LocalDate fecha) {
		double resultado=0;
		if(reserva.esPosteriorA(fecha)){
			resultado = reserva.getCosto();
		}
		return resultado;
	}
}
