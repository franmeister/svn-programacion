package r2;

public class Ejercicio5w {

	public static void main(String[] args) {
		char ascii;
		int i=32;
		
		do{			
			ascii=(char)i;
			System.out.println(i+" --> "+ascii);
			i++;
		}while(i<=127);
	}
}
/* Escribir un programa que imprima por pantalla los codigos ASCII
correspondientes a los números desde el 32 al 127.*/