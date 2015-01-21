package teoria;

import java.io.*;

public class NotasMedias {

	public static void main(String[] args) throws IOException {
		File temp=new File("E:\\Users\\USUARIO\\Desktop\\Notas.tmp");
		File f=new File("E:\\Users\\USUARIO\\Desktop\\Notas.txt");
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter fsalida=new BufferedWriter(new FileWriter(temp));
		BufferedReader fentrada=new BufferedReader(new FileReader(f));
		String linea;
		linea=fentrada.readLine();
		while (linea!=null){
			fsalida.write(linea);
			fsalida.newLine();
			linea=fentrada.readLine();
		};
		
		System.out.println("Introduzca el DNI");
		String dni=teclado.readLine();
		System.out.println("Introduzca el Nombre");
		String nombre=teclado.readLine();
		System.out.println("Introduzca la nota media");
		String nota=teclado.readLine();
		
		fsalida.write(dni);
		fsalida.write(nombre);
		fsalida.write(nota);
		
		fsalida.flush();
		fsalida.close();
		
		f.delete();
		temp.renameTo(f);
		
	}

}
