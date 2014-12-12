
public class Promedio {

	public static double media(double num1, double num2, double num3, double num4, double num5){
		double res;
		
		res=(num1+num2+num3+num4+num5)/5;
		return res;
	}
	
	public static void main(String[] args) {
		double n1=PedirDatos.leerDecimal("Introduce primer número: ");
		double n2=PedirDatos.leerDecimal("Introduce segundo número: ");
		double n3=PedirDatos.leerDecimal("Introduce tercer número: ");
		double n4=PedirDatos.leerDecimal("Introduce cuarto número: ");
		double n5=PedirDatos.leerDecimal("Introduce quinto número: ");
		
		System.out.print("La media de los números es: "+media(n1,n2,n3,n4,n5));

	}

}
 