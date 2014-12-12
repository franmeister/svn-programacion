package r1.pilaenteros;

public class PilaDeEnteros {
	private int[] pila=new int[100];
	private int posicion=0;
	
	public void push(int num){
		if(estaLlena()){
			return;
		}
		pila[posicion]=num;
		posicion++;
	}
	
	public int pop(){
		if(posicion<=0){
			System.out.println("La pila está vacia");
			return 0;
		}
		posicion--;
		return pila[posicion];
	}
	
	public int peek(){
		if(posicion<=0){
			System.out.println("La pila está vacia");
			return 0;
		}
		return pila[posicion-1];
	}
	
	public boolean estaLlena(){
		if(posicion>=100){
			System.out.println("La pila está llena");
			return true;
		}
		return false;
	}
	
	public int buscar(int num){
		for(int i=0;i<posicion;i++){
			if(pila[i]==num){
				System.out.println("El valor "+num+" está en la posicion "+i+" de la pila");
				return i;
			}
		}
		System.out.println("El valor "+num+" no está en la pila");
		return 0;
	}
	
	public int getValorPila(int posicion){
		if(posicion<=this.posicion){
			return pila[posicion];
		}
		return 0;
		
	}
}
