package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/* DUDAS:
 * 1) Esta OK crear tantos metodos como tipos de personas y/o llamadas?
 * 2) La factura que se instancia, está OK que reciba al cliente como parametro? O deberia recibir valores, por si luego la ref al objeto desaparece?
 * 3) hasta donde polimorfismo? Ejemplo, en llamadas podría crear tambien subclases de "Larga, Media, Corta distancia" o "Diurna/Nocturna"
 * 4) uso del Super... está ok invocarlo en el metodo getCosto de las llamadas? O conviene que la clase madre resuelva mas?
 * */
public class Sistema {
	List<Cliente> clientes;
	List<String> numerosDisponibles;
	
	public Sistema() {
		this.clientes = new ArrayList<Cliente>();
		this.numerosDisponibles = new ArrayList<String>();
	}
	
	public void agregarNumeroDisponible(String numero) {
		this.numerosDisponibles.add(numero);
	}
	
	
	public PersonaFisica altaPersonaFisica(String nombre, String direccion, int dni) {
		PersonaFisica cliente = new PersonaFisica(nombre, direccion, dni);
		if(this.numerosDisponibles.size()>0)
			cliente.asignarNumero(numerosDisponibles.remove(0)); //deberia verificar que haya numeros disponibles?
		return cliente;
	}
	
	
	public PersonaJuridica altaPersonaJuridica(String nombre, String direccion, int cuit, String tipo) {
		PersonaJuridica cliente = new PersonaJuridica(nombre, direccion, cuit, tipo);
		if(this.numerosDisponibles.size()>0)
			cliente.asignarNumero(numerosDisponibles.remove(0));
		return cliente;
	}
	
	private Cliente buscarClientePorNumero(String numero) {
		return this.clientes.stream()
				.filter(c -> c.getNumeroAsignado().equals(numero))
				.findFirst().orElse(null);
	}
	
	private void agregarLlamadaCliente(Llamada llamada, String llamador) {
		Cliente c = buscarClientePorNumero(llamador);
		if(c!=null)
			c.agregarLlamada(llamada);
	}
	
	public LlamadaLocal registrarLlamadaLocal(LocalDateTime comienzo, int duracion, String llamador, String receptor) {
		LlamadaLocal llamada = new LlamadaLocal(comienzo, duracion, llamador, receptor);
		agregarLlamadaCliente(llamada, llamador);
		return llamada;
	}
	
	
	
	public LlamadaInterurbana registrarLlamadaIU(LocalDateTime comienzo, int duracion, String llamador, String receptor, 
												 double distancia) {	
		
		LlamadaInterurbana llamada= new LlamadaInterurbana(comienzo, duracion, llamador, receptor, distancia);
		agregarLlamadaCliente(llamada, llamador);
		return llamada;
	}
	
	
	public LlamadaInternacional registrarLlamadaIN(LocalDateTime comienzo, int duracion, String llamador, 
												   String receptor,String paisOrigen, String paisDestino) {
		
		LlamadaInternacional llamada = new LlamadaInternacional(comienzo, duracion, llamador, receptor, paisOrigen, paisDestino);
		agregarLlamadaCliente(llamada, llamador);
		return llamada;
	}
	
	
	private Cliente encontrarCliente(Cliente cliente) {
		return this.clientes.stream()
				.filter(c-> c.equals(cliente))
				.findFirst().orElse(null);
	}
	
	public Factura facturarLlamadasCliente(Cliente cliente, LocalDateTime comienzo, LocalDateTime fin) {
		Factura factura = null;
		Cliente cli = encontrarCliente(cliente);
		double monto = cli.calcularMontoAdeudado(comienzo, fin);
		if(cli != null) {
			factura = new Factura(cli, comienzo, fin, monto);
		}
		return factura;
	}
}
