package r3;

public class Ejercicio8 {

	public static void main(String[] args) {
		int n=args.length;
		
		switch (n) {
		case 0:
			System.out.println("Has pasado 0 argumentos.");
			break;
		case 1:
			System.out.println("Has pasado 1 argumentos.");
			break;
		case 2:
			System.out.println("Has pasado 2 argumentos.");
			break;
		case 3:
			System.out.println("Has pasado 3 argumentos.");
			break;
		default:
			System.out.println("Has pasado más de 3 argumentos.");
			break;
		}
	}

}
/* Realizar un programa que indique al usuario si a pasado 0, 1, 2, 3 o más
argumentos. */