package r3;

public class Ejercicio10c {
	/*Programa que pida n�meros hasta que se introduzca uno
	negativo. Entonces debe indicar cu�ntos n�meros se han
	introducido*/

	public static void main(String[] args) {
		int num=0;
		int cont=0;
		
		
		
		while(num>=0){
			num=PedirDatos.leerEntero("Introduzca un numero");
			cont++;
		
		}	
		System.out.println(cont);
		
	}

}
