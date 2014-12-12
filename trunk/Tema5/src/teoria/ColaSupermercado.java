package teoria;

public class ColaSupermercado {
	private Cliente[] clientes=new Cliente[10];
	private int posicion=0;
	
	public void nuevoCliente(Cliente c){
		if(posicion>=10){
			System.out.println("La cola de la caja esta llena");
			return;
		}
		clientes[posicion]=c;
		posicion++;
	}
	
	public Cliente primerCliente(){
		if(posicion<=0){
			System.out.println("La cola esta vacia");
			return null;
		}
		return clientes[0];
	}
	
	public Cliente pagaCliente(){
		if(posicion<=0){
			System.out.println("La cola esta vacia");
			return null;
		}
		
		Cliente ret=clientes[0];
		for(int i=0;i<posicion;i++){
			clientes[i]=clientes[i+1];
		}
		posicion--; 
		
		return ret;
	}

}
