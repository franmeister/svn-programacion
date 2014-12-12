package r1.proveedor;

public class Proveedor {
	private int cod;
	private String nombre;
	private String direccion;
	private String telefono;
	private double total;
	
	/*public Proveedor(int cod, String nom){
		this.cod=cod;
		this.nombre=nom;
	}*/
	
	public Proveedor(int cod, String nom, String dir, String tel){
		this.cod=cod;
		this.nombre=nom;
		this.direccion=dir;
		this.telefono=tel;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total+= total;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Proveedor Nº " + cod + " - " + nombre + "\n\n"
				+ direccion + "\nTel. " + telefono+"\n";
		
	}
	
	
}
