package ar.edu.unlp.info.oo1.ejercicio09_cuentaConGanchos;

public class CajaDeAhorro extends Cuenta{
	private double comision;
	
	public CajaDeAhorro() {
		super();
		this.comision = 0.02;
	}
	
	protected boolean puedeExtraer(double monto) {
		return super.getSaldo()>= monto * (1+comision);
	}
	
	protected void extraerSinControlar(double monto) {
		super.extraerSinControlar( monto * (1+comision));
	}
	
	public void depositar(double monto) {
		super.depositar(monto - monto * this.comision);
	}
	
}
