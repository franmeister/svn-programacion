import java.util.Scanner;


public class Ejercicio12 {

	public static void main(String[] args) {
		double res,tot;
		System.out.println("Introduce precio del producto: ");
		Scanner s = new Scanner(System.in);
		double pre = s.nextDouble();
		System.out.println("Introduce unidades: ");
		int uni = s.nextInt();
		System.out.println("Introduce porcentaje de IVA: ");
		int iva = s.nextInt();
		s.close();
		tot=pre*uni;
		res=tot+tot*iva/100;
		System.out.println("El precio es "+res+" euros.");
	}

}
/*Realizar un programa que calcule el precio de una venta conociendo el
precio sin IVA por unidad de un producto, el número de productos
vendidos y el porcentaje del IVA aplicado */