package r3;

public class Ejercicio1 {

	public static int factorial(int num){
		if(num == 1) {
			return 1; 
		}else{
			return num * factorial(num-1);
		}
	}
	public static void main(String[] args) {
		try{
			int n=Integer.parseInt(args[0]);
			int res=factorial(n);
			System.out.println(n+"! = "+res);
		}catch (Exception e){
			System.out.println("Error. El argumento debe ser un n�mero entero.");
		}
	}

}
/* Crea una funci�n en java que reciba como par�metro un n�mero entero
y devuelva el como resultado su factorial. */