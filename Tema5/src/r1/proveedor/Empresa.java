package r1.proveedor;

public class Empresa {
	private Proveedor[] proveedores= new Proveedor[10000];
	private int codigo=10000;
	private int posicion=0;
	
	public boolean crearProveedor(String nom, String dir, String tel){	// Tipo boolean para comprobar luego si es creado o no
		if(posicion<10000){
			proveedores[posicion]=new Proveedor(this.codigo,nom,dir,tel);
			posicion++;
			codigo++;
			return true;
		}
		return false;
	}
	
	public void listarProveedores(){
		for(int i=0;i<=posicion;i++){
			try{
				System.out.println(proveedores[i].toString());
			}catch(NullPointerException e){}
		}
	}
	
	public Proveedor mostrarProveedor(String nom){
		try{
			return proveedores[this.buscarProveedor(nom)];	
		}catch(Exception e){
			System.out.println("El proveedor "+nom+" no existe.");
		}
		return null;
	}
	
	private int buscarProveedor(String nom){
		for(int i=0;i<=posicion;i++){
			if(proveedores[i].getNombre().equals(nom)){
				return i;
			}

		}
		return -1;
	}
	
	public void borrarProveedor(String nom){
		int borrar=this.buscarProveedor(nom);
		if(borrar>=0){
				for(int i=borrar;i<posicion;i++){
					proveedores[i]=proveedores[i+1];
				}
				posicion--;
		}
	}
	
	public void comprarProveedor(double cantidad, String nom){
		try{
			Proveedor proActu= proveedores[this.buscarProveedor(nom)];
			proActu.setTotal(proActu.getTotal()+cantidad);
			System.out.println("Total actualizado del proveedor "+nom+".");
		}catch(Exception e){
			System.out.println("El proveedor "+nom+" no existe.");
		}
	}
}
