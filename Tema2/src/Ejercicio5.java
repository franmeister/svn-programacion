import java.util.Scanner;


public class Ejercicio5 {

	public static void main(String[] args) {
		int c;
		System.out.println("Introduce un valor para \"a\": ");
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		System.out.println("Introduce un valor para \"b\": ");
		int b = s.nextInt();
		s.close();
		System.out.println("La variable \"a\" es :"+a);
		System.out.println("La variable \"b\" es :"+b);
		c=a;
		a=b;
		b=c;
		System.out.println("\nLa variable \"a\" es :"+a);
		System.out.println("La variable \"b\" es :"+b);

	}

}
/*Realizar un programa
en java que dada dos variables a y b, intercambie
los valores de a y b.*/
