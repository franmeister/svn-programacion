import java.util.Scanner;


public class Ejercicio17a {

	public static void main(String[] args) {
		double res;
		System.out.println("Introduce la longitud de la arista del cuadrado: ");
		Scanner s = new Scanner(System.in);
		double ari = s.nextDouble();
		s.close();
		res=ari*ari;
		System.out.println("El �rea del cuadrado es: "+res);
		res=4*ari;
		System.out.println("El per�metro del cuadrado es: "+res);
	}

}

/* .Para cada uno de los puntos siguientes escribir un programa que dados
los datos necesarios, calcule el �rea y el per�metro de la figura indicada
a. Un cuadrado
b. Un rect�ngulo
c. Un tri�ngulo
d. Un c�rculo
*/