package r1.colaEnteros;

public class Cola {
	private int pos=0;
	private int[] cola=new int[100];
	
	public Cola crear(){
		return new Cola();
	}
	
	public void encolar(int num){
		if(pos<100){
			cola[pos]=num;
			pos++;
			return;
		}
		System.out.println("La cola está llena.");
	}
	
	public int desencolar(){
		int n=cola[0];
		if(!estaVacia()){
			pos--;
			for(int i=0;i<pos;i++){
				cola[i]=cola[i+1];
			}
		}
		return n;		//si la cola está vacía cola[0] devuelve 0	
	}
	
	public int frente(){
		estaVacia();
		return cola[0];		//si la cola está vacía cola[0] devuelve 0	
	}
	
	private boolean estaVacia(){
		if(pos<=0){
			System.out.println("La cola está vacía.");
			return true;
		}
		return false;
	}
}
