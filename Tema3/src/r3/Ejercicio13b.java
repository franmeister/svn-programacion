package r3;

public class Ejercicio13b {

	public static void main(String[] args) {
		int n=PedirDatos.leerEntero("Introduce el n�mero de enteros: ");
		int a=PedirDatos.leerEntero("Introduce un n�mero: ");
		int men=a;

		for (int i=1;i<n;i++){
			if (a<men){
				men=a;
		}
			a=PedirDatos.leerEntero("Introduce un n�mero: ");
		}
		System.out.println("El menor de los n�meros es: "+men);
	}

}
/* Programa que pida n n�meros enteros 
 (n dado por el usuario) y calcule el menor de ellos.*/