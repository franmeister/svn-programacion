package r2;

public class Ejercicio9 {

	public static void main(String[] args) {
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		int suma=0;

		for (int i=1;i<=a;i++){
			suma=suma+b;
		}
		System.out.print(suma);
	}

}
/* Programa que multiplique dos números introducidos por el usuario
usando sumas sucesivas*/