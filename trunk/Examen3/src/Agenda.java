import java.util.Vector;

public class Agenda {
	private Vector<Contacto> contactos=new Vector<Contacto>();
	
	private int buscarContacto(String nombre){
		for(int i=0;i<=this.contactos.size();i++){
			try{
				if(contactos.elementAt(i).getNombre().equals(nombre)){
					return i;
				}
			}catch(Exception e){}
		}
		return -1;
	}
	
	private void addContacto(){
		String nombre=PedirDatos.leerCadena("Introduce nombre: ");
		int telefono=PedirDatos.leerEntero("Introduce número de telefono: ");
		int pos=this.buscarContacto(nombre);
		
		if(pos==-1){
			this.contactos.add(new Contacto(nombre, telefono));
			return;
		}
		
		this.contactos.elementAt(pos).setTelefono(telefono);
	}
	
	private void verContacto(){
		String nombre=PedirDatos.leerCadena("Introduce nombre del contacto: ");
		int pos=this.buscarContacto(nombre);

		if(pos==-1){
			System.out.println("El contacto con el nombre "+nombre+" no existe.");
			return;
		}
		
		this.contactos.elementAt(pos).mostrarContacto();
	}
	
	private void delContacto(){
		String nombre=PedirDatos.leerCadena("Introduce nombre del contacto: ");
		int pos=this.buscarContacto(nombre);

		if(pos==-1){
			System.out.println("El contacto con el nombre "+nombre+" no existe.");
			return;
		}
		
		this.contactos.remove(pos);
		System.out.println("El contacto con el nombre "+nombre+" se ha eliminado.");
	}
	
	private void setContacto(){
		String nombre=PedirDatos.leerCadena("Introduce nombre del contacto: ");
		int pos=this.buscarContacto(nombre);

		if(pos==-1){
			System.out.println("El contacto con el nombre "+nombre+" no existe.");
			return;
		}
		
		this.contactos.elementAt(pos).menu();
	}
	
	private void listarContactos(){
		for(int i=0;i<=this.contactos.size();i++){
			try{
				contactos.elementAt(i).mostrarContacto();
			}catch(Exception e){}
		}
	}
	
	public void menu(){
		int op=-1;
		
		do{
			System.out.println("\n1. Añadir contacto");
			System.out.println("2. Mostrar contacto");
			System.out.println("3. Borrar contacto");
			System.out.println("4. Modificar contacto");
			System.out.println("5. Listar contactos");
			System.out.println("6. Salir");
			op=PedirDatos.leerEntero("Elija una opción: ");
			
			switch (op) {
			case 1:
				this.addContacto();
				break;
			case 2:
				this.verContacto();
				break;
			case 3:
				this.delContacto();
				break;
			case 4:
				this.setContacto();
				break;
			case 5:
				this.listarContactos();
				break;
			case 6:
				break;
			default:
				System.out.println("Error. Introduce una opción válida.");
				break;
			}
		}while(op!=6);
	}
		
	

}
