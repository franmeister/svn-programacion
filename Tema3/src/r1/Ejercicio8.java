package r1;

public class Ejercicio8 {

	public static void main(String[] args) {
		int a=200,b=20,c=2005;
		int max=a, min=b;
		
		if (b>max){
			max=b;
		}
		if (c>max){
			max=c;
		}
		if (a<min){
			min=a;
		}
		if (c<min){
			min=c;
		}
		System.out.print("El mayor es "+max+" y el menor es "+min);
	}

}
/* Escribir un programa que reciba tres valores enteros y muestre por
pantalla el máximo y el mínimo de ellos. */