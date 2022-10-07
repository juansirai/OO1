package ar.edu.unlp.info.oo1.ejercicio13_clienteCorreo;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private String titulo;
	private String cuerpo;
	private double tamanio;
	private List<Archivo> adjuntos;
	
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.tamanio = 5;  //peso minimo del mail sin adjuntos. Supuesto.
		this.adjuntos = new ArrayList<Archivo>(); //esta ok instanciarlo acá?
	}

	public void adjuntar(Archivo archivo) {
		this.tamanio+=archivo.tamanio();
		this.adjuntos.add(archivo);
	}
	
	public Archivo desadjuntar(Archivo archivo) {
		int pos = 0;
		Archivo resultado = null;
		
		if(!this.adjuntos.isEmpty()) {
			boolean encontre = false;
			while(!encontre && pos < this.adjuntos.size()) {
				if(this.adjuntos.get(pos).equals(archivo)) {
					resultado = this.adjuntos.get(pos);
					encontre = true;
					this.adjuntos.remove(pos);
					this.tamanio-=resultado.tamanio();
				}
				else
					pos++;
			}
		}
		return resultado;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
	
	public List<Archivo> adjuntos(){
		return this.adjuntos;
	}
	
	public double tamanio() {
		return this.tamanio;
	}
	
}
