package r1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoCumpleanos {

	public static void main(String[] args) throws IOException {
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		String linea;
		String[] a = new String[5];
		int dias=0;
		
		while(true){
			linea=teclado.readLine();
			if(linea.equals("0 0 0 0 0 0")){
				break;
			}
			a=linea.split(" ");
			if (a[0].equals(a[3]) && a[1].equals(a[4])){
				System.out.println("0");
				continue;
			}
			dias = (Integer.parseInt(a[5]) - Integer.parseInt(a[2]))*365;
			dias -= Math.abs(Integer.parseInt(a[1]) - Integer.parseInt(a[4])) * 30;
			dias -= Math.abs(Integer.parseInt(a[0]) - Integer.parseInt(a[3]));
			
			System.out.println(dias);
			
		}

		
		System.exit(0);
		teclado.close();

	}
	

}
