package ejercicio1;

public class PruebaCuentaBanco {

	public static void main(String[] args) {
		CuentaBanco c1= new CuentaBanco("10000","Pepe");
		CuentaBanco c2= new CuentaBanco("20000","Antonio",0,true);
		CuentaBanco c3= new CuentaBanco("30000","María",-100,false);

		c1.ingresarDinero(1000);
		c2.ingresarDinero(1000);
		c3.ingresarDinero(1000);
		
		System.out.println("\nLa cuenta de Pepe tiene: "+c1.consultarSaldo());
		System.out.println("La cuenta de Antonio tiene: "+c2.consultarSaldo());
		System.out.println("La cuenta de María tiene: "+c3.consultarSaldo()+"\n");

		c1.retirarDinero(100);
		c2.retirarDinero(100);
		c3.retirarDinero(100);
		
		System.out.println("\nLa cuenta de Pepe tiene: "+c1.consultarSaldo());
		System.out.println("La cuenta de Antonio tiene: "+c2.consultarSaldo());
		System.out.println("La cuenta de María tiene: "+c3.consultarSaldo()+"\n");

	}

}
