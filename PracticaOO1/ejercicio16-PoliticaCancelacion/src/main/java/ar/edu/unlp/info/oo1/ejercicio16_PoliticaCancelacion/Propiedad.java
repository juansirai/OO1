package ar.edu.unlp.info.oo1.ejercicio16_PoliticaCancelacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Propiedad {
	private String descripcion;
	private String nombre;
	private double precioNoche;
	private String direccion;
	private Usuario propietario;
	private List<Reserva> reservas;
	private PoliticaCancelacion politica;
	
	
	public Propiedad(String nombre,String descripcion,double precioNoche,
					String direccion,Usuario propietario, PoliticaCancelacion politica) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioNoche = precioNoche;
		this.direccion = direccion;
		this.propietario = propietario;
		this.politica = politica;
		this.reservas = new ArrayList<Reserva>();
	}
	
	public boolean estaDisponible(LocalDate ini, LocalDate fin) {
		return !this.reservas.stream()
				.anyMatch(reserva -> reserva.overlapea(ini, fin) == true);
	}
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public double getPrecioNoche() {
		return this.precioNoche;
	}
	
	public void eliminarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}
	
	public double calcularIngresos(LocalDate ini, LocalDate fin) {
		List<Reserva> entreFechas = this.reservas.stream()	
											.filter(reserva -> reserva.entreFechas(ini, fin))
											.collect(Collectors.toList());
		return entreFechas.stream()
				.mapToDouble(reserva -> reserva.getCosto()).sum();
	}
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	public double calcularMontoDevolucion(Reserva reserva,LocalDate fecha) {
		return this.politica.montoReembolsar(reserva, fecha);
	}
}