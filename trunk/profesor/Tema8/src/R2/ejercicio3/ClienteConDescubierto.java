package R2.ejercicio3;

public class ClienteConDescubierto extends Cliente {

	@Override
	protected void devuelvePagos() {
		System.out.println("Importe del credito:"+this.saldo);
		System.out.println("Los tres pagos son:");
		System.out.println("1º Pago: "+(this.saldo*0.5));
		System.out.println("2º Pago: "+(this.saldo*0.25));
		System.out.println("3º Pago: "+(this.saldo*0.25));
	}
}
