import java.util.Scanner;


public class Ejercicio17c {

	public static void main(String[] args) {
		double res;
		System.out.println("Introduce la altura del tri�ngulo: ");
		Scanner s = new Scanner(System.in);
		double alt = s.nextDouble();
		System.out.println("Introduce la base del tri�ngulo: ");
		double bas = s.nextDouble();
		System.out.println("Introduce el valor del cateto a: ");
		double a = s.nextDouble();
		System.out.println("Introduce el valor del cateto b: ");
		double b = s.nextDouble();
		s.close();
		res=(bas*alt)/2;
		System.out.println("El �rea del tri�ngulo es: "+res);
		res=a+b+bas;
		System.out.println("El per�metro del tri�ngulo es: "+res);
	}

}

/* .Para cada uno de los puntos siguientes escribir un programa que dados
los datos necesarios, calcule el �rea y el per�metro de la figura indicada
a. Un cuadrado
b. Un rect�ngulo
c. Un tri�ngulo
d. Un c�rculo
*/