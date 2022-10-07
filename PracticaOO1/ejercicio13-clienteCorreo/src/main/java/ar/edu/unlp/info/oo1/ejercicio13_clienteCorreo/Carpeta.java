package ar.edu.unlp.info.oo1.ejercicio13_clienteCorreo;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private double tamanio;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.tamanio = 0;
		this.emails = new ArrayList<Email>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void agregarEmail(Email email) {
		this.tamanio += email.tamanio();
		this.emails.add(email);
	}
	
	public double tamanio() {
		return this.tamanio;
	}
	
	public Email buscar(String texto) {
		Email primerMatch = emails.stream()
				.filter(email -> email.getTitulo().contains(texto) || email.getCuerpo().contains(texto)).
				findFirst().orElse(null);
		return primerMatch;
	}
	
	public boolean eliminarEmail(Email email) {
		/*se puede hacer con un stream?*/
		int pos = 0;
		boolean encontre = false;	
		
		if(!this.emails.isEmpty()) {
			while(!encontre && pos < this.emails.size()) {
				if(this.emails.get(pos).equals(email)) {
					encontre = true;
					this.emails.remove(pos);
					this.tamanio-=email.tamanio();
				}
				else
					pos++;
			}
		}
		return encontre;
		}
	
	public List<Email> getEmails() {
		return this.emails;
	}
}
	
	

