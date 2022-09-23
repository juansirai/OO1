package ar.edu.unlp.info.oo1.ejercicio08_distribuidoraElectrica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios;
	
	public Distribuidora(double precioKWh) {
		this.precioKWh = precioKWh;
		usuarios = new ArrayList<Usuario>();
	}
	public Distribuidora() {
		usuarios = new ArrayList<Usuario>();
	}
	
	public void precioKWh(double p) {
		this.precioKWh = p;
	}
	
	public double precioKWh() {
		return this.precioKWh;
	}
	
	public void agregarUsuario(Usuario u) {
		this.usuarios.add(u);
	}
	
	public List<Factura> facturar(){
		List<Factura> facturas = usuarios.stream()
						.map(usuario -> usuario.facturarEnBaseA(precioKWh))
						.collect(Collectors.toList());

		return facturas;
	}
	
	public double consumoTotalActiva() {
		double resultado = usuarios.stream().
						   mapToDouble(usuario -> usuario.ultimoConsumoActiva()).sum();
		
		return resultado;
	}
	
	public Usuario ultimoUsuario() {
		return this.usuarios.get(this.usuarios.size()-1);
	}


}
