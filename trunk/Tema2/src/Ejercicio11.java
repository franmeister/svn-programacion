import java.util.Scanner;


public class Ejercicio11 {

	public static void main(String[] args) {
		double res;
		System.out.println("Introduce tres numeros: ");
		Scanner s = new Scanner(System.in);
		double num1 = s.nextInt();
		double num2 = s.nextInt();
		double num3 = s.nextInt();
		s.close();
		res=(num1+num2+num3)/3;
		System.out.println("La media es: "+res);
	}
}
/*Programa que calcule la media de tres números */