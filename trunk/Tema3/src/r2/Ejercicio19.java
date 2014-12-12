package r2;

public class Ejercicio19 {

	public static void main(String[] args) {
		int i=0;
		double sum=0;
		
		do{
			try{
				sum=sum+Double.parseDouble(args[i]);
			}catch(NumberFormatException e){
				System.out.println("El parámetro "+args[i]+" no es un número.");
			}
			i++;
		}while(i<args.length);
		System.out.println("El resultado es: "+sum);
	}

}
/* Escriba un programa que reciba como parámetros números con coma
flotante, los sume y escriba el resultado de la suma en la pantalla.
Hágalo de manera que verifique que haya parámetros y use la
instrucción do {...} while(condición). Para convertir una cadena en un
número utilice métodos de la clase java.lang.Double. Utilice una
construcción try { ... } catch (NumberFormatException e){ ... } para
analizar los casos en que un parámetro no represente un número y el
programa reporte el error escribiendo el parámetro erróneo en la
pantalla.*/