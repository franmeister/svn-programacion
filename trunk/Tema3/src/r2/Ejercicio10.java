package r2;

public class Ejercicio10 {

	public static void main(String[] args) {
		for (int i=1;i<=5;i++){
			System.out.println("Tabla de multiplicar del "+i);
			System.out.println("------------------------------");
			for (int j=1;j<=10;j++){
				System.out.println(i+" x "+j+" = "+(i*j));
			}
			System.out.println();
		}
	}

}
/* Programa que muestre la tabla de multiplicar de los números 1,2,3,4 y 5. */