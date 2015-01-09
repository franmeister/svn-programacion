public class Contacto {
	private String nombre;
	private int[] telefonos=new int[5];
	private String email;
	private int posicion=0;
	
	public Contacto(String nombre, int telefono) {
		this.nombre = nombre;
		this.telefonos[0] = telefono;
		this.posicion++;
	}
	
	/*public void setEmail(){
		String eMail=PedirDatos.leerCadena("Introduce el e-mail: ");
		
		if(!eMail.matches("^.*@.*$")){
			System.out.println("El email debe de contener el carácter \"@\".");
			return;
		}
		
		this.email = eMail;
		System.out.println("El email ha sido añadido correctamente.");
	}*/
	
	private void setEmail (String eMail){
		if(!eMail.matches("^.*@.*$")){
			System.out.println("El email debe de contener el carácter \"@\".");
			return;
		}
		this.email = eMail;
		System.out.println("El email ha sido añadido correctamente.");
	}
	
	public void setTelefono(int telefono){
		if(this.posicion>5){
			System.out.println("El contacto "+this.nombre+" ya tiene asignados 5 números de teléfono.");
			return;
		}
		this.telefonos[this.posicion] = telefono;
		this.posicion++;
		System.out.println("El teléfono ha sido añadido correctamente.");
	}
	
	private void eliminarTelefono(){
		for(int i=0;i<this.posicion;i++){
			System.out.println(i+". "+this.telefonos[i]);
		}
		
		int pos=PedirDatos.leerEntero("\nIntroduce posición a eliminar: ");
		
		for(int i=pos;i<posicion;i++){
			this.telefonos[i]=this.telefonos[i+1];
		}
		this.posicion--;
	}
	
	private String mostrarTelefonos(){
		String res=this.telefonos[0]+"";
		
		for(int i=1;i<this.posicion;i++){
			res=res+", "+this.telefonos[i];
		}
		
		return res;
	}
	
	public void mostrarContacto(){
		System.out.println("-->Contacto: "+this.nombre);
		if(!this.mostrarTelefonos().equals("0")){
			System.out.println("\t->Teléfonos: "+this.mostrarTelefonos());
		}
		if(this.email!=null){
			System.out.println("\t->E-mail: "+this.email);
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public void menu(){
		int op=-1;
		
		do{
			System.out.println("\n1. Asignar e-mail");
			System.out.println("2. Añadir teléfono");
			System.out.println("3. Eliminar teléfono");
			System.out.println("4. Mostrar contacto");
			System.out.println("5. Salir\n");
			op=PedirDatos.leerEntero("Elija una opción: ");
			
			switch (op) {
			case 1:
				String eMail=PedirDatos.leerCadena("Introduce el e-mail: ");
				this.setEmail(eMail);
				break;
			case 2:
				int tel=PedirDatos.leerEntero("Introduce el teléfono: ");
				this.setTelefono(tel);
				break;
			case 3:
				this.eliminarTelefono();
				break;
			case 4:
				this.mostrarContacto();
				break;
			case 5:
				break;
			default:
				System.out.println("Error. Introduce una opción válida.");
				break;
			}
		}while(op!=5);
	}
	
}
