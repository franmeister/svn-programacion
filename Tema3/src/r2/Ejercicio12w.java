package r2;

public class Ejercicio12w {

	public static void main(String[] args) {
		int n=Integer.parseInt(args[0]);
		int i=2, tot=1;
		
		do{
			tot=tot*i;
			i++;
		}
		while (i<=n);
		System.out.print(n+"! = "+tot);
	}

}

/* Realizar una aplicación Factorial que calcule el factorial de un número
introducido por teclado */