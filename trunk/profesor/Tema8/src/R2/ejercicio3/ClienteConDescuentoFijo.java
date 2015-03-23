package R2.ejercicio3;

public class ClienteConDescuentoFijo extends Cliente {
	@Override
	protected void cargar(double importe) {
		importe=(0.97)*importe;
		
		if(this.autorizado(importe)){
			super.cargar(importe);
		}
	}

	protected void devuelvePagos(){
		System.out.println("Importe del credito:"+this.saldo);
		System.out.println("Los tres pagos son:");
		System.out.println("1º Pago: "+(this.saldo*0.33));
		System.out.println("2º Pago: "+(this.saldo*0.33));
		System.out.println("3º Pago: "+(this.saldo*0.33));
	}
	

}
