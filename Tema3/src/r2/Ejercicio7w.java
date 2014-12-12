package r2;

public class Ejercicio7w {

	public static void main(String[] args) {
		int i=1, j=1;
		
		do{
			do{
				System.out.print("* ");
				j++;
			}while (j<=i);
			
			i++;
			System.out.println();
			j=1;

		}while (i<=5);
	}

}
/* Programa que muestre la siguiente figura por pantalla 
 
			* 
			* *
			* * *
			* * * *
			* * * * *

*/