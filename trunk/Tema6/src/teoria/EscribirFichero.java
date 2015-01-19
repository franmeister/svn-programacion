package teoria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class EscribirFichero {

	public static void main(String[] args) throws IOException {
		// TODO Apéndice de método generado automáticamente
		File f1=new File("");
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		String linea;
		
		File f=new File(f1.getAbsolutePath(),"Escritura.txt");
		
		BufferedWriter bw=new BufferedWriter(new FileWriter(f));
		
		System.out.println("Introduce una linea");
		linea=teclado.readLine();
		bw.write(linea);
		bw.flush();
		
		
		bw.close();

	}

}
