package r2;

public class Ejercicio16c {

	public static void main(String[] args) {
		int i=0;
		
		if (args.length == 0){
			System.out.print("No existen parametros.");
			return;
		}
		do{
			System.out.println(args[i]);
			i++;
			}while (i<args.length);

	}
}
/* Realizar tres programas diferentes que muestre los argumentos
introducidos por el usuario.*/