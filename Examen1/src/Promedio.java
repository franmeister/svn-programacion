
public class Promedio {

	public static double media(double num1, double num2, double num3, double num4, double num5){
		double res;
		
		res=(num1+num2+num3+num4+num5)/5;
		return res;
	}
	
	public static void main(String[] args) {
		double n1=PedirDatos.leerDecimal("Introduce primer n�mero: ");
		double n2=PedirDatos.leerDecimal("Introduce segundo n�mero: ");
		double n3=PedirDatos.leerDecimal("Introduce tercer n�mero: ");
		double n4=PedirDatos.leerDecimal("Introduce cuarto n�mero: ");
		double n5=PedirDatos.leerDecimal("Introduce quinto n�mero: ");
		
		System.out.print("La media de los n�meros es: "+media(n1,n2,n3,n4,n5));

	}

}
 