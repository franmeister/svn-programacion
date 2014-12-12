package teoria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestPalet {

	public static void main(String[] args) {
		int op = 0, num;
		double peso;
		Palet p=new Palet();
		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("\nIntroduce una de las opciones: \n1. Poner Caja\n2. Quitar Caja.\n3. Ver Caja Superior.\n4. Salir.");
			try {
				op = teclado.nextInt();
			} catch (InputMismatchException e) {
				teclado.next();
				op=0;
			}

			switch (op) {
			case 1:
				System.out.println("Introduce número de caja: ");
				num=teclado.nextInt();
				System.out.println("Introduce peso de caja: ");
				peso=teclado.nextDouble();
				p.ponerCaja(new Caja(num, peso));
				break;
			case 2:
				System.out.println("Introduce número de caja: ");
				num=teclado.nextInt();
				p.sacarCaja(num);
				break;
			case 3:
				Caja ret=p.verCajaSuperior();
				if(ret!=null){
					System.out.println(ret);
				}
				break;
			case 4:
				break;
			default:
				System.out.println("Error. Introduce 1, 2, 3 o 4.");
				break;
			}
		}while (op != 4);
		teclado.close();
	}

}
