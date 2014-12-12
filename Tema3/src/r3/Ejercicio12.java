package r3;

public class Ejercicio12 {

	/*Algoritmo que pida caracteres e imprima 'VOCAL' si son vocales y
	'CONSONANTE' si no.*/
	
	public static void main(String[] args) {
		
		char car;
		
		int num=PedirDatos.leerEntero("Introduce el numero de caracteres a leer: ");

		for (int i=0;i<num;i++){
			car=PedirDatos.leerCaracter("Introduce un caracter: ");
			
			if ((car=='a')||(car=='e')||(car=='i')||(car=='o')||(car=='u')||(car=='A')||(car=='E')||(car=='I')||(car=='O')||(car=='U')){
				System.out.println(car + " es vocal.");
			}else{
				System.out.println(car + " es consonate.");
			}
		}
	}

}
