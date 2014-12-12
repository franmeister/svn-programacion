package r3;

public class Ejercicio4 {
	
	public static String aMayusculas(String cad){
		String cmay=cad.toUpperCase();
		return cmay;
	}
	public static void main(String[] args) {
		for (int i=0;i<args.length;i++){
			System.out.print(aMayusculas(args[i]));
			if (i != args.length-1){
				System.out.print(" ");
			}
		}
	}

}
/* Diseñar una función "aMayusculas()" que 
convierta una cadena de texto en mayúsculas*/
