package trabajoconficheros;

import java.io.*;

public class TestGestionAlumnos {

	public static void main(String[] args) {
		
		String ruta="";
		/*BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca la dirección del fichero original a copiar");
		try {
			ruta = teclado.readLine();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		 */
		ruta="E:\\Users\\Antonio\\Desktop\\Java\\Tema6\\Alumnos.txt";
		GestionAlumnos ga=new GestionAlumnos(ruta);
		ga.menu();

	}

}
