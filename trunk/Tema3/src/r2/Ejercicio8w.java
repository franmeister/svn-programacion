package r2;

public class Ejercicio8w {

	public static void main(String[] args) {
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		int aux;
		
		if (b<a){
			aux=b;
			b=a;
			a=aux;
		}
		
		do{
			System.out.println(a);
			a++;
		}while(a<=b);
	}
}
/* Programa que reciba dos números, a y b, y cuente desde el menor hasta
el mayor*/