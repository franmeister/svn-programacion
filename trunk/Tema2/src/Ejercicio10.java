import java.util.Scanner;


public class Ejercicio10 {

	public static void main(String[] args) {
		int res;
		System.out.println("Introduce velocidad en km/h: ");
		Scanner s = new Scanner(System.in);
		int vel = s.nextInt();
		s.close();
		res=vel*1000/3600;
		System.out.println("Son "+res+" m/s");
	}

}
/*Realizar un programa que pase la velocidad de km/h a m/s  */