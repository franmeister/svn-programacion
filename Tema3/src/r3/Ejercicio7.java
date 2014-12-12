package r3;

import java.io.IOException;

public class Ejercicio7 {
	public static char leerCaracter(String frase){
		char caracter=(char)0;
		int ascii = 0;
		System.out.println(frase);
		try {
			ascii = System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		caracter = (char) ascii;
		return caracter;
	}

	public static String leerCadena(String frase){
		String cadena="";
		char caracter=(char)0;
		int ascii = 0;
		System.out.println(frase);
		do{
			cadena=cadena+caracter;
			try {
				ascii = System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			caracter = (char) ascii;
		}while(ascii!=13);
		return cadena.trim();
	}
	
	public static int leerEntero(String frase){
		int entero=0;
		String cadena;
		boolean correcto=false;
		
		do{
			try{
				cadena=leerCadena(frase); 
				entero=Integer.parseInt(cadena);
				correcto=true;
			}catch(NumberFormatException e){
				System.out.println("El valor introducido no es un entero");
			}
		}while(!correcto);
		return entero;
		
	}

	public static double leerDecimal(String frase){
		double decimal=0;
		String cadena;
		boolean correcto=false;
		
		do{
			try{
				cadena=leerCadena(frase); 
				decimal=Double.parseDouble(cadena);
				correcto=true;
			}catch(NumberFormatException e){
				System.out.println("El valor introducido no es un decimal");
			}
		}while(!correcto);
		return decimal;
		
	}

	public static void main(String args[]){
		/*String nombre=leerCadena("Introduce el nombre");
		String apellido1=leerCadena("Introduce el primer apellido");
		String apellido2=leerCadena("Introduce el segundo apellido");
		
		System.out.print("El nombre completo es "+nombre+" "+apellido1+" "+apellido2);
		*/
		double numero1=leerDecimal("Dame el numero 1");
		double numero2=leerDecimal("Dame el numero 2");

		System.out.print(numero1+"+"+numero2+"="+(numero1+numero2));
	}
}
