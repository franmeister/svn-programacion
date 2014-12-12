import java.util.Scanner;


public class Ejercicio18 {

	public static void main(String[] args) {
		double bru,ret;
		Scanner s = new Scanner(System.in);
		System.out.println("Introduce el nombre del trabajador: ");
		String nom = s.next();
		System.out.println("Introduce las horas trabajadas: ");
		double hor = s.nextDouble();
		System.out.println("Introduce el precio de la hora: ");
		double pre = s.nextDouble();
		s.close();
		bru=hor*pre;
		System.out.println("Sueldo Bruto: "+bru);
		ret=bru*0.05;
		System.out.println("Retención: "+ret);
	    int cifras=(int) Math.pow(10,2);
	    ret=Math.rint(ret*cifras)/cifras;
		System.out.println("Sueldo Neto: "+(bru-ret));
	}

}
/* Escribir un programa que calcule la nómina de un trabajador de la
manera siguiente. El trabajador cobra un precio fijo por hora y se le
retiene un 5% en concepto de IRPF. El programa debe pedir el nombre
del trabajador, las horas trabajadas y el precio que cobra por hora.
Como salida debe imprimir el sueldo bruto, la retención y el sueldo neto. */