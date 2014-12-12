package r1;

public class Ejercicio2 {

	public static void main(String[] args) {
		int nota=6, edad=22;
		char gen='V';
		
		if (nota>=5 && edad>=18){
			if (gen=='V'){
				System.out.print("POSIBLE");
			}else if (gen=='M'){
				System.out.print("ACEPTADA");
			}
		}
			
	}

}
/* Escribe un programa que pida dos números 'nota' y 'edad' y un carácter
'sexo' y muestre el mensaje 'ACEPTADA' si la nota es mayor o igual a
cinco, la edad es mayor o igual a dieciocho y el sexo es 'M'. En caso de
que se cumpla lo mismo, pero el sexo sea 'V', debe imprimir 'POSIBLE'.*/