package r2;

public class Ejercicio12 {

	public static void main(String[] args) {
		int n=Integer.parseInt(args[0]);
		int tot=1;
		
		for (int i=2;i<=n;i++){
			tot=tot*i;
		}
		System.out.print(n+"! = "+tot);
	}

}

/* Realizar una aplicaci�n Factorial que calcule el factorial de un n�mero
introducido por teclado */