package r2;

public class Ejercicio8 {

	public static void main(String[] args) {
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		int aux;
		
		if (b<a){
			aux=b;
			b=a;
			a=aux;
		}
		for (int i=a;i<=b;i++){
			System.out.println(i);
		}
	}
}
/* Programa que reciba dos números, a y b, y cuente desde el menor hasta
el mayor*/