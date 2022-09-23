package ar.edu.unlp.info.oo1.ejercicio08_distribuidoraElectrica;

import java.time.LocalDate;

public class Consumo {
	private LocalDate date;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(double EA, double ER) {
		this.date = LocalDate.now();
		this.consumoEnergiaActiva = EA;
		this.consumoEnergiaReactiva = ER;
	}
	
	
	public double consumoEnergiaActiva() {
		return this.consumoEnergiaActiva;
	}
	
	public double consumoEnergiaReactiva() {
		return this.consumoEnergiaReactiva;
	}
	
	public double factorDePotencia() {
		
		double activa_2 = Math.pow(consumoEnergiaActiva,2);
		double reactiva_2 = Math.pow(consumoEnergiaReactiva, 2);
		double denominador = Math.sqrt(reactiva_2 + activa_2);
		
		return consumoEnergiaActiva / denominador;
	}
	
	public double costoEnBaseA(double precioKW) {
		return this.consumoEnergiaActiva * precioKW;
	}
}
