package r3;

public class Ejercicio13a {

	public static void main(String[] args) {
		int suma=0;
		int n=PedirDatos.leerEntero("Introduce el n�mero de enteros: ");

		for (int i=1;i<=n;i++){
			int a=PedirDatos.leerEntero("Introduce un n�mero: ");
			suma=suma+a;
		}
		System.out.println("La suma de los n�meros es: "+suma+" y la media es: "+suma/n);
	}

}
/* Programa que pida n n�meros enteros (n dado por el usuario)
 y calcule su suma y su media. */