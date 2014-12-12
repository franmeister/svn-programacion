package r2;

public class Ejercicio13w {

	public static void main(String[] args) {
		int i=0, suma=0;
		
		while (i<args.length){
			suma=suma+Integer.parseInt(args[i]);
			i++;
		}
		System.out.print(suma);
	}

}
/* Realizar un programa en JAVA que realice la suma de varios números
que se le pasan como argumentos.*/