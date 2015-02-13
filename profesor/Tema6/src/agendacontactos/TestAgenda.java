package agendacontactos;

import java.io.*;

public class TestAgenda {

	public static void main(String[] args) {
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("introduzca la ruta del fichero");
		String ruta;
		File f;
		try {
			ruta=teclado.readLine();
			ruta="E:\\Users\\Antonio\\Desktop\\Java\\Tema6\\Agenda.txt";
			f= new File (ruta);
			if(!f.isFile()){
				System.out.println("la ruta introducida no es un fichero");
				return;
			}
			Agenda a=new Agenda(f);
			a.menu();
			
		} catch (IOException e) {
			System.out.println("asi te gusta más hector");
		}
		
		

	}

}
