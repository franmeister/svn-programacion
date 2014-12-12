import java.util.Scanner;


public class Ejercicio6 {

	public static void main(String[] args) {
		System.out.println("Introduce una cantidad de pesetas: ");
		Scanner s = new Scanner(System.in);
		int pes = s.nextInt();
		s.close();
		double eur=pes/1.66/100;
	    int cifras=(int) Math.pow(10,2);
	    eur=Math.rint(eur*cifras)/cifras;
		System.out.println("Son "+eur+" euros.");
	}

}
/*Escribir un programa que reciba
una cantidad en pesetas y la convierta
en euros*/