package r1;

import java.io.IOException;


public class PedirDatos {
	/* Funcion para leer caracteres*/
	public static char leerCaracter(String frase){
		char caracter;
		caracter=leerCadena(frase).charAt(0);
		return caracter;
	}
  
	/* Funcion para leer cadenas*/
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

	/* Funcion para leer enteros*/
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

	/* Funcion para leer decimales*/
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

}
