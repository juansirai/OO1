package ar.edu.unlp.info.oo1.ejercicio03_balanzaMejorada;

import java.util.ArrayList;
import java.util.List;

public class Balanza {
	private List<Producto> productos;
	
	public Balanza() {
		this.productos = new ArrayList<Producto>();
	}
	
	
	//Comportamientos
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}
	
	public double getPrecioTotal() {
		double result = this.productos.stream()
				     .mapToDouble(p -> p.getPrecio()).sum();
		return result;
	}
	
	public double getPesoTotal() {
		double result = this.productos.stream()
				        .mapToDouble(p -> p.getPeso()).sum();
		return result;
	}
	
	/*Pone en cero todos los valores de la balanza*/
	public void ponerEnCero() {
		this.productos.clear();
	}
	
	/*Agrega un producto a la balanza, 
	 * actualizando los valores correspondientes
	 * en peso, cantidad y peso*/
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	
	/*Retorna el ticket con los atributos*/
	public Ticket emitirTicket() {
		Ticket T = new Ticket(this.productos);
		return T;
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
}