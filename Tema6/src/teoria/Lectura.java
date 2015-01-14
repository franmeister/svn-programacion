package teoria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lectura {

	public static void main(String[] args) throws IOException {
		/*InputStreamReader ins=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(ins);*/
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduzca una cadena");
		String cadena=teclado.readLine();
		
		BufferedWriter pantalla = new BufferedWriter(new OutputStreamWriter(System.out));
		
		pantalla.write(cadena);
		pantalla.newLine();
		pantalla.flush();
		
		System.out.println("Introduzca una cadena");
		cadena=teclado.readLine();
		
		pantalla.write(cadena);
		pantalla.flush();
		
		pantalla.close();
		teclado.close();
	}

}
