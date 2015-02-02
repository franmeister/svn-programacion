package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBibliot {

	public static void main(String[] args) {
		/*BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		String ruta="";
		
		System.out.println("Introduce ruta del directorio: ");
		try {
			ruta=teclado.readLine();
		} catch (IOException e) {
			System.out.println("Error al leer datos");
		}
		Biblioteca b = new Biblioteca(ruta);*/
		
		Biblioteca b = new Biblioteca("E:\\Users\\USUARIO\\Desktop\\svnJava\\Biblioteca\\src\\Biblioteca\\ficheros");
		
		//Biblioteca b = new Biblioteca("C:\\Users\\usuario\\Documents\\cursos\\DAW\\PRO\\svn-programacion\\Biblioteca\\src\\Biblioteca\\ficheros");

		b.menu();
		
	}

}
