import java.util.Scanner;


public class Ejercicio17b {

	public static void main(String[] args) {
		double res;
		System.out.println("Introduce la altura del rectángulo: ");
		Scanner s = new Scanner(System.in);
		double alt = s.nextDouble();
		System.out.println("Introduce la base del rectángulo: ");
		double bas = s.nextDouble();
		s.close();
		res=bas*alt;
		System.out.println("El área del rectángulo es: "+res);
		res=2*bas+2*alt;
		System.out.println("El perímetro del rectángulo es: "+res);
	}

}

/* .Para cada uno de los puntos siguientes escribir un programa que dados
los datos necesarios, calcule el área y el perímetro de la figura indicada
a. Un cuadrado
b. Un rectángulo
c. Un triángulo
d. Un círculo
*/