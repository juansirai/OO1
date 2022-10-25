package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDateTime;

public class LlamadaInternacional extends Llamada {
	private String paisOrigen;
	private String paisDestino;
	
	public LlamadaInternacional(LocalDateTime comienzo, int duracion, String llamador, String receptor,String paisOrigen, String paisDestino) {
		super(comienzo, duracion, llamador, receptor);
		this.paisDestino = paisDestino;
		this.paisOrigen = paisOrigen;
	}

	@Override
	double getCosto() {
		if(super.esDiurna())
			return 4 * super.getDuracionMinutos();
		else
			return 3 * super.getDuracionMinutos();
	}
}
