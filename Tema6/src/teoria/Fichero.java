package teoria;

import java.io.File;

public class Fichero {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		File f=new File("E:\\Users\\Antonio\\Desktop");
		
		String[] lista=f.list();
		for (int i=0;i<lista.length;i++){
			System.out.println(lista[i]);
		}
		//System.out.println(f.separator.charAt(0));
		f.delete();
		/*File f=new File("C:\\");
		
		File f1=new File("C:\\","hola.txt");
		File f2=new File(f,"hola.txt");
		File f3=new File("C:\\hola.txt");
		
		if(f3.exists()){
			if(f3.isFile()){
				System.out.println("Es archivo");
				System.out.println(f3.getParent());
			}else{
				System.out.println("Es directorio");
			}
		}else{
			System.out.println("El fichero no existe");
		}
*/
	}

}
