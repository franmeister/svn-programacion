package R2.ejercicio3;

public class Cliente{
	
	protected Persona cliente;
	protected double saldo=0;
	
	protected boolean autorizado(double importe){
		if(importe<3000){
			return true;
		}
		return false;
	}
	protected void cargar(double importe){
		saldo=saldo+importe;
	}
	
	protected void devuelvePagos(){
	}
	
	protected double descuentoMagico(){
		double descuento=0.10;
		
		return descuento;
	}
}
