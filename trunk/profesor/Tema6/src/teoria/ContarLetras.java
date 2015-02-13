package teoria;

import java.io.*;

public class ContarLetras {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		String ruta="E:\\Users\\Antonio\\Desktop\\Java\\Tema6\\ContarLetras.txt";
		char caracter;
		int cont=0;
		try {
			RandomAccessFile raf=new RandomAccessFile(ruta, "r");
			for(int i=0;i<raf.length();i++){
				raf.seek(i);
				caracter=(char)raf.readByte();
				if(caracter=='a'||caracter=='A'){
					cont++;
				}
			}
		
			raf.close();
			System.out.println("El numero es: "+cont);
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		
	}

}
