package r3;

public class Ejercicio14 {

	public static void main(String[] args) {
		int i=0;
		
		do{
			String usu=PedirDatos.leerCadena("Introduce usuario: ");
			String pass=PedirDatos.leerCadena("Introduce contrase�a: ");
			
			if (usu.equals("fran") && pass.equals("cisco")){
				System.out.println("Enhorabuena!!");
				break;
			}else{
				System.out.println("Contrase�a err�nea.");
				i++;
			}

		}while(i<3);
	}

}
/*Uno de los usos m�s habituales para los bucles condicionales es la
validaci�n de entradas. Escribir un programa que pida una contrase�a y
permita tres intentos. Si el usuario da la contrase�a correcta responde
"Enhorabuena!" y queda inactivo, con este mensaje. En caso contrario el
programa escribe "Lo siento, contrase�a equivocada" y se cierra de
inmediato.*/