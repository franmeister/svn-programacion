package r3;

public class Ejercicio2 {
	public static int factorial(int num){
		if(num == 1) {
			return 1; 
		}else{
			return num * factorial(num-1);
		}
	}
	public static void main(String[] args) {
		for (int i=1;i<=8;i++){
			System.out.println(i+"! = "+factorial(i));
		}
	}
}
/*Utilizando la función anterior, hacer un programa que escriba los
primeros 8 factoriales, mostrando en pantalla lo siguiente:*/