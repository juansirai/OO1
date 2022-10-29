package ar.edu.unlp.info.oo1.Ejercicio18_liquidacionHaberes;

import java.time.LocalDate;

public class Recibo {
	private String nombre;
	private String apellido;
	private long cuil;
	private double antiguedad;
	private LocalDate fecha;
	private double montoTotal;
	
	public Recibo(String nombre, String apellido, long cuil, double antiguedad, LocalDate fecha, double monto ) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.antiguedad = antiguedad;
		this.fecha = fecha;
		this.montoTotal = monto;
	}
}
