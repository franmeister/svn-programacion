package teoria;

import java.io.*;

public class Ejercicio4Corregido {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String ficheroEntrada,ficheroSalida;
		//BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Introduzca la dirección del fichero original a copiar");
		//ficheroEntrada=teclado.readLine();
		//System.out.println("Introduzca la dirección del fichero a crear");
		//ficheroSalida=teclado.readLine();
		ficheroEntrada="E:\\Users\\Antonio\\Desktop\\Java\\Tema6\\Texto1.txt";
		ficheroSalida="E:\\Users\\Antonio\\Desktop\\Java\\Tema6\\CopiaTexto.txt";
		
		File fentrada=new File(ficheroEntrada);
		
		if(!fentrada.exists()||!fentrada.isFile()||fentrada.length()==0){
			System.out.println("La dirección introducida no existe o no apunta a un fichero");
			return;
		}
		
		File fsalida=new File(ficheroSalida);
		if(fentrada.equals(fsalida)){
			System.out.println("Los ficheros no se pueden llamar igual");
			return;
		}
		
		if(fsalida.exists()){
			System.out.println("el fichero de escritura introducido ya existe");
			return;
		}

		//Copio un fichero en otro
		BufferedReader br=new BufferedReader(new FileReader(fentrada));
		BufferedWriter bw=new BufferedWriter(new FileWriter(fsalida));
		
		String linea=br.readLine();
		while(linea!=null){
			bw.write(linea);
			bw.newLine();
			linea=br.readLine();
		}
		
		bw.flush();
		
		br.close();
		bw.close();
		//teclado.close();
		
	}	

}
