package ar.edu.unlp.info.oo1.Ejercicio18_liquidacionHaberes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*DUDAS:
 * 1) contratos de planta: si creo uno nuevo, y ya hay otro existente.. debo eliminar el existente asi queda uno solo activo?
 * 2) Tiene sentido guardar los recibos que genero?
 * */

public class Sistema {
	private List<Empleado> nomina;
	
	
	public Sistema() {
		this.nomina = new ArrayList<Empleado>();
	}
	
	public Empleado altaEmpleado(String nom, String ap, long cuil, LocalDate nac, boolean cony, boolean hijos) {
		Empleado e = new Empleado(nom, ap, cuil, nac, hijos, cony);
		this.nomina.add(e);
		return e;
	}
	
	public Empleado buscarEmpleado(long cuil) {
		return this.nomina.stream()
				.filter(e -> e.cuil()==cuil)
				.findFirst().orElse(null);
	}
	
	public Empleado bajaEmpleado(long cuil) {
		Empleado e = this.buscarEmpleado(cuil);
		if(e!=null)
			this.nomina.remove(e);
		return e;
	}
	
	/*carga contrato por horas*/
	public ContratoPorHoras cargarContrato(Empleado e, LocalDate ini, LocalDate fin, double valorHora, int horasMes) {
		ContratoPorHoras c = e.cargarContrato(ini, fin, valorHora, horasMes);
		return c;
	}
	
	/*carga contrato de planta*/
	public ContratoDePlanta cargarContrato(Empleado e, LocalDate ini,double sueldoMes, double montoHi, double montoCon) {
		ContratoDePlanta c = e.cargarContrato(ini, sueldoMes, montoHi, montoCon);
		return c;
	}
	
	public List<Empleado> empleadosContratosVencidos(){
		List<Empleado> e = this.nomina.stream()
						.filter(x -> x.tieneContratoVencido())
						.collect(Collectors.toList());
		
		return e;
	}
	
	public List<Recibo> generarRecibos(){
		return this.nomina.stream()
				.map(x -> x.obtenerRecibo())
				.collect(Collectors.toList());
	}
	
}
