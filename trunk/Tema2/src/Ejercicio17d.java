import java.util.Scanner;


public class Ejercicio17d {

	public static void main(String[] args) {
		double res;
		final double PI=3.1416;
		System.out.println("Introduce el radio del c�rculo: ");
		Scanner s = new Scanner(System.in);
		double rad = s.nextDouble();
		s.close();
		res=2*PI*rad;
		System.out.println("El per�metro del c�rculo es: "+res);
		res=rad*rad*PI;
		System.out.println("El �rea del c�rculo es: "+res);
	}

}
/* .Para cada uno de los puntos siguientes escribir un programa que dados
los datos necesarios, calcule el �rea y el per�metro de la figura indicada
a. Un cuadrado
b. Un rect�ngulo
c. Un tri�ngulo
d. Un c�rculo
*/