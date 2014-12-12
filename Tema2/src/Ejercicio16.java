import java.util.Scanner;


public class Ejercicio16 {

	public static void main(String[] args) {
		double h;
		System.out.println("Introduce el valor del cateto a: ");
		Scanner s = new Scanner(System.in);
		double a = s.nextDouble();
		System.out.println("Introduce el valor del cateto b: ");
		double b = s.nextDouble();
		s.close();
		h=Math.sqrt(a*a+b*b);
	    int cifras=(int) Math.pow(10,2);
	    h=Math.rint(h*cifras)/cifras;
		System.out.println("El valor de la hipotenusa es: "+h);
	}

}
/* Programa que reciba dos n�meros reales a y b y calcule la hipotenusa
del tri�ngulo rect�ngulo de catetos a y b, h=sqrt(a*a+b*b), es decir, ra�z
cuadrada de la suma de los cuadrados de los catetos. (Teorema de
Pit�goras).*/