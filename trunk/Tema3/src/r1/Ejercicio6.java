package r1;

public class Ejercicio6 {

	public static void main(String[] args) {
		char let='A';
		
		if ((let=='a') || (let=='A') || (let=='e') || (let=='E') || (let=='i') || (let=='I') ||(let=='o') || (let=='O') || (let=='u') || (let=='U')){
			System.out.print(let+" es vocal.");
		}else{
			System.out.print(let+" es consonante.");
		}
	}

}
/* Algoritmo que pida una letra e imprima si es vocal o consonante.*/