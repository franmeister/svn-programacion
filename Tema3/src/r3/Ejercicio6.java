package r3;

public class Ejercicio6 {

	public static int Trienios(int n){
		return n/3;
	}
	
	public static boolean EsMultiplo(int a, int b){
		if (a%b == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		try{
			int an=Integer.parseInt(args[0]);
			System.out.println(Trienios(an));
		}catch(Exception e){
			System.out.println("Error, el número debe ser entero.");
		}
	}

}
/* Escribir una función "Trienios" que sirva para determinar cuantos trienios
tiene el trabajador. Utilizarla en un programa que pida la antiguedad de
un trabajador y calcule cuantos trienios de antigüedad tiene.*/