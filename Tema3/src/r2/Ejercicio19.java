package r2;

public class Ejercicio19 {

	public static void main(String[] args) {
		int i=0;
		double sum=0;
		
		do{
			try{
				sum=sum+Double.parseDouble(args[i]);
			}catch(NumberFormatException e){
				System.out.println("El par�metro "+args[i]+" no es un n�mero.");
			}
			i++;
		}while(i<args.length);
		System.out.println("El resultado es: "+sum);
	}

}
/* Escriba un programa que reciba como par�metros n�meros con coma
flotante, los sume y escriba el resultado de la suma en la pantalla.
H�galo de manera que verifique que haya par�metros y use la
instrucci�n do {...} while(condici�n). Para convertir una cadena en un
n�mero utilice m�todos de la clase java.lang.Double. Utilice una
construcci�n try { ... } catch (NumberFormatException e){ ... } para
analizar los casos en que un par�metro no represente un n�mero y el
programa reporte el error escribiendo el par�metro err�neo en la
pantalla.*/