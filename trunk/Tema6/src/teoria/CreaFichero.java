package teoria;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreaFichero {
	 	 
	    public static void main(String[] args) throws IOException {
	        File f1=new File("");
	        File f=new File(f1.getAbsolutePath(),"ud4\\fichero.dat");
	        f.mkdir();
	         
	        BufferedWriter bw=new BufferedWriter(new FileWriter(f));
	        
	        bw.write("10,100,1000,-10");
	        bw.flush();
	        bw.close();
	 
	    }
	 
}
