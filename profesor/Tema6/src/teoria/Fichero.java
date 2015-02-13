package teoria;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fichero {

	public static void main(String[] args) throws IOException {
		// TODO Apéndice de método generado automáticamente
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca el directorio a examinar");
		String ruta=br.readLine();
		//String ruta=PedirDatos.leerCadena("Introduzca el directorio a examinar");
		//String ruta="E:\\Users\\Antonio\\Desktop";
		File f=new File(ruta);
		File f1;
		String cadena;
		String[] lista=f.list();
		for (int i=0;i<lista.length;i++){
			f1=new File(ruta,lista[i]);
			if(f1.isDirectory()){
				cadena="es Directorio";
			} else {
				cadena="es Archivo";
			}
			System.out.println(lista[i]+"---"+cadena);
		}
		//System.out.println(f.separator.charAt(0));
		f.delete();
		/*File f=new File("C:\\");
		
		File f1=new File("C:\\","hola.txt");
		File f2=new File(f,"hola.txt");
		File f3=new File("C:\\hola.txt");
		
		if(f3.exists()){
			if(f3.isFile()){
				System.out.println("Es archivo");
				System.out.println(f3.getParent());
			}else{
				System.out.println("Es directorio");
			}
		}else{
			System.out.println("El fichero no existe");
		}
*/
	}

}
