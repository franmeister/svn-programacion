import java.util.Scanner;


public class Ejercicio17b {

	public static void main(String[] args) {
		double res;
		System.out.println("Introduce la altura del rect�ngulo: ");
		Scanner s = new Scanner(System.in);
		double alt = s.nextDouble();
		System.out.println("Introduce la base del rect�ngulo: ");
		double bas = s.nextDouble();
		s.close();
		res=bas*alt;
		System.out.println("El �rea del rect�ngulo es: "+res);
		res=2*bas+2*alt;
		System.out.println("El per�metro del rect�ngulo es: "+res);
	}

}

/* .Para cada uno de los puntos siguientes escribir un programa que dados
los datos necesarios, calcule el �rea y el per�metro de la figura indicada
a. Un cuadrado
b. Un rect�ngulo
c. Un tri�ngulo
d. Un c�rculo
*/