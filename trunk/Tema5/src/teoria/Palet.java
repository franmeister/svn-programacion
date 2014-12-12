package teoria;

public class Palet {
	private Caja[] p=new Caja[50];
	private int posicion=0;

	public void ponerCaja(Caja c){
		if(!this.estaLleno()){
			p[posicion]=c;
			this.posicion++;
			return;
		}
	}
	
	public void sacarCaja(int n){
		if(!this.estaVacio()){
			posicion--;
			for(int i=n;i<posicion;i++){
				p[i]=p[i+1];
			}
		}
	}
	
	public Caja verCajaSuperior(){
		if(!estaVacio()){
			return p[posicion-1];
		}
		return null;
	}
	
	public boolean estaLleno(){
		if(this.posicion>=50){
			System.out.println("El palet está lleno.");
			return true;
		}
		return false;
	}
	
	public boolean estaVacio(){
		if(this.posicion<=0){
			System.out.println("El palet está vacío.");
			return true;
		}
		return false;
	}
}
