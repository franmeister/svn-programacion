package relacion1.agendaDeContactos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class AgendaDeContactos {
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	private BufferedReader flectura;
	private BufferedWriter fescritura;
	private File f,tmp;
	
	public AgendaDeContactos(String ruta){
		f=new File(ruta);
		
		if(!f.exists()||!f.isFile()){
			System.out.println("La dirección introducida no es un fichero.");
			System.exit(0);
		}
		tmp=new File(f.getParent(),"temporal");
	}
	
	private void nuevoContacto(){
		String nombre, direccion, municipio, provincia;
		int cp, telefonoFijo, telefonoMovil;
		
		try {
			System.out.println("Introduce nombre y apellidos: ");
			nombre=teclado.readLine();
			System.out.println("Introduce dirección: ");
			direccion=teclado.readLine();
			System.out.println("Introduce municipio: ");
			municipio=teclado.readLine();
			System.out.println("Introduce provincia: ");
			provincia=teclado.readLine();
			System.out.println("Introduce código postal: ");
			cp=teclado.read();
			System.out.println("Introduce teléfono fijo: ");
			telefonoFijo=teclado.read();
			System.out.println("Introduce teléfono móvil: ");
			telefonoMovil=teclado.read();
		}catch (IOException e) {
			System.out.println("Error al introducir datos.");
			return;
		}

	}
	
	public void menu(){
		int op=0;
		boolean seguir=false;
		
		do{
			System.out.println("1. Añadir Contacto");
			System.out.println("2. Ver Contacto");
			System.out.println("3. Modificar Contacto");
			System.out.println("4. Borrar Contacto");
			System.out.println("5. Listar Contactos");
			System.out.println("6. Salir");
			do{
				try{
					System.out.println("Introduzca una opción:");
					op=Integer.parseInt(teclado.readLine());
					seguir=true;
				}catch (Exception e) {
					System.out.println("Debe de introducir un numero entero");
					seguir=false;
				}
			}while(!seguir);
		
			switch (op) {
			case 1:
				this.nuevoContacto();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.println("Progama terminado.");
				break;
			default:
				System.out.println("Debe introducir un numero entre 1 y 6");
				break;
			}
		}while(op!=6);
	}
}
