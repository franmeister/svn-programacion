import java.util.Scanner;


public class Ejercicio15 {

	public static void main(String[] args) {
		double res;
		final double PI=3.1416;
		System.out.println("Introduce el radio de la circunferencia: ");
		Scanner s = new Scanner(System.in);
		double rad = s.nextDouble();
		s.close();
		res=2*PI*rad;
		System.out.println("La longitud de la circunferencia es: "+res);
		res=rad*rad*PI;
		System.out.println("El �rea de la circunferencia es: "+res);

	}

}
/* .Realizar un programa que hale la longitud y el �rea de una
circunferencia cuyo radio en cent�metros se introduce manualmente. Nota: definir PI como constante con valor 3.1416.
a. Long. = 2xPIxRadio
b. �rea = PI x Radio2 */