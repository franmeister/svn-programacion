package r3;

public class Ejercicio3 {

	public static double potencia(double x,int n){
		int res=1;
		
		for (int i=1;i<=n;i++){
			res*=x;
		}
		return res;
	}
	public static void main(String[] args) {
		try{
			double res, x=Double.parseDouble(args[0]);
			int n=Integer.parseInt(args[1]);
			
			res=potencia(x,n);
			System.out.println(x+"^"+n+" = "+res);
		}catch(Exception e){
			System.out.println("Error, los argumentos deben ser números enteros.");
		}
	}

}
/* Diseñar una función que calcule la potencia enésima de un número, es
decir que calcule X^n para X, real y n entero*/
