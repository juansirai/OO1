package ar.edu.unlp.info.oo1.ejercicio07_empleados;

public class Gerente extends EmpleadoJerarquico{
	
	public Gerente(String nombre) {
		super(nombre);
	}
	
	public double montoBasico() {
		return 57000;
	}
	public double aportes() {
		return this.montoBasico() * 0.05;
	}
}
