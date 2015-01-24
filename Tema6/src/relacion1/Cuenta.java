package relacion1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Cuenta {
	
	private static int cuentaPalabras(File f){
		int n=0;

		try {
			BufferedReader flectura = new BufferedReader(new FileReader(f));
			
			String linea=flectura.readLine();
			while(linea!=null){
				if(!linea.matches("$")){  //Filtro para no contar con las líneas en blanco
					String[] palabras= new String[linea.length()];
					palabras=(linea.split(" "));
					n+=palabras.length;
				}
				linea=flectura.readLine();
			}
			flectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error. No se puede abrir el fichero.");
		} catch (IOException e) {
			System.out.println("Error. No se ha podido leer el fichero.");
		}
		return n;
	}
	
	private static int cuentaPalabrasST(File f){
		int n=0;

		try {
			BufferedReader flectura = new BufferedReader(new FileReader(f));
			
			String linea=flectura.readLine();
			while(linea!=null){
			    StringTokenizer st = new StringTokenizer(linea);
				n+=st.countTokens();
				linea=flectura.readLine();
			}
			flectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error. No se puede abrir el fichero.");
		} catch (IOException e) {
			System.out.println("Error. No se ha podido leer el fichero.");
		}
		return n;

	}

	public static void main(String[] args) {
		File f=new File("C:\\Users\\usuario\\Documents\\cursos\\DAW\\PRO\\svn-programacion\\Tema6\\src\\relacion1\\arc.txt");

		System.out.println("Utilizando métodos de la clase String. \nEl fichero tiene "+cuentaPalabras(f)+" palabras.");
		System.out.println("\nUtilizando la clase StringTokenizer().\nEl fichero tiene "+cuentaPalabrasST(f)+" palabras.");
	}

}
