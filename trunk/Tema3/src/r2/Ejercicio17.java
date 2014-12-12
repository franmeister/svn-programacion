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
/*Escriba un programa que convierta a mayúsculas todos los argumentos
que se le pasan y los escriba a la pantalla. Escríbalo usando la
instrucción while(condición) { ... }. Para ello busque en los encabezados
de la clase java.lang.String un método que devuelve una cadena en
mayúsculas (en inglés mayúscula se escribe "upper case")*/