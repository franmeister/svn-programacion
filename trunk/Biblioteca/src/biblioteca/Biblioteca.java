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
		return new Libro(isbn.replace("::"," "), signatura.replace("::"," "), titulo.replace("::"," "),
				autor.replace("::"," "), materia.replace("::"," "), editorial.replace("::"," "));
	}
	
	private Articulo crearArticulo(){
		int cod = PedirDatos.leerEntero("Introduce Código del Artículo:");
		String autor = PedirDatos.leerCadena("Introduce Autor:");
		String titulo = PedirDatos.leerCadena("Introduce Título:");
		int numPaginas = PedirDatos.leerEntero("Introduce número de páginas:");
		return new Articulo(cod, titulo.replace("::"," "), autor.replace("::"," "), numPaginas);
	}
	
	private Cdrom crearCdrom(){
		int cod = PedirDatos.leerEntero("Introduce Código del CD-ROM:");
		String signatura = PedirDatos.leerCadena("Introduce Signatura:");
		String autor = PedirDatos.leerCadena("Introduce Autor:");
		String titulo = PedirDatos.leerCadena("Introduce Título:");
		String materia = PedirDatos.leerCadena("Introduce Materia:");
		String editorial = PedirDatos.leerCadena("Introduce Editorial:");
		return new Cdrom(cod, signatura.replace("::"," "), titulo.replace("::"," "), autor.replace("::"," "),
				materia.replace("::"," "), editorial.replace("::"," "));
	}

	private Revista crearRevista(){
		int cod = PedirDatos.leerEntero("Introduce Código de la Revista:");
		String signatura = PedirDatos.leerCadena("Introduce Signatura:");
		String materia = PedirDatos.leerCadena("Introduce Materia:");
		String nombre = PedirDatos.leerCadena("Introduce Nombre:");
		return new Revista(cod, signatura.replace("::"," "), nombre.replace("::"," "), materia.replace("::"," "));
	}
	
	private Usuario crearUsuario(){
		int cod = PedirDatos.leerEntero("Introduce Código del Usuario:");
		String nombre = PedirDatos.leerCadena("Introduce Nombre:");
		String apellido1 = PedirDatos.leerCadena("Introduce Primer Apellido:");
		String apellido2 = PedirDatos.leerCadena("Introduce Segundo Apellido:");
		return new Usuario(cod, nombre.replace("::"," "), apellido1.replace("::"," "), apellido2.replace("::"," "));
	}

	private String componerRegistroLibro(Libro l){
		String registro="";
		
		registro=l.getIsbn()+"::"+l.getSignatura()+"::"+l.getTitulo()+"::"+l.getAutor()+
				"::"+l.getMateria()+"::"+l.getEditorial();
		
		return registro;
	}
	
	private String componerRegistroArticulo(Articulo a){
		String registro="";
		
		registro=a.getCodArticulo()+"::"+a.getTitulo()+"::"+a.getAutor()+"::"+a.getNumPaginas();
		
		return registro;
	}
	
	private String componerRegistroCdrom(Cdrom c){
		String registro="";
		
		registro=c.getCodCdrom()+"::"+c.getSignatura()+"::"+c.getTitulo()+"::"+c.getAutor()+"::"+c.getMateria()+"::"+c.getEditorial();
		
		return registro;
	}
	
	private String componerRegistroRevista(Revista r){
		String registro="";
		
		registro=r.getCodRevista()+"::"+r.getSignatura()+"::"+r.getNombre()+"::"+r.getMateria();
		
		return registro;
	}
	
	private String componerRegistroUsuario(Usuario u){
		String registro="";
		
		registro=u.getCodUsuario()+"::"+u.getNombre()+"::"+u.getApellido1()+"::"+u.getApellido2();
				
		return registro;
	}
	
	public String componerRegistroPrestamo(Prestamo p){
		String registro="";
		
		registro=p.getCodUsuario()+"::"+p.getCodMaterial()+"::"+p.getMaterial()+"::"+p.getFechaPrestamo()+"::";
		
		try{
				registro+=p.getFechaDevolucion();
		}catch(Exception e){}
				
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
	*/
	private String fechaActual(){
		 Calendar c = Calendar.getInstance();
	     return c.getTime()+"";
	}
	
	private void registrarPrestamo(Prestamo p){
		try{
			flectura=new BufferedReader(new FileReader(prestamos));
			fescritura=new BufferedWriter(new FileWriter(prestamostmp));
		
			String linea=flectura.readLine();
			while(linea!=null){
				fescritura.write(linea);
				fescritura.newLine();
				linea=flectura.readLine();
			}
			fescritura.write(componerRegistroPrestamo(p));
			fescritura.flush();
			fescritura.close();
			flectura.close();
			
			prestamos.delete();
			prestamostmp.renameTo(prestamos);	
		} catch (IOException e) {
			System.out.println("Error al manejar ficheros.");
		}
	}

	private boolean estaPrestado(Prestamo p){
		String[] registro=new String[5];
		String linea;

		try {
			flectura=new BufferedReader(new FileReader(prestamos));
			linea=flectura.readLine();
			while(linea!=null){
				registro=linea.split("::");
				if(registro[1].equals(p.getCodMaterial()) && registro[2].equals(p.getMaterial())){
					try{
						registro[4]=registro[4];	//Para que salte el error si la fecha devolución está vacía
					}catch(Exception e){
						flectura.close();
						return true;
					}
				}
				linea=flectura.readLine();
			}
			flectura.close();	//Cierro para que a continuación vuelva a leer desde la 1º línea
		}catch (IOException e) {
			System.out.println("Error al manejar ficheros.");
		}
		return false;
	}
	
	private void prestarMaterial(String material){
		int codigo;
		int usuario=PedirDatos.leerEntero("Introduce el código del usuario");
		boolean existeUsu=false, existeMat=false;
		String[] registro=new String[6];
		Prestamo p;
		
		try {
			flectura=new BufferedReader(new FileReader(usuarios));
			String linea=flectura.readLine();
			while(linea!=null){
				registro=linea.split("::");
				Usuario u=new Usuario(Integer.parseInt(registro[0]), registro[1], registro[2], registro[3]);
				if(u.getCodUsuario()==usuario){
					existeUsu=true;
					break;
				}
				linea=flectura.readLine();
			}
			flectura.close();
		} catch (IOException e) {
			System.out.println("Error al manejar ficheros.");
		}
		
		if(!existeUsu){
			System.out.println("No existe el usuario con código "+usuario+".");
			return;
		}
		
		switch (material) {
		case "Libro":
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a prestar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(libros));
				String linea=flectura.readLine();
				while(linea!=null){
					registro=linea.split("::");
					Libro l=new Libro(registro[0], registro[1], registro[2], registro[3], registro[4], registro[5]);
					if(l.getIsbn().toLowerCase().equals(isbn.toLowerCase())){
						existeMat=true;
						break;
					}
					linea=flectura.readLine();
				}
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			
			if(!existeMat){
				System.out.println("No existe el libro con el ISBN "+isbn+".");
				return;
			}
			p=new Prestamo(usuario, isbn, material, fechaActual());

			if(this.estaPrestado(p)){
				System.out.println("El libro está prestado.");
				return;
			}
			registrarPrestamo(p);
			break;
		case "Articulo":
			codigo=PedirDatos.leerEntero("Introduce el código del Artículo a prestar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(articulos));
				String linea=flectura.readLine();
				while(linea!=null){
					registro=linea.split("::");
					Articulo a=new Articulo(Integer.parseInt(registro[0]), registro[1], registro[2], Integer.parseInt(registro[3]));
					if(a.getCodArticulo()==codigo){
						existeMat=true;
						break;
					}
					linea=flectura.readLine();
				}
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			
			if(!existeMat){
				System.out.println("No existe el Artículo con el código "+codigo+".");
				return;
			}
			p=new Prestamo(usuario, codigo+"", material, fechaActual());

			if(this.estaPrestado(p)){
				System.out.println("El "+material+" está prestado.");
				return;
			}
			registrarPrestamo(p);
			break;
		case "CD-ROM":
			codigo=PedirDatos.leerEntero("Introduce el código del CD-ROM a prestar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(cdroms));
				String linea=flectura.readLine();
				while(linea!=null){
					registro=linea.split("::");
					Cdrom c=new Cdrom(Integer.parseInt(registro[0]), registro[1], registro[2], registro[3], registro[4], registro[5]);
					if(c.getCodCdrom()==codigo){
						existeMat=true;
						break;
					}
					linea=flectura.readLine();
				}
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			
			if(!existeMat){
				System.out.println("No existe el CD-ROM con el código "+codigo+".");
				return;
			}
			
			p=new Prestamo(usuario, codigo+"", material, fechaActual());

			if(this.estaPrestado(p)){
				System.out.println("El "+material+" está prestado.");
				return;
			}
			registrarPrestamo(p);
			break;
		case "Revista":
			codigo=PedirDatos.leerEntero("Introduce el código de la Revista a prestar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(revistas));
				String linea=flectura.readLine();
				while(linea!=null){
					registro=linea.split("::");
					Revista r=new Revista(Integer.parseInt(registro[0]), registro[1], registro[2], registro[3]);
					if(r.getCodRevista()==codigo){
						existeMat=true;
						break;
					}
					linea=flectura.readLine();
				}
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			
			if(!existeMat){
				System.out.println("No existe la Revista con el código "+codigo+".");
				return;
			}
			
			p=new Prestamo(usuario, codigo+"", material, fechaActual());
		
			if(this.estaPrestado(p)){
				System.out.println("La "+material+" está prestada.");
				return;
			}
			registrarPrestamo(p);
			break;
		}
	}

	
	private void devolverMaterial(String material){
		String codigo;
		String[] registro=new String[6];
		Prestamo p;
		String linea;
		
		if(material.equals("Libro")){
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a devolver: ");

			try {
				flectura=new BufferedReader(new FileReader(prestamos));
				fescritura=new BufferedWriter(new FileWriter(prestamostmp));
				
				linea=flectura.readLine();
				while(linea!=null){
					registro=linea.split("::");
					if(registro[1].equals(isbn) && registro[2].equals(material)){
						try{
							registro[4]=registro[4]; //Para que salte el error si la fecha devolución está vacía
						}catch(Exception e){
							p=new Prestamo(Integer.parseInt(registro[0]), registro[1], registro[2], registro[3], fechaActual());
							fescritura.write(componerRegistroPrestamo(p));
							fescritura.newLine();
							linea=flectura.readLine();
							continue;
						}	
					}
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}
				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				prestamos.delete();
				prestamostmp.renameTo(prestamos);
				}catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			
			return;
		}
		codigo = PedirDatos.leerCadena("Introduce el código del "+material+"  a prestar: ");

		try {
			flectura = new BufferedReader(new FileReader(prestamos));
			fescritura = new BufferedWriter(new FileWriter(prestamostmp));

			linea = flectura.readLine();
			while (linea != null) {
				registro = linea.split("::");
				if (registro[1].equals(codigo) && registro[2].equals(material)) {
					try {
						registro[4] = registro[4]; // Para que salte el error si
													// la fecha devolución está
													// vacía
					} catch (Exception e) {
						p = new Prestamo(Integer.parseInt(registro[0]), registro[1], registro[2], registro[3], fechaActual());
						fescritura.write(componerRegistroPrestamo(p));
						fescritura.newLine();
						linea = flectura.readLine();
						continue;
					}
				}
				fescritura.write(linea);
				fescritura.newLine();
				linea = flectura.readLine();
			}
			fescritura.flush();
			fescritura.close();
			flectura.close();

			prestamos.delete();
			prestamostmp.renameTo(prestamos);
		} catch (IOException e) {
			System.out.println("Error al manejar ficheros.");
		}
	}
		
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
				this.devolverPrestamo();
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(opcion!=0);
	}
}