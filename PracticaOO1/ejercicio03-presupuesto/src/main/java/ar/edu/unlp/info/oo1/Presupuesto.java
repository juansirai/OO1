package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto(String cliente) {
		this.fecha = LocalDate.now();
		this.cliente = cliente;
		this.items = new ArrayList<Item>();
	}
	
	public Presupuesto() {
		this.items = new ArrayList<Item>();
	};
	
	public Presupuesto cliente(String c) {
		this.cliente = c;
		return this;
	}
	
	public void agregarItem(Item item) {
		this.items.add(item);
	}
	
	public int calcularTotal() {
		int result = this.items.stream()
				        .mapToInt(i -> i.costo()).sum();
		
		return result;
	}
}
