package relacion1.agendaDeContactos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
		Contacto c=componerContacto();
		
		try {
			flectura=new BufferedReader(new FileReader(f));
			fescritura=new BufferedWriter(new FileWriter(tmp));
			
			String linea=flectura.readLine();
			while(linea!=null){
				fescritura.write(linea);
				fescritura.newLine();
				linea=flectura.readLine();
			}
			
				fescritura.write(componerRegistro(c));
				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				f.delete();
				tmp.renameTo(f);
		} catch (IOException e) {
			System.out.println("Error al manejar ficheros.");
		}

	}
	
	private String componerRegistro(Contacto c){
		String registro="";
		
		registro=c.getNombre()+":"+c.getDireccion()+":"+c.getMunicipio()+":"+c.getProvincia()
				+":"+ c.getCp()+":"+c.getTelefonoFijo()+":"+c.getTelefonoMovil();
		
		return registro;
	}
	
	private void listarContactos(){
		try {
			flectura=new BufferedReader(new FileReader(f));
			String linea=flectura.readLine();
			while(linea!=null){
				System.out.println(descomponerRegistro(linea).toString()+"\n");
				linea=flectura.readLine();
			}
			flectura.close();
		} catch (IOException e) {
			System.out.println("Error al manejar ficheros.");
		}

	}
	
	private Contacto descomponerRegistro(String linea){
		String[] registro=new String[7];
		registro=linea.split(":");
		return new Contacto(registro[0], registro[1], registro[2], registro[3], registro[4], registro[5], registro[6]);
	}
	
	private void verContacto(String nombre){
		try {
			flectura=new BufferedReader(new FileReader(f));
			String linea=flectura.readLine();
			while(linea!=null){
				Contacto c=descomponerRegistro(linea);
				if(c.getNombre().toLowerCase().equals(nombre.toLowerCase())){
					System.out.println(c.toString());
					break;
				}
				linea=flectura.readLine();
			}
			flectura.close();
		} catch (IOException e) {
			System.out.println("Error al manejar ficheros.");
		}
	}
	
	private Contacto componerContacto(){
		String nom, direccion, municipio, provincia, cp, telefonoFijo, telefonoMovil;
		
		try {
			System.out.println("Introduce nombre y apellidos: ");
			nom=teclado.readLine();
			System.out.println("Introduce dirección: ");
			direccion=teclado.readLine();
			System.out.println("Introduce municipio: ");
			municipio=teclado.readLine();
			System.out.println("Introduce provincia: ");
			provincia=teclado.readLine();
			System.out.println("Introduce código postal: ");
			cp=teclado.readLine();
			System.out.println("Introduce teléfono fijo: ");
			telefonoFijo=teclado.readLine();
			System.out.println("Introduce teléfono móvil: ");
			telefonoMovil=teclado.readLine();
		}catch (IOException e) {
			System.out.println("Error al introducir datos.");
			return null;
		}
		
		return new Contacto(nom, direccion, municipio, provincia, cp, telefonoFijo, telefonoMovil);
	}
	
	private String pedirNombre(){
		String nombre="";
		try {
			System.out.println("Introduzca el nombre de contacto: ");
			nombre = teclado.readLine();
		} catch (IOException e) {
			System.out.println("Error al introducir datos.");
		}
		return nombre;
	}
	
	private void modificarContacto(String nombre){
		try {
			flectura=new BufferedReader(new FileReader(f));
			fescritura=new BufferedWriter(new FileWriter(tmp));
			String linea=flectura.readLine();
			
			while(linea!=null){
				Contacto c=descomponerRegistro(linea);
				if(!c.getNombre().toLowerCase().equals(nombre.toLowerCase())){
					fescritura.write(linea);
					fescritura.newLine();
				}else{
					Contacto con=componerContacto();
					fescritura.write(componerRegistro(con));
					fescritura.newLine();
				}
				linea=flectura.readLine();
			}
		fescritura.flush();
		fescritura.close();
		flectura.close();
		
		f.delete();
		tmp.renameTo(f);
		} catch (IOException e) {
			System.out.println("Error al manejar ficheros.");
		}
	}
	
	private void borrarContacto(String nombre){
		try {
			flectura=new BufferedReader(new FileReader(f));
			fescritura=new BufferedWriter(new FileWriter(tmp));
			String linea=flectura.readLine();
			
			while(linea!=null){
				Contacto c=descomponerRegistro(linea);
				if(!c.getNombre().toLowerCase().equals(nombre.toLowerCase())){
					fescritura.write(linea);
					fescritura.newLine();
				}
				linea=flectura.readLine();
			}
		fescritura.flush();
		fescritura.close();
		flectura.close();
		
		f.delete();
		tmp.renameTo(f);
		} catch (IOException e) {
			System.out.println("Error al manejar ficheros.");
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
				this.verContacto(this.pedirNombre());
				break;
			case 3:
				this.modificarContacto(this.pedirNombre());
				break;
			case 4:
				this.borrarContacto(this.pedirNombre());
				break;
			case 5:
				this.listarContactos();
				break;
			case 6:
				System.out.println("Programa terminado.");
				break;
			default:
				System.out.println("Debe introducir un numero entre 1 y 6");
				break;
			}
		}while(op!=6);
	}
}
