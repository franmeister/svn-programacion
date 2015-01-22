package teoria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cuenta {
		private static void cuentaPalabras(File f) throws IOException{
			
			if(f==null){
				System.out.println("ERROR. El archivo no existe");
				return;
			}
			
			int cuentaPalabras=1;
			int posicion=0;
			String texto;
			
			BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter pantalla = new BufferedWriter(new FileWriter(f));
			
			do{
				System.out.println("Introduzca texto");
				texto=teclado.readLine();
				pantalla.write(texto);
				pantalla.newLine();
				
			}while(texto.isEmpty());
			
			pantalla.flush();
			pantalla.close();
			teclado.close();
			
			for(int i =0;i<texto.length();i++){
				if(texto.substring(posicion, posicion+1).equals(" ")){
					cuentaPalabras++;
					posicion++;
				}else{
					posicion++;
				}
			}
			
			System.out.println("Palabras: "+cuentaPalabras);
			
		}
		
		public static void main(String[] args) throws IOException {
			
			
			String ruta;
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduce la ruta del archivo");
			ruta=teclado.readLine();
			File f = new File(ruta);
			
			cuentaPalabras(f);
			
			teclado.close();
			
			
		}
	}
