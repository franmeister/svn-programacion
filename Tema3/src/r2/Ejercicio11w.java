package r2;

public class Ejercicio11w {

	public static void main(String[] args) {
		int n=Integer.parseInt(args[0]);
		int m=Integer.parseInt(args[1]);
		
		while(n<=m){
			System.out.println(n);
			n++;
		}
	}
}
/*Imprimir los números enteros comprendidos entre dos números enteros
n y m que se reciben como argumentos, siendo n menor o igual que m.*/