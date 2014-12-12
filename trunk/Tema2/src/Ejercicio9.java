import java.util.Scanner;


public class Ejercicio9 {

	public static void main(String[] args) {
		int res;
		System.out.println("Introduce tu fecha de nacimiento, primero el año: ");
		Scanner s = new Scanner(System.in);
		int ano = s.nextInt();
		System.out.println("Ahora el mes: ");
		int mes = s.nextInt();
		System.out.println("Ahora el día: ");
		int dia = s.nextInt();
		System.out.println("Introduce la fecha de hoy, primero el año: ");
		int hano = s.nextInt();
		System.out.println("Ahora el mes: ");
		int hmes = s.nextInt();
		System.out.println("Ahora el día: ");
		int hdia = s.nextInt();
		s.close();
		res=(hano*365+hmes*30+hdia)-(ano*365+mes*30+dia);
		//res=(hano-ano)*365+(hmes-mes)*30+(hdia-dia);
		System.out.println("Tu edad en días es: "+res);
	}

}
/*Realizar un programa que calcule la edad en días de una persona que
proporciona su fecha
de nacimiento en años, meses y días. Nota: se
tomará el número de días de un año como 365 y el de un mes como 30*/