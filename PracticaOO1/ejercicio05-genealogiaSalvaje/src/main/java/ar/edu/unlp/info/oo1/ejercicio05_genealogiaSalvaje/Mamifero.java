package ar.edu.unlp.info.oo1.ejercicio05_genealogiaSalvaje;

import java.time.LocalDate;

public class Mamifero {
	private String identificador;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;

	
	public Mamifero(String identificador) {
		this.identificador = identificador;
	}
	
	public Mamifero() {};
	
	public void setIdentificador(String i) {
		this.identificador = i;
	}
	public String getIdentificador() {
		return this.identificador;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getEspecie() {
		return this.especie;
	}
	
	public void setFechaNacimiento(LocalDate f) {
		this.fechaNacimiento = f;
	}
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public void setMadre(Mamifero m) {
		this.madre = m;
	}
	
	public Mamifero getMadre() {
		return this.madre;
	}
	
	public void setPadre(Mamifero p) {
		this.padre = p;
	}
	public Mamifero getPadre() {
		return this.padre;
	}
	
	
	private boolean tienePadre() {
		return this.padre != null;
	}
	
	private boolean tieneMadre() {
		return this.madre != null;
	}

	public Mamifero getAbueloPaterno() {
		Mamifero resultado = null;
		if (this.tienePadre()){
			resultado = this.padre.getPadre();
		};
		return resultado;
	}

	
	public Mamifero getAbueloMaterno() {
		Mamifero resultado = null;
		if(this.tieneMadre()) {
			resultado =  this.madre.getPadre();
		};
		return resultado;
	}
	
	public Mamifero getAbuelaMaterna() {
		Mamifero resultado = null;
		if(this.tieneMadre()) {
			resultado = this.madre.getMadre();
		}
		return resultado;
	}

	
	public Mamifero getAbuelaPaterna() {
		Mamifero resultado = null;
		if(this.tienePadre()) {
			resultado = this.padre.getMadre();
		}
		return resultado;
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return tieneComoAncestroMadreA(this, unMamifero)||
				tieneComoAncestroPadreA(this, unMamifero);
	}
	
	private boolean tieneComoAncestroMadreA(Mamifero uno, Mamifero dos) {
		boolean result = false;
		if(uno.tieneMadre()) {
			if(uno.getMadre().equals(dos))
				result = true;
			else {
				result = tieneComoAncestroMadreA(uno.getMadre(), dos)
						|| tieneComoAncestroPadreA(uno.getMadre(),dos);
			}
		}
		return result;
	}
	
	private boolean tieneComoAncestroPadreA(Mamifero uno, Mamifero dos) {
		boolean result = false;
		if(uno.tienePadre()) {
			if(uno.getPadre().equals(dos))
				result = true;
			else {
				result = tieneComoAncestroMadreA(uno.getPadre(), dos)
						|| tieneComoAncestroPadreA(uno.getPadre(),dos);
			}
		}
		return result;
	}

}
