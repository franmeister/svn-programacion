package r1;

public class Ejercicio3a {

	public static void main(String[] args) {
		int a=51,b=7,c=3,aux;
		
		if (a>b){
			aux=a;
			a=b;
			b=aux;			
		}
		if (a>c){
			aux=a;
			a=c;
			c=aux;
		}
		if (b>c){
			aux=b;
			b=c;
			c=aux;
		}
		System.out.print(a+" "+b+" "+c);
	}

}
/* Escribe un algoritmo que pida tres números y los muestre ordenados.*/