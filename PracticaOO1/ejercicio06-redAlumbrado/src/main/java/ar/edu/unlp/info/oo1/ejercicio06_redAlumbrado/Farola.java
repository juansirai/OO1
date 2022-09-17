package ar.edu.unlp.info.oo1.ejercicio06_redAlumbrado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Farola {
	private boolean estaEncendida;
	private List<Farola> neighbors;
	
	/*
	* Crear una farola. Debe inicializarla como apagada
	*/
	public Farola () {
		this.estaEncendida = false;
		this.neighbors = new ArrayList<Farola>();
	}
	
	/*
	* Crea la relación de vecinos entre las farolas. 
	* La relación de vecinos entre las farolas es recíproca, es decir el receptor del mensaje será vecino de otraFarola, 
	* al igual que otraFarola también se convertirá en vecina del receptor del mensaje
	*/
	public void pairWithNeighbor( Farola otraFarola ) {
		if(! this.neighbors.contains(otraFarola)) {
			this.neighbors.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}
	
	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors (){
		return this.neighbors;
	}
	
	/*
	* Retorna true si la farola está encendida.
	*/
	public boolean isOn() {
		return this.estaEncendida;
	}

	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		boolean estado = true;
		propagar(estado);
	}
	
	public void turnOff() {
		boolean estado = false;
		propagar(estado);
	}
	
	private void propagar(boolean estado) {
		if(!this.estaEncendida == estado) {
			this.estaEncendida = estado;
			neighbors.stream().forEach(farola -> farola.propagar(estado));
		}
	}
	
	/*
	private void propagar(boolean estado) {
		if(!this.estaEncendida == estado) {
			this.estaEncendida = estado;
			for(Farola farola: neighbors) {
				farola.propagar(estado);
			}
		}
	}
	*/
}
