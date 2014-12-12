import java.util.Scanner;


public class Ejercicio7 {

	public static void main(String[] args) {
		int coc,res;
		System.out.println("Introduce divisor: ");
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		System.out.println("Introduce dividendo: ");
		int b = s.nextInt();
		s.close();
		coc=a/b;
		res=a%b;
		System.out.println("El cociente de la división entera es: "+coc+" y el resto es :"+res);
	}

}

/*Escribir un programa que reciba dos
números enteros y saque por
pantalla el cociente y el resto de la
división entera entre ambos*/