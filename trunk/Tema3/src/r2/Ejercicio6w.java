package r2;

public class Ejercicio6w {

	public static void main(String[] args) {
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		
		if (a>b){
			System.out.print("Error, \"a\" es mayor que \"b\".");
		}else{
			do{
				System.out.println(a);
				a++;
			}while(a<=b);
		}
	}
}

/* Programa que reciba dos n�meros, a y b, y muestre los n�meros que
hay entre a y b, ambos incluidos. Si a es mayor que b, debe mostrar un
mensaje de error.*/