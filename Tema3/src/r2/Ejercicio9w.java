package r2;

public class Ejercicio9w {

	public static void main(String[] args) {
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		int i=1,suma=0;

		do{
			suma=suma+b;
			i++;
		}while(i<=a);
		System.out.print(suma);
	}

}
/* Programa que multiplique dos números introducidos por el usuario
usando sumas sucesivas*/