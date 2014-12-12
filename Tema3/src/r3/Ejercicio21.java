package r3;

public class Ejercicio21 {

	public static void main(String[] args) {
		String cad=PedirDatos.leerCadena("Introduce nombre y apellidos: ");
		String nom=cad.substring(0, 3);
		String ap1="",ap2="";
		
		for(int i=0;i<cad.length();i++){
			if(cad.charAt(i)==' '){
				if(ap1.equals("")){
					ap1=cad.substring(i+1,i+4);
				}else{
					ap2=cad.substring(i+1,i+4);
				}
			}
		}
		System.out.println(ap1+ap2+nom);
	}

}
/* Escribir un programa que sirva para generar códigos de usuario por el
procedimiento siguiente: Tiene que leer el nombre y los dos apellidos de
una persona y devolver un código de usuario formado por las tres
primeras letras del primer apellido, las tres primeras letras del segundo
apellido y las tres primeras letras del nombre. Por ejemplo, si la cadena
de entrada es: “LUIS PEREZ MARTIN” debe devolver “PERMARLUI”.*/