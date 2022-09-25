package ar.edu.unlp.info.oo1.ejercicio09_cuentaConGanchos;

public class CuentaCorriente extends Cuenta {
	private double limiteDescubierto;
	
	public CuentaCorriente() {
		super();
		this.limiteDescubierto = 0;
	}
	
	public void setLimiteDescubierto(double limite) {
		this.limiteDescubierto = limite;
	}
	public double getLimiteDescubierto() {
		return this.limiteDescubierto;
	}
	
	protected boolean puedeExtraer(double monto) {
		return super.getSaldo() + this.getLimiteDescubierto() >= monto;
	}
	
	
}
