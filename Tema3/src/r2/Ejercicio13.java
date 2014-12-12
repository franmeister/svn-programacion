package r2;

public class Ejercicio13 {

	public static void main(String[] args) {
		int suma=0;
		
		for (int i=0;i<args.length;i++){
			suma=suma+Integer.parseInt(args[i]);
		}
		System.out.print(suma);
	}

}
/* Realizar un programa en JAVA que realice la suma de varios números
que se le pasan como argumentos.*/