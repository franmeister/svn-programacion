package r3;

public class Ejercicio9 {

	public static void main(String[] args) {
		int mon,premio;
		int apu=PedirDatos.leerEntero("Introduce apuesta: ");
		
		mon=(int) (Math.random()*2);
		// mon= (int) (Math.round(Math.random()));
		
		if (mon==1){
			premio=apu*2;
		}else{
			premio=0;
		}
		
		System.out.print("El premio es: "+premio);
		
	}

}
/* Escribir un programa que permita jugar a doble o nada: El jugador
apuesta una cantidad y tira una moneda. Si sale cara obtiene el doble de
la cantidad apostada. Si sale cruz la pierde todo.*/
