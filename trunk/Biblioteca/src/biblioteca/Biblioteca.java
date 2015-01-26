package biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Biblioteca {
	
	private BufferedReader flectura;
	private BufferedWriter fescritura;
	private File articulos, libros, cdroms, revistas, usuarios, prestamos, directorioPadre;
	private File articulostmp, librostmp, cdromstmp, revistastmp, usuariostmp, prestamostmp;

	public Biblioteca(String ruta){
		directorioPadre=new File(ruta);
		
		if(!directorioPadre.exists()||!directorioPadre.isDirectory()){
			System.out.println("Error. La dirección introducida no es un directorio.");
			System.exit(0);
		}
		
		articulos=new File(ruta,"articulos.txt");
		libros=new File(ruta,"libros.txt");
		cdroms=new File(ruta,"cdroms.txt");
		revistas=new File(ruta,"revistas.txt");
		usuarios=new File(ruta,"usuarios.txt");
		prestamos=new File(ruta,"prestamos.txt");
		articulostmp=new File(ruta,"articulos.txt.tmp");
		librostmp=new File(ruta,"libros.txt.tmp");
		cdromstmp=new File(ruta,"cdroms.txt.tmp");
		revistastmp=new File(ruta,"revistas.txt.tmp");
		usuariostmp=new File(ruta,"usuarios.txt.tmp");
		prestamostmp=new File(ruta,"prestamos.txt.tmp");
	}
	
	
	private Libro crearLibro(){
		String isbn = PedirDatos.leerCadena("Introduce ISBN:");
		String signatura = PedirDatos.leerCadena("Introduce Signatura:");
		String autor = PedirDatos.leerCadena("Introduce Autor:");
		String titulo = PedirDatos.leerCadena("Introduce Título:");
		String materia = PedirDatos.leerCadena("Introduce Materia:");
		String editorial = PedirDatos.leerCadena("Introduce Editorial:");
		return new Libro(isbn.replace(":"," "), signatura.replace(":"," "), titulo.replace(":"," "),
				autor.replace(":"," "), materia.replace(":"," "), editorial.replace(":"," "));
	}
	
	private Articulo crearArticulo(){
		int cod = PedirDatos.leerEntero("Introduce Código del Artículo:");
		String autor = PedirDatos.leerCadena("Introduce Autor:");
		String titulo = PedirDatos.leerCadena("Introduce Título:");
		int numPaginas = PedirDatos.leerEntero("Introduce número de páginas:");
		return new Articulo(cod, titulo.replace(":"," "), autor.replace(":"," "), numPaginas);
	}
	
	private Cdrom crearCdrom(){
		int cod = PedirDatos.leerEntero("Introduce Código del CD-ROM:");
		String signatura = PedirDatos.leerCadena("Introduce Signatura:");
		String autor = PedirDatos.leerCadena("Introduce Autor:");
		String titulo = PedirDatos.leerCadena("Introduce Título:");
		String materia = PedirDatos.leerCadena("Introduce Materia:");
		String editorial = PedirDatos.leerCadena("Introduce Editorial:");
		return new Cdrom(cod, signatura.replace(":"," "), titulo.replace(":"," "), autor.replace(":"," "),
				materia.replace(":"," "), editorial.replace(":"," "));
	}

	private Revista crearRevista(){
		int cod = PedirDatos.leerEntero("Introduce Código de la Revista:");
		String signatura = PedirDatos.leerCadena("Introduce Signatura:");
		String materia = PedirDatos.leerCadena("Introduce Materia:");
		String nombre = PedirDatos.leerCadena("Introduce Nombre:");
		return new Revista(cod, signatura.replace(":"," "), nombre.replace(":"," "), materia.replace(":"," "));
	}
	
	private Usuario crearUsuario(){
		int cod = PedirDatos.leerEntero("Introduce Código del Usuario:");
		String nombre = PedirDatos.leerCadena("Introduce Nombre:");
		String apellido1 = PedirDatos.leerCadena("Introduce Primer Apellido:");
		String apellido2 = PedirDatos.leerCadena("Introduce Segundo Apellido:");
		return new Usuario(cod, nombre.replace(":"," "), apellido1.replace(":"," "), apellido2.replace(":"," "));
	}

	private String componerRegistroLibro(Libro l){
		String registro="";
		
		registro=l.getIsbn()+":"+l.getSignatura()+":"+l.getTitulo()+":"+l.getAutor()+
				":"+l.getMateria()+":"+l.getEditorial();
		
		return registro;
	}
	
	private String componerRegistroArticulo(Articulo a){
		String registro="";
		
		registro=a.getCodArticulo()+":"+a.getTitulo()+":"+a.getAutor()+":"+a.getNumPaginas();
		
		return registro;
	}
	
	private String componerRegistroCdrom(Cdrom c){
		String registro="";
		
		registro=c.getCodCdrom()+":"+c.getSignatura()+":"+c.getTitulo()+":"+c.getAutor()+":"+c.getMateria()+":"+c.getEditorial();
		
		return registro;
	}
	
	private String componerRegistroRevista(Revista r){
		String registro="";
		
		registro=r.getCodRevista()+":"+r.getSignatura()+";"+r.getNombre()+":"+r.getMateria();
		
		return registro;
	}
	
	private String componerRegistroUsuario(Usuario u){
		String registro="";
		
		registro=u.getCodUsuario()+":"+u.getNombre()+":"+u.getApellido1()+":"+u.getApellido2();
				
		return registro;
	}
	
	private void nuevoMaterial(String material){
		switch (material) {
		case "Libro":
			Libro l=this.crearLibro();
			
			try{
				flectura=new BufferedReader(new FileReader(libros));
				fescritura=new BufferedWriter(new FileWriter(librostmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.write(componerRegistroLibro(l));
				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				libros.delete();
				librostmp.renameTo(libros);
			}catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		case "Articulo":
			Articulo a=this.crearArticulo();
			
			try{
				flectura=new BufferedReader(new FileReader(articulos));
				fescritura=new BufferedWriter(new FileWriter(articulostmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.write(componerRegistroArticulo(a));
				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				articulos.delete();
				articulostmp.renameTo(articulos);
			}catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		case "CD-ROM":
			Cdrom c=this.crearCdrom();
			
			try{
				flectura=new BufferedReader(new FileReader(cdroms));
				fescritura=new BufferedWriter(new FileWriter(cdromstmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.write(componerRegistroCdrom(c));
				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				cdroms.delete();
				cdromstmp.renameTo(cdroms);
			}catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		case "Revista":
			Revista r=this.crearRevista();
			
			try{
				flectura=new BufferedReader(new FileReader(revistas));
				fescritura=new BufferedWriter(new FileWriter(revistastmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.write(componerRegistroRevista(r));
				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				revistas.delete();
				revistastmp.renameTo(revistas);
			}catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		case "Usuario":
			Usuario u=this.crearUsuario();
			
			try{
				flectura=new BufferedReader(new FileReader(usuarios));
				fescritura=new BufferedWriter(new FileWriter(usuariostmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.write(componerRegistroUsuario(u));
				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				usuarios.delete();
				usuariostmp.renameTo(usuarios);
			}catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		default:
			break;
		}
	}
	/*
	private int buscar(String material, int cod){
		switch (material) {
		case "Revista":
			for(int i=0;i<revistas.size();i++){
				try{
					if(this.revistas.elementAt(i).getCodRevista()==cod){
						return i;
					}
				}catch(Exception e){}
			}
			break;
		case "CD-ROM":
			for(int i=0;i<cdrom.size();i++){
				try{
					if(this.cdrom.elementAt(i).getCodCdrom()==cod){
						return i;
					}	
				}catch(Exception e){}
			}
			break;
		case "Usuario":
			for(int i=0;i<usuarios.size();i++){
				try{
					if(this.usuarios.elementAt(i).getCodUsuario()==cod){
						return i;
					}	
				}catch(Exception e){}
			}
			break;
		case "Articulo":
			for(int i=0;i<articulos.size();i++){
				try{
					if(this.articulos.elementAt(i).getCodArticulo()==cod){
						return i;
					}	
				}catch(Exception e){}
			}
			break;
		default:
			break;
		}
		return -1;
	}
	
	private int buscarLibro(String isbn){
		for(int i=0;i<libros.size();i++){
			try{
				if(this.libros.elementAt(i).getIsbn().equals(isbn)){
					return i;
				}
			}catch(Exception e){}
		}
		return -1;
	}
	
	private void modificarMaterial(String material){
		int pos;

		if(material.equals("Libro")){
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a modificar: ");
			pos=this.buscarLibro(isbn);
			if(pos==-1){
				System.out.println("No existe el libro con el ISBN "+isbn+".");
				return;
			}
			this.libros.setElementAt(null, pos); //para poder usar el ISBN del libro que va a ser modificado
			this.libros.setElementAt(crearLibro(),pos);
			return;
		}
		int codigo=PedirDatos.leerEntero("Introduce el código del "+material+" a modificar: ");
		pos=this.buscar(material,codigo);
		if(pos==-1){
			System.out.println("No existe "+material+" con el código "+codigo+".");
			return;
		}
		switch (material) {
		case "Articulo":
			this.articulos.setElementAt(null,pos);
			this.articulos.setElementAt(crearArticulo(),pos);
			break;
		case "CD-ROM":
			this.cdrom.setElementAt(null,pos);
			this.cdrom.setElementAt(crearCdrom(),pos);
			break;
		case "Revista":
			this.revistas.setElementAt(null,pos);
			this.revistas.setElementAt(crearRevista(),pos);
			break;
		case "Usuario":
			this.usuarios.setElementAt(null,pos);
			this.usuarios.setElementAt(crearUsuario(),pos);
			break;
		default:
			break;	
		}
	}
	
	private void borrarMaterial(String material){
		int pos;

		if(material.equals("Libro")){
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a borrar: ");
			pos=this.buscarLibro(isbn);
			if(pos==-1){
				System.out.println("No existe el libro con el ISBN "+isbn+".");
				return;
			}
			this.libros.remove(pos);
			return;
		}
		int codigo=PedirDatos.leerEntero("Introduce el código del "+material+" a borrar: ");
		pos=this.buscar(material,codigo);
		if(pos==-1){
			System.out.println("No existe "+material+" con el código "+codigo+".");
			return;
		}
		switch (material) {
		case "Articulo":
			this.articulos.remove(pos);
			break;
		case "CD-ROM":
			this.cdrom.remove(pos);
			break;
		case "Revista":
			this.revistas.remove(pos);
			break;
		case "Usuario":
			this.usuarios.remove(pos);
			break;
		default:
			break;	
		}
	}
	
	private Calendar fechaActual(){
		 Calendar c = Calendar.getInstance();
	     return c;
	}
	
	private int estaPrestado(String material, String cod){
		try{
			for(int i=0;i<this.prestamos.length;i++){
				if(this.prestamos[i].getCodMaterial().equals(cod) && this.prestamos[i].getFechaDevolucion()==null){
					return i;
				}
			}
		}catch(Exception e){}
		return -1;
	}
	*/
	private void prestarMaterial(String material){
		int pos;
		int usuario=PedirDatos.leerEntero("Introduce el código del usuario");
		
		pos=this.buscar("Usuario", usuario);
		if(pos==-1){
			System.out.println("No existe el usuario con código "+usuario+".");
			return;
		}
		
		if(material.equals("Libro")){
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a prestar: ");
			pos=this.buscarLibro(isbn);
			if(pos==-1){
				System.out.println("No existe el libro con el ISBN "+isbn+".");
				return;
			}
			if(this.estaPrestado(material, isbn)!=-1){
				System.out.println("El libro está prestado.");
				return;
			}
			this.prestamos[posicion]=new Prestamo(usuario, isbn, material, fechaActual());
			this.posicion++;
			return;
		}
		
		int codigo=PedirDatos.leerEntero("Introduce el código del "+material+" a prestar: ");
		pos=this.buscar(material,codigo);
		if(pos==-1){
			System.out.println("No existe "+material+" con el código "+codigo+".");
			return;
		}
		if(this.estaPrestado(material, codigo+"")!=-1){
			System.out.println("El "+material+" está prestado.");
			return;
		}
		this.prestamos[posicion]=new Prestamo(usuario, codigo+"", material, fechaActual());
		this.posicion++;
	}
	/*
	private void devolverMaterial(String material){
		int pos;

		if(material.equals("Libro")){
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a devolver: ");
			pos=this.buscarLibro(isbn);
			if(pos==-1){
				System.out.println("No existe el libro con el ISBN "+isbn+".");
				return;
			}
			pos=this.estaPrestado(material, isbn);
			if(pos==-1){
				System.out.println("El libro no está prestado.");
				return;
			}
			this.prestamos[pos].setFechaDevolucion(fechaActual());
			return;
		}
			
		int codigo=PedirDatos.leerEntero("Introduce el código del "+material+" a prestar: ");
		pos=this.buscar(material,codigo);
		if(pos==-1){
			System.out.println("No existe "+material+" con el código "+codigo+".");
			return;
		}
		pos=this.estaPrestado(material, codigo+"");
		if(pos!=-1){
			this.prestamos[pos].setFechaDevolucion(fechaActual());
		}
	}
		*/
	private void realizarPrestamo(){
		int op=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Libro");
			System.out.println("2.Revista");
			System.out.println("3.Artículo");
			System.out.println("4.CD-ROM");
			System.out.println("0.Volver al menú principal");
			op=PedirDatos.leerEntero("Introduce material a prestar");
			
			switch (op) {
			case 0:
				break;
			case 1:
				this.prestarMaterial("Libro");
				break; 
			case 2:
				this.prestarMaterial("Revista");
				break;
			case 3:
				this.prestarMaterial("Articulo");
				break;
			case 4:
				this.prestarMaterial("CD-ROM");
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(op!=0);
		
	}
	
	private void devolverPrestamo(){
		int op=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Libro");
			System.out.println("2.Revista");
			System.out.println("3.Artículo");
			System.out.println("4.CD-ROM");
			System.out.println("0.Volver al menú principal");
			op=PedirDatos.leerEntero("Introduce material a devolver");
			
			switch (op) {
			case 0:
				break;
			case 1:
				this.devolverMaterial("Libro");
				break;
			case 2:
				this.devolverMaterial("Revista");
				break;
			case 3:
				this.devolverMaterial("Articulo");
				break;
			case 4:
				this.devolverMaterial("CD-ROM");
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(op!=0);
		
	}
	
	private void menuMaterial(String material){
		int opcion=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Nuevo "+material);
			System.out.println("2.Modificar "+material);
			System.out.println("3.Borrar "+material);
			System.out.println("0.Volver al menú principal");
			
			opcion=PedirDatos.leerEntero("Elija una opcion:");
			
			switch (opcion) {
			case 0:
				break;
			case 1:
				this.nuevoMaterial(material);
				break;
			case 2:
				//this.modificarMaterial(material);
				break;
			case 3:
				//this.borrarMaterial(material);
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(opcion!=0);
	}
	
	public void menu(){
		int opcion=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Gestión de Libros");
			System.out.println("2.Gestión de Revistas");
			System.out.println("3.Gestión de CD-ROM");
			System.out.println("4.Gestión de Articulos");
			System.out.println("5.Gestión de Usuarios");
			System.out.println("6.Realizar Préstamo");
			System.out.println("7.Devolver Préstamo");
			System.out.println("0.Salir");
			
			opcion=PedirDatos.leerEntero("Elija una opcion:");
	
			switch (opcion) {
			case 0:
				System.out.println("Programa terminado.");
				break;
			case 1:
				this.menuMaterial("Libro");
				break;
			case 2:
				this.menuMaterial("Revista");
				break;
			case 3:
				this.menuMaterial("CD-ROM");
				break;
			case 4:
				this.menuMaterial("Articulo");
				break;
			case 5:
				this.menuMaterial("Usuario");
				break;
			case 6:
				this.realizarPrestamo();
				break;
			case 7:
				//this.devolverPrestamo();
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(opcion!=0);
	}
}