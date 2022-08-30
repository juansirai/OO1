package ar.edu.unlp.info.oo1.balanzaElectronica;

public class Balanza {
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public Balanza() {
		this.cantidadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0;
	}
	
	public Balanza(int cantidadDeProductos, double precioTotal, double pesoTotal) {
		this.cantidadDeProductos = cantidadDeProductos;
		this.precioTotal = precioTotal;
		this.pesoTotal = pesoTotal;
	}
	
	
	//Comportamientos
	
	public int getCantidadDeProductos() {
		return this.cantidadDeProductos;
	}
	public double getPrecioTotal() {
		return this.precioTotal;
	}
	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	/*Pone en cero todos los valores de la balanza*/
	public void ponerEnCero() {
		this.cantidadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0;
	}
	
	/*Agrega un producto a la balanza, 
	 * actualizando los valores correspondientes
	 * en peso, cantidad y peso*/
	
	public void agregarProducto(Producto producto) {
		this.cantidadDeProductos++;
		this.precioTotal += producto.getPrecio();
		this.pesoTotal += producto.getPeso();
	}
	
	
	/*Retorna el ticket con los atributos*/
	public Ticket emitirTicket() {
		Ticket T = new Ticket(this);
		T.impuesto();
		return T;
	}
}
