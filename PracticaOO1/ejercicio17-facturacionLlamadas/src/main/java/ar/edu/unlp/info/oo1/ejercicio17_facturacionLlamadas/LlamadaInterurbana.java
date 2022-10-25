package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDateTime;

public class LlamadaInterurbana extends Llamada{
	private double distancia;
	
	
	public LlamadaInterurbana(LocalDateTime comienzo, int duracion, String llamador, String receptor, double distancia) {
		super(comienzo, duracion, llamador, receptor);
		this.distancia = distancia;
	}

	@Override
	double getCosto() {
		double cv = 0;
		if(this.distancia<100)
			cv = 2;
		else {
			if(this.distancia<500) {
				cv = 2.5;
			}
			else
				cv = 3;
		}
		return  5 + cv * super.getDuracionMinutos();
	}
	
	
}
