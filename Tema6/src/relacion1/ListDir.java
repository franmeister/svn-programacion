package relacion1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListDir {

	private static void examinarDirectorio(File f, String ext) throws IOException{
		File[] lista=f.listFiles();
		for(int i=0;i<lista.length;i++){
			if(lista[i].isFile() && lista[i].getCanonicalPath().toLowerCase().endsWith("."+ext)) {
				System.out.println(lista[i].getCanonicalPath());
			}
			if(lista[i].isDirectory()){
				examinarDirectorio(lista[i], ext);
			}
		}

	}
	
	public static void main(String[] args) throws IOException {
		String ruta, ext;
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduzca la ruta a examinar: ");
		ruta=teclado.readLine();
		System.out.println("Introduzca la extensión: ");
		ext=teclado.readLine();
		teclado.close();
		File f=new File(ruta);
		
		if(f.isDirectory()){
			examinarDirectorio(f,ext);
			return;
		}
		
		System.out.println("Error. No es un directorio.");
		
	}

}
