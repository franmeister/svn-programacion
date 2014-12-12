import java.util.Scanner;


public class Ejercicio14 {

	public static void main(String[] args) {
		double res;
		System.out.println("Introduce la altura del triángulo: ");
		Scanner s = new Scanner(System.in);
		double alt = s.nextDouble();
		System.out.println("Introduce la base del triángulo: ");
		double bas = s.nextDouble();
		s.close();
		res=(bas*alt)/2;
		System.out.println("El área del triángulo es: "+res);
	}

}
/* Realizar un programa que calcule el área de un triángulo conociendo su
base y la altura. La fórmula es: (base x altura) /2 */