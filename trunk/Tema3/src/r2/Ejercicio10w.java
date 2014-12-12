package r2;

public class Ejercicio10w {

	public static void main(String[] args) {
		int i=1,j=1;
		while (i<=5){
			System.out.println("Tabla de multiplicar del "+i);
			System.out.println("------------------------------");
			while (j<=10){
				System.out.println(i+" x "+j+" = "+(i*j));
				j++;
			}
			System.out.println();
			i++;
			j=1;
		}
	}

}
/* Programa que muestre la tabla de multiplicar de los números 1,2,3,4 y 5. */