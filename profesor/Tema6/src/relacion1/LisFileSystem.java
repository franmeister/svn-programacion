package relacion1;

import java.io.*;

public class LisFileSystem {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		File f=new File("");
		
		System.out.println("El separador de direcciones es "+f.pathSeparator);
		System.out.println("El separador de directorios es "+f.separator);
		
		File[] raices=f.listRoots();
		for(int i=0;i<raices.length;i++){
			System.out.println(raices[i].getAbsolutePath());
		}
	}

}
