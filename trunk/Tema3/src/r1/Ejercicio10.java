package r1;

public class Ejercicio10 {

	public static void main(String[] args) {
		int dia = 6, mes = 1;
        
        switch(mes) {           
                case 1: 
                        if (dia>20){
                                System.out.print("Acuario");
                        }else{
                                System.out.print("Capricornio");                              
                        }
                        break;
                case 2:
                        if (dia>19){
                                System.out.print("Piscis");
                        }else{
                                System.out.print("Acuario");
                        }
                        break;
                case 3:
                        if (dia>20){
                                System.out.print("Aries");
                        }else{
                                System.out.print("Piscis");
                        }
                        break;
                case 4:
                        if (dia>20){
                                System.out.print("Tauro");
                        }else{
                                System.out.print("Aries");
                        }
                        break;
                case 5:
                        if (dia>20){
                                System.out.print("Geminis");
                        }else{
                                System.out.print("Tauro");
                        }
                        break;
                case 6:
                        if (dia>20){
                                System.out.print("Cancer");
                        }else{
                                System.out.print("Geminis");
                        }
                        break;
                case 7:
                        if (dia>22){
                                System.out.print("Leo");
                        }else{
                                System.out.print("Cancer");
                        }
                        break;
                case 8:
                        if (dia>22){
                                System.out.print("Virgo");
                        }else{
                                System.out.print("Leo");
                        }
                        break;
                case 9:
                        if (dia>22){
                                System.out.print("Libra");
                        }else{
                                System.out.print("Virgo");
        				}
        				break;
                case 10:
                        if (dia>22){
                                System.out.print("Escorpio");
                        }else{
                                System.out.print("Libra");
                        }
                        break;
                case 11:
                        if (dia>22){
                                System.out.print("Sagitario");
                        }else{
                                System.out.print("Escorpio");
                        }
                        break;
                case 12:
                        if (dia>21){
                                System.out.print("Capricornio");
                        }else{
                                System.out.print("Sagitario");
                        }
                        break;  
        }
	}

}
/* Escribir un programa que reciba la fecha de nacimiento de una persona
e imprima por pantalla su signo zodiacal.*/