import java.util.Scanner;


public class Ejercicio17c {

	public static void main(String[] args) {
		double res;
		System.out.println("Introduce la altura del triángulo: ");
		Scanner s = new Scanner(System.in);
		double alt = s.nextDouble();
		System.out.println("Introduce la base del triángulo: ");
		double bas = s.nextDouble();
		System.out.println("Introduce el valor del cateto a: ");
		double a = s.nextDouble();
		System.out.println("Introduce el valor del cateto b: ");
		double b = s.nextDouble();
		s.close();
		res=(bas*alt)/2;
		System.out.println("El área del triángulo es: "+res);
		res=a+b+bas;
		System.out.println("El perímetro del triángulo es: "+res);
	}

}

/* .Para cada uno de los puntos siguientes escribir un programa que dados
los datos necesarios, calcule el área y el perímetro de la figura indicada
a. Un cuadrado
b. Un rectángulo
c. Un triángulo
d. Un círculo
*/