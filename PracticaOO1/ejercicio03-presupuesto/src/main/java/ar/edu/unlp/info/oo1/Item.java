package ar.edu.unlp.info.oo1;

public class Item {
	private String detalle;
	private int cantidad;
	private int costoUnitario;
	
	public Item() {};
	public Item(String d, int c, int  cu) {
		this.detalle = d;
		this.cantidad = c;
		this.costoUnitario = cu;
	}
	
	public int costo() {
		return this.costoUnitario * this.cantidad;
		
	}
	
	public Item detalle(String d) {
		this.detalle = d;
		return this;
	}
	public Item costoUnitario(int cu) {
		this.costoUnitario = cu;
		return this;
	}
	
	public Item cantidad(int cantidad) {
		this.cantidad = cantidad;
		return this;
	}
	
	public int getCostoUnitario() {
		return this.costoUnitario;
	}
}
