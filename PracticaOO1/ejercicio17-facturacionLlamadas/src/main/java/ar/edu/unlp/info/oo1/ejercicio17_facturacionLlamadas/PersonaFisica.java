package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDateTime;

public class PersonaFisica extends Cliente{
	private int dni;
	
	public PersonaFisica(String nombre, String direccion, int dni) {
		super(nombre, direccion);
		this.dni = dni;
	}
	
	@Override
	public double calcularMontoAdeudado(LocalDateTime ini, LocalDateTime fin) {
		return super.calcularMontoAdeudado(ini, fin) * 0.9;
	}

}
