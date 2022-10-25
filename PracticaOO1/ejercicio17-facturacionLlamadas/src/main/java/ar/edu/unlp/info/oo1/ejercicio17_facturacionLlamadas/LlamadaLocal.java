package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDateTime;

public class LlamadaLocal extends Llamada{

	public LlamadaLocal(LocalDateTime comienzo, int duracion, String llamador, String receptor) {
		super(comienzo, duracion, llamador, receptor);
	}

	@Override
	double getCosto() {
		return 1 * super.getDuracionMinutos();
	}
}
