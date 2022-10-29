package ar.edu.unlp.info.oo1.Ejercicio18_liquidacionHaberes;

import java.time.LocalDate;

public class ContratoDePlanta extends Contrato{
	double sueldoMes;
	double montoHijos;
	double montoConyugue;
	
	public ContratoDePlanta(LocalDate ini,double sueldoMes, double montoHi, double montoCon, Empleado e) {
		super(ini, e);
		this.sueldoMes = sueldoMes;
		this.montoHijos = montoHi;
		this.montoConyugue = montoCon;
	}

	@Override
	double calcularMontoBasico() {
		double monto = this.sueldoMes;
		if(super.empleado().tieneHijos())
			monto+=this.montoHijos;
		if(super.empleado().tieneConyugue())
			monto+=this.montoConyugue;
		return monto;
	}

	@Override
	boolean esVencido() {
		// Debería chequear algo??
		return true;
	}

}
