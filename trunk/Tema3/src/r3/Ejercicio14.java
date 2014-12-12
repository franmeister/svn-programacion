package r3;

public class Ejercicio14 {

	public static void main(String[] args) {
		int i=0;
		
		do{
			String usu=PedirDatos.leerCadena("Introduce usuario: ");
			String pass=PedirDatos.leerCadena("Introduce contraseña: ");
			
			if (usu.equals("fran") && pass.equals("cisco")){
				System.out.println("Enhorabuena!!");
				break;
			}else{
				System.out.println("Contraseña errónea.");
				i++;
			}

		}while(i<3);
	}

}
/*Uno de los usos más habituales para los bucles condicionales es la
validación de entradas. Escribir un programa que pida una contraseña y
permita tres intentos. Si el usuario da la contraseña correcta responde
"Enhorabuena!" y queda inactivo, con este mensaje. En caso contrario el
programa escribe "Lo siento, contraseña equivocada" y se cierra de
inmediato.*/