package ar.edu.unlp.info.oo1.ejercicio13_clienteCorreo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo() {
		this.inbox = new Carpeta("inbox");
		this.carpetas = new ArrayList<Carpeta>();
	}
	
	public void recibir(Email email) {
		/*por defecto recibe en inbox*/
		this.inbox.agregarEmail(email);
	}
	
	private List<Carpeta> getCarpetas(){
		List<Carpeta> todas = new ArrayList<Carpeta>(this.carpetas);
		todas.add(inbox);
		return todas;
	}
	
	public Email buscar(String texto) {
		/* se podría simplificar? */
		
		List<Carpeta>todas = this.getCarpetas();
		Email primerMatch = todas.stream()
				.map(carpeta -> carpeta.buscar(texto))
				.filter(carpeta -> carpeta != null)
				.findFirst().orElse(null);
		return primerMatch;
	}
	
	public double espacioOcupado() {
		List<Carpeta> todas = this.getCarpetas();
		double espacio = todas.stream()
				.mapToDouble(carpeta -> carpeta.tamanio())
				.sum();
		return espacio;
	}
	
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		origen.eliminarEmail(email);
		destino.agregarEmail(email);
	}
	
	public void nuevaCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}
	
	public Carpeta getInbox() {
		return this.inbox;
	}
}	
