package r2;

public class Ejercicio16b {

	public static void main(String[] args) {
		int i=0;
		
		if (args.length == 0){
			System.out.print("No existen parametros.");
			return;
		}
		while (i<args.length){
			System.out.println(args[i]);
			i++;
			}

	}
}
/* Realizar tres programas diferentes que muestre los argumentos
introducidos por el usuario.*/