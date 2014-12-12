package r3;

public class Ejercicio5 {

	public static double eurosAPesetas(double eu){
		return eu*166.67;
	}
	public static double pesetasAEuros(double pes){
		return pes/166.67;
	}

	public static void main(String[] args) {
		System.out.println("60€ son "+eurosAPesetas(60)+" pesetas.");
		System.out.println("3.000 pesetas son "+pesetasAEuros(3000)+"€.");
	}

}
/* Diseñar dos funciones "EurosAPesetas()
" y "PesetasAEuros()" que realicen las conversiones de monedas*/