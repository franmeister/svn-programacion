package r2;

public class Ejercicio20 {

	public static void main(String[] args) {
		try{
			int n=Integer.parseInt(args[0]);
			for (int i=1;i<args.length;i++){
				if (n>Integer.parseInt(args[i])){
					n=Integer.parseInt(args[i]);
				}			
			}
			System.out.println(n);
		}catch(Exception e){
			System.out.println("Error. Todos los parámetros deben ser números enteros.");
		}
	}
}
/*Escribe un programa que reciba como parámetros números enteros,
busque el más pequeño y lo escriba en la pantalla.*/