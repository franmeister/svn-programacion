package teoria;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Corrientes {

	public static void main(String[] args) throws IOException {
		// TODO Apéndice de método generado automáticamente
		//InputStreamReader isr=;
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca una cadena");
		String cadena=teclado.readLine();
		
		BufferedWriter pantalla=new BufferedWriter(new OutputStreamWriter(System.out));
		pantalla.write(cadena);
		pantalla.flush();
		System.out.println("Introduzca otra cadena");
		cadena=teclado.readLine();
		pantalla.newLine();
		pantalla.write(cadena);
		
		pantalla.flush();
		
		teclado.close();
		pantalla.close();
		System.out.println("dime otra cadena");
		teclado.readLine();
	}

}
