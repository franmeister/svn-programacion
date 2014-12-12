package r2;

public class Ejercicio6 {

	public static void main(String[] args) {
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		
		if (a>b){
			System.out.print("Error, \"a\" es mayor que \"b\".");
		}else{
			for(int i=a;i<=b;i++){
				System.out.println(i);
			}
		}
	}
}

/* Programa que reciba dos números, a y b, y muestre los números que
hay entre a y b, ambos incluidos. Si a es mayor que b, debe mostrar un
mensaje de error.*/