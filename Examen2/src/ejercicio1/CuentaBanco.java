package ejercicio1;

public class CuentaBanco {
	private String numero, titular;
	private double saldo=0;
	private boolean bloqueada=false;
	
	public CuentaBanco(String numero, String titular) {
		this.numero = numero;
		this.titular = titular;
	}
	
	public CuentaBanco(String numero, String titular, double saldo, boolean bloqueada) {
		this.numero = numero;
		this.titular = titular;
		if(this.saldo<0){	// Si la cantidad es negativa se pondrá a 0
			this.saldo = saldo;
		}
		this.bloqueada = bloqueada;
	}

	private boolean estaBloqueada(){
		if(this.bloqueada){
			System.out.println("Error. La cuenta "+this.numero+" está bloqueada.");
			return true;
		}
		return false;
	}

	public double consultarSaldo() {
		return saldo;
	}
	
	public void ingresarDinero(double cantidad){
		if(!this.estaBloqueada()){
			if(cantidad<=0){
				System.out.println("Error. La cantidad introducida es negativa.");
				return;
			}
				this.saldo+=cantidad;	
		}
	}
	
	public void retirarDinero(double cantidad){
		if(!this.estaBloqueada()){
			if(this.saldo<cantidad){
				System.out.println("Error. La cuenta numero "+
						this.numero+" no tiene saldo suficiente para retirar esa cantidad.");
				return;
			}
			this.saldo-=cantidad;
		}

	}
	
	public void cambioTitular(String titular){
		if(!this.estaBloqueada()){
			if(titular.equals("")){
				System.out.println("Error. El campo nuevo titular está vacío.");
				return;
			}
			this.titular=titular;
		}
	}
	
	public void bloquear(){
		if(!this.estaBloqueada()){
			this.bloqueada=true;
		}
	}
	
	public void desbloquear(){
		this.bloqueada=false;
	}

	@Override
	public String toString() {
		return "Número:" + numero + "\nTitular:" + titular + "\nSaldo:"
				+ saldo + "\nBloqueada:" + bloqueada;
	}
}
