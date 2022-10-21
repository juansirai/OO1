package ar.edu.unlp.info.oo1.ejercicio16_PoliticaCancelacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String direccion;
	private int dni;
	private List<Propiedad> propiedades;
	private List<Reserva> reservas;
	
	public Usuario(String nombre, String direccion,
					int dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.propiedades = new ArrayList<Propiedad>();
		this.reservas = new ArrayList<Reserva>();
	}
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void eliminarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	public void agregarPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	public double calcularIngresos(LocalDate ini, LocalDate fin) {
		return this.propiedades.stream()
				.mapToDouble(propiedad -> propiedad.calcularIngresos(ini, fin)).sum();
	}
}