package teoria;

import java.io.*;

public class LeerFichero {

	public static void main(String[] args) throws IOException {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		File f1=new File("");
		
		String linea;
		File f=new File(f1.getAbsolutePath(),"Texto.txt");
		BufferedReader br=new BufferedReader(new FileReader(f));
		
		linea=br.readLine();
		while(linea!=null){
			System.out.println(linea);

			linea=br.readLine();
		};
		
		br.close();
	}

}
