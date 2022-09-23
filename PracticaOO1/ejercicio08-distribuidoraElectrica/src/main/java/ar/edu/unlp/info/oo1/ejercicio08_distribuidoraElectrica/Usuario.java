package ar.edu.unlp.info.oo1.ejercicio08_distribuidoraElectrica;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Consumo> consumos;
	private List<Factura> facturas;
	
	public Usuario() {};
	public Usuario(String domicilio, String nombre) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.consumos = new ArrayList<Consumo>();
		this.facturas = new ArrayList<Factura>();
	}
	
	public void agregarMedicion(Consumo consumo) {
		this.consumos.add(consumo);
	}
	
	public double ultimoConsumoActiva() {
		return this.consumos.get(this.consumos.size()-1).consumoEnergiaActiva();
	}
	
	private double ultimoFactorPotencia() {
		return this.consumos.get(this.consumos.size()-1).factorDePotencia();
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		double desc = 0;
		if(this.ultimoFactorPotencia()>0.8)
			desc = 0.1;
		
		Factura factura = new Factura(this.ultimoConsumoActiva() * precioKWh,desc, this);
		this.facturas.add(factura);
		return factura;
	}
	
	public List<Factura> facturas(){
		return this.facturas();
	}
	
	
}
