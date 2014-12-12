package r3;

public class Ejercicio18 {

	public static void main(String[] args) {
		String cad=PedirDatos.leerCadena("Introduce una frase terminada en \".\":");
		int pa=1;
		
		if(cad.endsWith(".")){
			for(int i=0;i<cad.length();i++){
				if(cad.charAt(i)==' '){
					pa++;
				}
			}
			System.out.println("Son "+pa+" palabras.");
		}else{
			System.out.println("Error. La frase no termina en punto.");
		}
	}

}
/*Escribir un programa que reciba una frase acabada en un punto y
cuente las palabras que contiene.*/