package relacion1;

import java.io.*;

public class DirSize {

	static double totalkbytes=0;
	static int numficheros=0;

	private static void examinarDirectorio(File f){
		File[] lista=f.listFiles();
		if(lista==null){
			return;
		}
		for(int i=0;i<lista.length;i++){
			if(lista[i].isFile()){
				numficheros++;
				totalkbytes=totalkbytes+lista[i].length();
			}
			if(lista[i].isDirectory()){
				examinarDirectorio(lista[i]);
			}
		}

	}
	
	public static void main(String[] args) throws IOException {
		// TODO Apéndice de método generado automáticamente
		
		String ruta;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca la ruta a examinar");
		ruta=br.readLine();
		
		//ruta="E:\\";
		//ruta="E:\\Users\\Antonio\\Desktop\\Java";
		//ruta="E:\\Users\\Antonio\\Desktop\\Java\\Tema5\\src\\proveedores\\Empresa.java";
		File f=new File(ruta);
		if(!f.exists()){
			System.out.println("Ruta erronea");
			return;
		}
		
		if(f.isFile()){
			numficheros++;
			totalkbytes=totalkbytes+f.length();
		}
		
		if(f.isDirectory()){
			examinarDirectorio(f);
		}
		
		System.out.println("El numero de ficheros es:"+numficheros);
		System.out.println("El total de MBytes es: "+(totalkbytes/1024)/1024);

	}

}
