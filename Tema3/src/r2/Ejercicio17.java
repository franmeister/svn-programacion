package r2;

public class Ejercicio17 {

	public static void main(String[] args) {
		int i=0;
		
		while (i<args.length){
			System.out.println(args[i].toUpperCase());
			i++;
		}
	}

}
/*Escriba un programa que convierta a may�sculas todos los argumentos
que se le pasan y los escriba a la pantalla. Escr�balo usando la
instrucci�n while(condici�n) { ... }. Para ello busque en los encabezados
de la clase java.lang.String un m�todo que devuelve una cadena en
may�sculas (en ingl�s may�scula se escribe "upper case")*/