package teoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class Teoria1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca el fichero o directorio a examinar");
		String ruta=br.readLine();
		
		File f1=new File(ruta);
		if(!f1.exists()){
			System.out.println("La ruta "+ruta+" no existe");
			return;
		}
		
		if(f1.isDirectory()){
			System.out.println(ruta+" es un directorio");
		}
		if(f1.isFile()){
			System.out.println(ruta+" es fichero");
		}
		
		System.out.println("El nombre del fichero es "+f1.getName());
		System.out.println("El path relativo es "+f1.getPath());
		System.out.println("El path absoluto es "+f1.getAbsolutePath());
		
		if(f1.canRead()){
			System.out.println("El fichero se puede leer");
		}
		
		if(f1.canWrite()){
			System.out.println("El fichero se puede escribir");
		}
		
		if(f1.isDirectory()){
			String[] lista=f1.list();
			for(int i=0;i<lista.length;i++){
				System.out.println(lista[i]);
			}
		}
			
	}
	

}
