package teoria;

public class Caja {
	private int num_caja;
	private double peso;
	
	public Caja(int nCaja, double peso){
		this.num_caja = nCaja;
		this.peso = peso;
	}

	public String toString() {
		return "Caja número " + num_caja + " --> "+ peso + "kg";
	}
	
	
}
