package r1;

public class Ejercicio3 {

	public static void main(String[] args) {
		int a=350,b=250,c=50;
		
		if (a>b){
			if (a>c){
				System.out.print(a+" "+b+" "+c);
			}else{
				System.out.print(c+" "+a+" "+b);
			}
		}else{
			if (b>c){
				System.out.print(b+" ");
				if (c<a){
					System.out.print(a+" "+c);
				}else{
					System.out.print(c+" "+a);
				}
			}else{
				System.out.print(c+" "+b+" "+a);
			}
		}
	}

}
/* Escribe un algoritmo que pida tres números y los muestre ordenados.*/