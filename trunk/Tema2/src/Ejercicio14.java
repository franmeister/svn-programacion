import java.util.Scanner;


public class Ejercicio14 {

	public static void main(String[] args) {
		double res;
		System.out.println("Introduce la altura del tri�ngulo: ");
		Scanner s = new Scanner(System.in);
		double alt = s.nextDouble();
		System.out.println("Introduce la base del tri�ngulo: ");
		double bas = s.nextDouble();
		s.close();
		res=(bas*alt)/2;
		System.out.println("El �rea del tri�ngulo es: "+res);
	}

}
/* Realizar un programa que calcule el �rea de un tri�ngulo conociendo su
base y la altura. La f�rmula es: (base x altura) /2 */