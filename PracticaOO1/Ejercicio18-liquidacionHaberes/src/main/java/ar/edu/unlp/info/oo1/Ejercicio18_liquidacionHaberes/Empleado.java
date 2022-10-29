package ar.edu.unlp.info.oo1.Ejercicio18_liquidacionHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empleado {
	private String nombre;
	private String apellido;
	private long cuil;
	private LocalDate fechaNacimiento;
	private LocalDate inicioRelacion;
	private boolean poseeHijos;
	private boolean poseeConyuge;
	private List<Contrato> contratos;
	//private List<Recibo> recibos;
	
	public Empleado(String nombre, String apellido, long cuil, LocalDate fechaNacimiento, boolean poseeHijos, boolean poseeConyugue) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.fechaNacimiento = fechaNacimiento;
		this.inicioRelacion = LocalDate.now();
		this.poseeConyuge = poseeConyugue;
		this.poseeHijos = poseeHijos;
		this.contratos = new ArrayList<Contrato>();
	}
	
	public long cuil() {
		return this.cuil;
	}
	
	/*carga contato por horas*/
	public ContratoPorHoras cargarContrato(LocalDate ini, LocalDate fin, double valorHora, int horasMes) {
		ContratoPorHoras c = new ContratoPorHoras(ini,  valorHora, horasMes,fin, this);
		this.contratos.add(c);
		return c;
	}
	
	/*Carga contrato de planta*/
	public ContratoDePlanta cargarContrato(LocalDate ini,double sueldoMes, double montoHi, double montoCon) {
		ContratoDePlanta c = new ContratoDePlanta(ini, sueldoMes, montoHi, montoCon, this);
		this.contratos.add(c);
		return c;
	}
	
	
	private Contrato contratoVigente() {
		Contrato c = this.contratos.stream()
					.max((x1, x2) -> x1.getInicio().compareTo(x2.getInicio()))
					.orElse(null);
		return c;
	}
	
	public boolean tieneContratoVencido() {
		if(this.contratos.size()>0) {
			return this.contratoVigente().esVencido();
		}
		return false;
	}
	
	public boolean tieneHijos() {
		return this.poseeHijos;
	}
	public boolean tieneConyugue() {
		return this.poseeConyuge;
	}
	
	
	private long antiguedad() {
		return ChronoUnit.YEARS.between(inicioRelacion,LocalDate.now());
	}
	
	private double adicionalAntiguedad() {
		long ant = this.antiguedad();
		if(ant <=5)
			return 0.3;
		if(ant <= 10)
			return 0.5;
		if(ant <= 15)
			return 0.7;
		if(ant <= 20)
			return 1;
		return 0;
	}
	
	
	public Recibo obtenerRecibo() {
		if(this.contratoVigente().esVencido())
			return null;
		else {
			double monto = this.contratoVigente().calcularMontoBasico() * (1+this.adicionalAntiguedad());
			Recibo r = new Recibo(this.nombre, this.apellido, this.cuil,this.antiguedad(), LocalDate.now(),monto);
			return r;
		}
	}

}
