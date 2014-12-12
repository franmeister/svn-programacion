package r3;

public class Ejercicio15 {

	public static void main(String[] args) {
		int mon, premio=0, i=0, banca=0;
		int apu=PedirDatos.leerEntero("Introduce apuesta: ");
		char car;
		boolean ant=false;
		
		do{
			mon=(int) (Math.random()*2);
		
			if(ant==false){
				banca+=apu;
			}
			
			if (mon==1){
				premio=apu*2;
				System.out.println("Ganaste!");
				if (i==0){
					banca=apu;	// Para guardar la catidad que el jugador debe de pagar a la banca por la primera apuesta
				}
				ant=true;
			}else{
				System.out.println("Lo has perdido todo!");
				premio=0;
				ant=false;
			}
			
			/* Mostrar los datos de cada iteración */
			System.out.println("Premio actual: "+premio+" Debes a la banca: "+banca);
			/* */
			
			try{
				car=PedirDatos.leerCaracter("Si quieres jugar doble o nada pulsa s.");
			}catch(Exception e){	// Controlar error al introducir 'tecla return'
				car='a';
			}
			apu*=2;		// Es un doble o nada, la cantidad que se apuesta por cada iteración va a ser el doble de la anterior apuesta
			i++;
		}while (car=='s');
		System.out.print("Has jugado "+i+" veces. El premio es: "+premio+", le debes a la banca "+Math.abs(banca)+", ganas "+(premio-banca)+".");
		
	}

}
/* Modificar el programa del juego a doble o nada para que permita ir
jugando hasta que el jugador decida abandonar el juego. El programa
debe sacar por pantalla el número de jugadas y el total ganado por el
jugador (si ha perdido debe ser una cantidad negativa).*/