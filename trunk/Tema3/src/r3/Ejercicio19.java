package r3;

public class Ejercicio19 {

	public static void main(String[] args) {
		String cad=PedirDatos.leerCadena("Introduce una palabra: ");
		char car;
		int v=0,c=0;

		for(int i=0;i<cad.length();i++){
			car=cad.charAt(i);
			if((car=='a')||(car=='e')||(car=='i')||(car=='o')||(car=='u')||(car=='A')||(car=='E')||(car=='I')||(car=='O')||(car=='U')){
				v++;
			}else{
				c++;
			}
		}
		System.out.println("La palabra "+cad+" contiene "+c+" consonantes y "+v+" vocales.");

	}

}
/* Escribir un programa que reciba una palabra y cuente el número de
vocales y consonantes que contiene. */