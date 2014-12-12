package r3;

public class Ejercicio16 {

	public static void main(String[] args) {
		int suma=0;
		int n=PedirDatos.leerEntero("Introduce el número de alumnos: ");

		for (int i=1;i<=n;i++){
			int edad=PedirDatos.leerEntero("Introduce edad: ");
			suma=suma+edad;
		}
		System.out.println("La suma de las edades es: "+suma);
	}

}
/* Realizar un programa que pida el número de alumnos que hay en una
clase. A continuación se piden por teclado cada una de las edades de
los alumnos y se imprime la suma de todas sus edades. */