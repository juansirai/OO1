package ar.edu.unlp.info.oo1.Ejercicio15_AlquilerDePropiedades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	private List<Usuario> usuarios;
	private List<Propiedad> propiedades;
	
	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
		this.propiedades = new ArrayList<Propiedad>();
	}
	

	public Usuario registrarUsuario(String nombre, String direccion,int dni) {
		Usuario user = new Usuario(nombre, direccion, dni);
		this.usuarios.add(user);
		return user;
	}
	

	public Propiedad registrarPropiedad(String nombre, String descripcion,
										double precioNoche, String direccion,
										Usuario propietario) {		
		Propiedad propiedad = new Propiedad(nombre, descripcion, precioNoche,
											direccion, propietario);
		this.propiedades.add(propiedad);
		return propiedad;
	}
	
	public List<Propiedad> buscarPropiedadesDisponibles(LocalDate ini, LocalDate fin){
		return this.propiedades.stream()
				.filter(propiedad-> propiedad.estaDisponible(ini, fin))
				.collect(Collectors.toList());
	}
	
	public Reserva efectuarReserva(LocalDate ini, LocalDate fin, Propiedad propiedad, Usuario inquilino) {
		Reserva reserva = null;
		if(propiedad.estaDisponible(ini, fin)) {
			/*es necesario buscar antes la propiedad en el vector? o se supone que la que llega por parametro es la que tengo?*/
			reserva = new Reserva(ini, fin, propiedad);
			propiedad.agregarReserva(reserva);
			inquilino.agregarReserva(reserva);
		}
		return reserva;
	}
	
	public void eliminarReserva(Reserva reserva) {
		if(reserva.mayorFechaActual()) {
			this.propiedades.forEach(propiedad -> propiedad.eliminarReserva(reserva));
			this.usuarios.forEach(usuario -> usuario.eliminarReserva(reserva));
		}
	}
	
	public List<Reserva> obtenerReservasUsuario(Usuario usuario){
		return usuario.getReservas();
	}
	
	public double calcularIngresosPropietario(Usuario propietario,LocalDate ini, LocalDate fin) {
		return propietario.calcularIngresos(ini, fin);
	}
	
	public void asignarPropiedadAUsuario(Usuario propietario, Propiedad propiedad) {
		propietario.agregarPropiedad(propiedad);
	}
}
