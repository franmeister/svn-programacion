package relacion1;

import java.io.*;

public class GuardarText {

	public static void main(String[] args) throws IOException {
		/*Crear un programa llamado guardarText que sirva para capturar y escribir en un archivo
todas las líneas de texto que escriba el usuario en la línea de comandos hasta que escriba
una vacía, momento en el cual el archivo se cerrará y se leerá escribiendo en la consola su
contenido. */
		
		String fguardado="E:\\Users\\USUARIO\\Desktop\\Java\\Tema6\\copia.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new FileWriter(fguardado));
		String linea;
		
		do{
			System.out.println("Introduzca una linea");
			linea=br.readLine();
			bw.write(linea);
			bw.newLine();
		}while(!linea.isEmpty());//debemos ponerlo con isEmpty porque si lo hacemos con ascii no sale
		
		bw.flush();
		br.close();
		bw.close();
		
		BufferedReader leer=new BufferedReader(new FileReader(fguardado));
		
		linea=leer.readLine();
		while(linea!=null){
			System.out.println(linea);

			linea=leer.readLine();
		};
		
		
		leer.close();

	}
		
		
	

}
