import java.util.Scanner;


public class Ejercicio9 {

	public static void main(String[] args) {
		int res;
		System.out.println("Introduce tu fecha de nacimiento, primero el a�o: ");
		Scanner s = new Scanner(System.in);
		int ano = s.nextInt();
		System.out.println("Ahora el mes: ");
		int mes = s.nextInt();
		System.out.println("Ahora el d�a: ");
		int dia = s.nextInt();
		System.out.println("Introduce la fecha de hoy, primero el a�o: ");
		int hano = s.nextInt();
		System.out.println("Ahora el mes: ");
		int hmes = s.nextInt();
		System.out.println("Ahora el d�a: ");
		int hdia = s.nextInt();
		s.close();
		res=(hano*365+hmes*30+hdia)-(ano*365+mes*30+dia);
		//res=(hano-ano)*365+(hmes-mes)*30+(hdia-dia);
		System.out.println("Tu edad en d�as es: "+res);
	}

}
/*Realizar un programa que calcule la edad en d�as de una persona que
proporciona su fecha
de nacimiento en a�os, meses y d�as. Nota: se
tomar� el n�mero de d�as de un a�o como 365 y el de un mes como 30*/