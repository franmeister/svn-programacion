package r3;

public class Ejercicio13b {

	public static void main(String[] args) {
		int n=PedirDatos.leerEntero("Introduce el número de enteros: ");
		int a=PedirDatos.leerEntero("Introduce un número: ");
		int men=a;

		for (int i=1;i<n;i++){
			if (a<men){
				men=a;
		}
			a=PedirDatos.leerEntero("Introduce un número: ");
		}
		System.out.println("El menor de los números es: "+men);
	}

}
/* Programa que pida n números enteros 
 (n dado por el usuario) y calcule el menor de ellos.*/