package r1;

public class Ejercicio13 {

	public static void main(String[] args) {
		double n=-55;
		if (n<0){
			System.out.print("El n�mero introducido es negativo. La ra�z cuadrada de un n�mero negativo no tiene soluci�n en el conjunto de los reales.");
		}else{
			System.out.print("La raiz cuadrada de "+n+" es: "+Math.sqrt(n));
		}
	}
}
/* Realizar un programa que reciba un valor real y devuelva su ra�z
cuadrada.
El programa debe controlar que el valor le�do no sea negativo.*/