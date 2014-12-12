package teoria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		int opcion=0;
		ColaSupermercado caja=new ColaSupermercado();
		String dni,nombre,direccion;
		
		do{
			System.out.println("\n");
			System.out.println("1.Nuevo Cliente");
			System.out.println("2.Mostrar Primer Cliente");
			System.out.println("3.Cobrar");
			System.out.println("4.Salir");
			System.out.println("Elija una opcion:");
			System.out.println("\n");
			
			try{
				opcion=teclado.nextInt();
			}catch(InputMismatchException e){
				//System.out.println("Debe Introducir un numero");
				teclado.next();
			}

			switch (opcion) {
			case 1:
				System.out.println("Introduce el DNI");
				dni=teclado.next();
				System.out.println("Introduce el nombre");
				nombre=teclado.next();
				System.out.println("Introduce la dirección");
				direccion=teclado.next();
				
				caja.nuevoCliente(new Cliente(dni,nombre,direccion));
				break;
			case 2:
				System.out.println(caja.primerCliente());
				break;
			case 3:
				System.out.println(caja.pagaCliente());
				break;
			case 4:
				System.out.println("Adios!!!");
				break;
			default:
				System.out.println("Debe selecionar 1, 2, 3 o 4");
				System.out.println("Vuelva a intentarlo");
				break;
			}
			
		}while(opcion!=4);
		teclado.close();
	}

}
