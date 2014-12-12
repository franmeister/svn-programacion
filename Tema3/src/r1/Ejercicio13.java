package r1;

public class Ejercicio13 {

	public static void main(String[] args) {
		double n=-55;
		if (n<0){
			System.out.print("El número introducido es negativo. La raíz cuadrada de un número negativo no tiene solución en el conjunto de los reales.");
		}else{
			System.out.print("La raiz cuadrada de "+n+" es: "+Math.sqrt(n));
		}
	}
}
/* Realizar un programa que reciba un valor real y devuelva su raíz
cuadrada.
El programa debe controlar que el valor leído no sea negativo.*/