package agendacontactos;

import java.io.*;

public class Agenda {
	BufferedReader teclado = new BufferedReader(
			new InputStreamReader(System.in));
	BufferedReader flectura;
	BufferedWriter fescritura;
	File f, ftmp;

	public Agenda(File f) {
		this.f = f;
		this.ftmp = new File(f.getParent(), "temporal.txt");

	}

	private String addEspacios(String cadena, int longitud){
		String cad="";
		
		for (int i=cadena.length();i<longitud;i++){
			cad=cad+" ";
		}
		
		cad=cadena+cad;
		cad=cad.substring(0,longitud);
		return cad;
		
	}
	
	private String componerLinea(Contacto c){
		
		String linea;
		
		linea=addEspacios(c.getNombre(), 60);
		linea=linea+addEspacios(c.getDireccion(), 40);
		linea=linea+addEspacios(c.getCP(), 5);
		linea=linea+addEspacios(c.getMunicipio(), 30);
		linea=linea+addEspacios(c.getProvincia(), 15);
		linea=linea+addEspacios(c.getTelfijo(), 9);
		linea=linea+addEspacios(c.getTelmovil(), 9);
		return linea;
	}
	
	private Contacto descomponerLinea (String linea){
		Contacto c=new Contacto();
		c.setNombre(linea.substring(0, 60).trim());
		c.setDireccion(linea.substring(60, 100).trim());
		c.setCP(linea.substring(100, 105).trim());
		c.setMunicipio(linea.substring(105, 135).trim());
		c.setProvincia(linea.substring(135, 150).trim());
		c.setTelfijo(linea.substring(150, 159).trim());
		c.setTelmovil(linea.substring(159, 168).trim());
		return c;
	}
	
	private void nuevoContacto() {
		
		String linea;
		Contacto c = new Contacto();
		c.pedirContacto();
		try {
			RandomAccessFile fichero=new RandomAccessFile(this.f, "rw");
			fichero.seek(fichero.length());
			//Introducimos el nuevo contacto
			linea="\r\n"+componerLinea(c);
			fichero.writeUTF(linea); 
			
			//fichero.close();
			
			//fichero=new RandomAccessFile(this.f, "rw");
			fichero.seek(0);
			String cadena=fichero.readLine();
			System.out.println(cadena);
		} catch (IOException e) {
			System.out.println("Consulte con Antonio");
		}
	}

	private void addContacto() {
		
		String linea;
		Contacto c = new Contacto();
		c.pedirContacto();
		try {
			flectura = new BufferedReader(new FileReader(f));
			fescritura = new BufferedWriter(new FileWriter(ftmp));
			linea=flectura.readLine();
			while (linea!=null) {
				fescritura.write(linea);
				fescritura.newLine();
				linea=flectura.readLine();
				
			}
			//Introducimos el nuevo contacto
			linea=componerLinea(c);
			fescritura.write(linea);
			fescritura.newLine();
			fescritura.flush();
			flectura.close();
			fescritura.close();
			
			f.delete();
			ftmp.renameTo(f);
		} catch (IOException e) {
			System.out.println("Consulte con Antonio");
		}
	}

	private void verContacto(){

		try {
			System.out.println("Introduzca el nombre del contacto a buscar.");
			String nombre = teclado.readLine();
			flectura=new BufferedReader(new FileReader(f));
			
			String linea=flectura.readLine();
			while (linea != null){
				//Descomponemos la línea	
				Contacto c=descomponerLinea(linea);
				if (c.getNombre().equals(nombre)){
					System.out.println(c);
					break;
				}
				linea=flectura.readLine();
			}
			flectura.close();
			
		}catch (IOException e){
			System.out.println("Consulte con Antonio.");
		}
		
	}
	private void modificarContacto(){
		Contacto c;
		Contacto contacto=new Contacto();
		contacto.pedirContacto();
		
		try {
			flectura=new BufferedReader (new FileReader(f));
			fescritura= new BufferedWriter(new FileWriter(ftmp));
			String linea=flectura.readLine();
			while (linea!=null){
				c= descomponerLinea(linea);
				if(c.getNombre().equals(contacto.getNombre())){
					linea=componerLinea(contacto);
				}
				fescritura.write(linea);
				fescritura.newLine();
				linea=flectura.readLine();
			}
			fescritura.flush();
			flectura.close();
			fescritura.close();
			f.delete();
			ftmp.renameTo(f);
					
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	
	private void borrarContacto(){
		Contacto c;
		try{
			System.out.println("Introduzca el contacto a borrar");
			String nombre=teclado.readLine();
			flectura=new BufferedReader(new FileReader(f));
			fescritura=new BufferedWriter(new FileWriter(ftmp));
			String linea= flectura.readLine();
			
			while(linea!=null){
				c=descomponerLinea(linea);
				if(!nombre.equals(c.getNombre())){
					fescritura.write(linea);
					fescritura.newLine();
				}
				linea=flectura.readLine();
			}
			
			fescritura.flush();
			fescritura.close();
			flectura.close();
			
			f.delete();
			ftmp.renameTo(f);
			
		}catch(IOException e){
			System.out.println("Consulte con Antonio.");
		}
		
	}
	private void listarContactos(){
		Contacto c;
		try{
			flectura=new BufferedReader(new FileReader(f));
			String linea=flectura.readLine();
			while (linea!=null){
				c=descomponerLinea(linea);
				System.out.println(c);
				System.out.println("------------------------");
				linea=flectura.readLine();
	
			}
			flectura.close();
		}catch(IOException e){
			System.out.println("Consulte con el administrador");
		}
	}
	
	public void menu() {
		int opcion = 0;
		boolean seguir = true;

		do {
			System.out.println("1.Añadir Contacto");
			System.out.println("2.Ver un Contacto");
			System.out.println("3.Modificar un contacto");
			System.out.println("4.Borrar un Contacto");
			System.out.println("5.Listar todos los Contactos");
			System.out.println("6.salir");
			do {
				try {
					System.out.println("Introduzca una opción:");
					opcion = Integer.parseInt(teclado.readLine());
					seguir = true;
				} catch (Exception e) {
					System.out.println("Debe de introducir un numero entero");
					seguir = false;
				}
			} while (!seguir);

			switch (opcion) {
			case 1:
				this.nuevoContacto();
				//addContacto();
				break;
			case 2:
				verContacto();
				break;
			case 3:
				modificarContacto();
				break;
			case 4:
				borrarContacto();
				break;
			case 5:
				listarContactos();
				break;
			case 6:
				System.out.println("Adios!!!");
				break;
			default:
				System.out.println("Debe introducir un numero entre 1 y 6");
				break;
			}

		} while (opcion != 6);
	}

}
