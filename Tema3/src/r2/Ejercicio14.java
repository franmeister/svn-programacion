package r2;

public class Ejercicio14 {

	public static void main(String[] args) {		
		if (args.length == 0){
			System.out.print("No existen parametros.");
		}else{
			for (int i=0;i<args.length;i++){
				System.out.println(args[i]);
			}
		}
	}

}
/* Realizar un programa en JAVA que muestre el valor de los argumentos
que se le pasan por par�metros. En caso de no existir par�metros, se lo
comunicaremos al usuario.*/