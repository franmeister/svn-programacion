import java.util.Scanner;


public class Ejercicio8 {

	public static void main(String[] args) {
		System.out.println("Introduce hora en segundos: ");
		Scanner s = new Scanner(System.in);
		int hora = s.nextInt();
		s.close();
		int hh,mm,ss,res;
		hh=hora/3600;
		res=hora%3600;
		mm=res/60;
		ss=res%60;
		System.out.println(hh+":"+mm+":"+ss);
	}

}

/*Escribir un programa que reciba
una hora en segundos y la saque por
pantalla en el formato “hh:mm:ss”, es decir horas, minutos y segundos*/