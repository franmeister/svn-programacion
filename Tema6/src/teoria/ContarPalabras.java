package teoria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ContarPalabras {

	public static void main(String[] args) {
		int a = 0;
		File f = new File("E:\\Users\\USUARIO\\Desktop\\svnJava\\Tema6\\src\\teoria\\fichero.txt");

		try {
			RandomAccessFile raf = new RandomAccessFile(f, "r");
			for (int i = 0; i < raf.length(); i++) {
				raf.seek(i);
				char n =(char) raf.readByte();
				if (n==' ' || n=='\n') {
					a++;
				}
			}
			raf.close();
			System.out.println(a);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
