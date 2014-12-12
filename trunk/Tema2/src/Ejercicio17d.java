import java.util.Scanner;


public class Ejercicio17d {

	public static void main(String[] args) {
		double res;
		final double PI=3.1416;
		System.out.println("Introduce el radio del círculo: ");
		Scanner s = new Scanner(System.in);
		double rad = s.nextDouble();
		s.close();
		res=2*PI*rad;
		System.out.println("El perímetro del círculo es: "+res);
		res=rad*rad*PI;
		System.out.println("El área del círculo es: "+res);
	}

}
/* .Para cada uno de los puntos siguientes escribir un programa que dados
los datos necesarios, calcule el área y el perímetro de la figura indicada
a. Un cuadrado
b. Un rectángulo
c. Un triángulo
d. Un círculo
*/