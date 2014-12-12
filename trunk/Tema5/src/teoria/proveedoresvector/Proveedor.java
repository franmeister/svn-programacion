package teoria.proveedoresvector;

public class Proveedor {

	int codigo;
	String nombre;
	String direccion;
	String telefono;
	double total;
	public Proveedor(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	public Proveedor(int codigo, String nombre, String direccion,
			String telefono) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public int getCodigo(){
		return codigo;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setTotal(double importe){
		this.total=this.total+importe;
	}
	
	public double getTotal(){
		return this.total;
	}
	
	
	public boolean equals(Proveedor p) {
		if (codigo != p.codigo)
			return false;
		if (direccion == null) {
			if (p.direccion != null)
				return false;
		} else if (!direccion.equals(p.direccion))
			return false;
		if (nombre == null) {
			if (p.nombre != null)
				return false;
		} else if (!nombre.equals(p.nombre))
			return false;
		if (telefono == null) {
			if (p.telefono != null)
				return false;
		} else if (!telefono.equals(p.telefono))
			return false;

		return true;
	}
	
	@Override
	public String toString() {
		String cad="Proveedor Nº" + codigo + " - " + nombre;
		if(direccion!=null){
			cad=cad+ "\n" + direccion;
		}
		if(telefono!=null){
			cad=cad+ "\n" + telefono;
		}
		cad=cad+ "\nTotal " + this.total;
		
				 
		return cad;
	}
	
	
	
}
