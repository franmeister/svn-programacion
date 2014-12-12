package r3;

public class Ejercicio17 {

	public static void main(String[] args) {
		double suma=0,a;
		int i=-1;

		do{
			a=PedirDatos.leerDecimal("Introduce precio de producto: ");
			suma=suma+a;
			i++;
		}while(a!=0);
		System.out.println("El precio medio es: "+suma/i);
	}

}
/* Realizar un programa que pida el precio de varios productos de un
supermercado y calcule el precio medio 
(media aritmética). Se terminará de introducir 
productos cuando el precio de un producto sea cero.*/