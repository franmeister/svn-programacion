import java.util.Scanner;


public class Ejercicio13 {

	public static void main(String[] args) {
		int res;
		System.out.println("Introduce un n�mero: ");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		s.close();
		res=num*2;
		System.out.println("El doble de "+num+"es: "+res);
		res=num*3;
		System.out.println("El triple de "+num+"es: "+res);
	}

}

/*Realizar un programa que reciba un n�mero y escriba su doble y su
triple.*/