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
	
	public Libro descomponerRegistroLibro(String linea){
		String[] registro=new String[6];

		registro=linea.split("::");
		return new Libro(registro[0], registro[1], registro[2], registro[3], registro[4], registro[5]);
	}
	
	public Articulo descomponerRegistroArticulo(String linea){
		String[] registro=new String[4];

		registro=linea.split("::");
		return new Articulo(Integer.parseInt(registro[0]), registro[1], registro[2], Integer.parseInt(registro[3]));
	}
	
	public Cdrom descomponerRegistroCdrom(String linea){
		String[] registro=new String[6];

		registro=linea.split("::");
		return new Cdrom(Integer.parseInt(registro[0]), registro[1], registro[2], registro[3], registro[4], registro[5]);
	}
	
	public Revista descomponerRegistroRevista(String linea){
		String[] registro=new String[4];

		registro=linea.split("::");
		return new Revista(Integer.parseInt(registro[0]), registro[1], registro[2], registro[3]);
	}
	
	public Usuario descomponerRegistroUsuario(String linea){
		String[] registro=new String[4];

		registro=linea.split("::");
		return new Usuario(Integer.parseInt(registro[0]), registro[1], registro[2], registro[3]);
	}

	private void nuevoMaterial(String material){
		switch (material) {
		case "Libro":
			Libro l=new Libro();
			l.pedirLibro(false);
			
			try{
				flectura=new BufferedReader(new FileReader(libros));
				fescritura=new BufferedWriter(new FileWriter(librostmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Libro l2=descomponerRegistroLibro(linea);
					if(l2.getIsbn().toLowerCase().equals(l.getIsbn().toLowerCase())){
						System.out.println("Error. El ISBN introducido está repetido");
						fescritura.close();
						flectura.close();
						librostmp.delete();
						return;
					}
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
			Articulo a=new Articulo();
			a.pedirArticulo(false);
			
			try{
				flectura=new BufferedReader(new FileReader(articulos));
				fescritura=new BufferedWriter(new FileWriter(articulostmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Articulo a2=descomponerRegistroArticulo(linea);
					if(a2.getCodArticulo()==a.getCodArticulo()){
						System.out.println("Error. El código introducido está repetido");
						fescritura.close();
						flectura.close();
						librostmp.delete();
						return;
					}
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
			Cdrom c=new Cdrom();
			c.pedirCdrom(false);
			
			try{
				flectura=new BufferedReader(new FileReader(cdroms));
				fescritura=new BufferedWriter(new FileWriter(cdromstmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Cdrom c2=descomponerRegistroCdrom(linea);
					if(c2.getCodCdrom()==c.getCodCdrom()){
						System.out.println("Error. El código introducido está repetido");
						fescritura.close();
						flectura.close();
						librostmp.delete();
						return;
					}
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
			Revista r=new Revista();
			r.pedirRevista(false);
			
			try{
				flectura=new BufferedReader(new FileReader(revistas));
				fescritura=new BufferedWriter(new FileWriter(revistastmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Revista r2=descomponerRegistroRevista(linea);
					if(r2.getCodRevista()==r.getCodRevista()){
						System.out.println("Error. El código introducido está repetido");
						fescritura.close();
						flectura.close();
						librostmp.delete();
						return;
					}
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
			Usuario u=new Usuario();
			u.pedirUsuario(false);
			
			try{
				flectura=new BufferedReader(new FileReader(usuarios));
				fescritura=new BufferedWriter(new FileWriter(usuariostmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Usuario u2=descomponerRegistroUsuario(linea);
					if(u2.getCodUsuario()==u.getCodUsuario()){
						System.out.println("Error. El código introducido está repetido");
						fescritura.close();
						flectura.close();
						librostmp.delete();
						return;
					}
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
	
	private void modificarMaterial(String material){
		int codigo;
		boolean mod=false;
		
		switch (material) {
		case "Libro":
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a modificar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(libros));
				fescritura=new BufferedWriter(new FileWriter(librostmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Libro l=descomponerRegistroLibro(linea);
					if(l.getIsbn().toLowerCase().equals(isbn.toLowerCase())){
						l.pedirLibro(true);
						fescritura.write(componerRegistroLibro(l));
						fescritura.newLine();
						linea=flectura.readLine();
						mod=true;
						continue;
					}
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				libros.delete();
				librostmp.renameTo(libros);
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		case "Articulo":
			codigo=PedirDatos.leerEntero("Introduce el código del artículo a modificar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(articulos));
				fescritura=new BufferedWriter(new FileWriter(articulostmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Articulo a=descomponerRegistroArticulo(linea);
					if(a.getCodArticulo()==codigo){
						a.pedirArticulo(true);
						fescritura.write(componerRegistroArticulo(a));
						fescritura.newLine();
						linea=flectura.readLine();
						mod=true;
						continue;
					}
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				articulos.delete();
				articulostmp.renameTo(articulos);
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;		
		case "CD-ROM":
			codigo=PedirDatos.leerEntero("Introduce el código del CD-ROM a modificar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(cdroms));
				fescritura=new BufferedWriter(new FileWriter(cdromstmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Cdrom c=descomponerRegistroCdrom(linea);
					if(c.getCodCdrom()==codigo){
						c.pedirCdrom(true);
						fescritura.write(componerRegistroCdrom(c));
						fescritura.newLine();
						linea=flectura.readLine();
						mod=true;
						continue;
					}
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				cdroms.delete();
				cdromstmp.renameTo(cdroms);
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;				
		case "Revista":
			codigo=PedirDatos.leerEntero("Introduce el código de la Revista a modificar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(revistas));
				fescritura=new BufferedWriter(new FileWriter(revistastmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Revista r=descomponerRegistroRevista(linea);
					if(r.getCodRevista()==codigo){
						r.pedirRevista(true);
						fescritura.write(componerRegistroRevista(r));
						fescritura.newLine();
						linea=flectura.readLine();
						mod=true;
						continue;
					}
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				revistas.delete();
				revistastmp.renameTo(revistas);
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		case "Usuario":
			codigo=PedirDatos.leerEntero("Introduce el código del Usuario a modificar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(usuarios));
				fescritura=new BufferedWriter(new FileWriter(usuariostmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Usuario u=descomponerRegistroUsuario(linea);
					if(u.getCodUsuario()==codigo){
						u.pedirUsuario(true);
						fescritura.write(componerRegistroUsuario(u));
						fescritura.newLine();
						linea=flectura.readLine();
						mod=true;
						continue;
					}
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				usuarios.delete();
				usuariostmp.renameTo(usuarios);
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		default:
			break;	
		}
		
		if(!mod){
			System.out.println("El "+material+" a modificar no existe.");
			return;
		}
		System.out.println("El "+material+" se ha modificado.");

	}

	private void borrarMaterial(String material){
		int codigo;
		boolean borrado=false;
		
		switch (material) {
		case "Libro":
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a modificar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(libros));
				fescritura=new BufferedWriter(new FileWriter(librostmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Libro l=descomponerRegistroLibro(linea);
					if(l.getIsbn().toLowerCase().equals(isbn.toLowerCase())){
						linea=flectura.readLine();
						borrado=true;
						continue;
					}
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				libros.delete();
				librostmp.renameTo(libros);
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		case "Articulo":
			codigo=PedirDatos.leerEntero("Introduce el código del artículo a modificar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(articulos));
				fescritura=new BufferedWriter(new FileWriter(articulostmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Articulo a=descomponerRegistroArticulo(linea);
					if(a.getCodArticulo()==codigo){
						linea=flectura.readLine();
						borrado=true;
						continue;
					}
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				articulos.delete();
				articulostmp.renameTo(articulos);
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;		
		case "CD-ROM":
			codigo=PedirDatos.leerEntero("Introduce el código del CD-ROM a modificar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(cdroms));
				fescritura=new BufferedWriter(new FileWriter(cdromstmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Cdrom c=descomponerRegistroCdrom(linea);
					if(c.getCodCdrom()==codigo){
						linea=flectura.readLine();
						borrado=true;
						continue;
					}
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				cdroms.delete();
				cdromstmp.renameTo(cdroms);
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;				
		case "Revista":
			codigo=PedirDatos.leerEntero("Introduce el código de la Revista a modificar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(revistas));
				fescritura=new BufferedWriter(new FileWriter(revistastmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Revista r=descomponerRegistroRevista(linea);
					if(r.getCodRevista()==codigo){
						linea=flectura.readLine();
						borrado=true;
						continue;
					}
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				revistas.delete();
				revistastmp.renameTo(revistas);
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		case "Usuario":
			codigo=PedirDatos.leerEntero("Introduce el código del Usuario a modificar: ");
			
			try {
				flectura=new BufferedReader(new FileReader(usuarios));
				fescritura=new BufferedWriter(new FileWriter(usuariostmp));
				
				String linea=flectura.readLine();
				while(linea!=null){
					Usuario u=descomponerRegistroUsuario(linea);
					if(u.getCodUsuario()==codigo){
						linea=flectura.readLine();
						borrado=true;
						continue;
					}
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}

				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				usuarios.delete();
				usuariostmp.renameTo(usuarios);
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		default:
			break;	
		}
		
		if(!borrado){
			System.out.println("El "+material+" a borrar no existe.");
			return;
		}
		System.out.println("El "+material+" se ha borrado.");

	}
	
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
			
			System.out.println("Se ha prestado el material.");
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
			flectura.close();
		}catch (IOException e) {
			System.out.println("Error al manejar ficheros.");
		}
		return false;
	}
	
	private void prestarMaterial(String material){
		int codigo;
		int usuario=PedirDatos.leerEntero("Introduce el código del usuario");
		boolean existeUsu=false, existeMat=false;
		Prestamo p;
		
		try {
			flectura=new BufferedReader(new FileReader(usuarios));
			String linea=flectura.readLine();
			while(linea!=null){
				Usuario u=descomponerRegistroUsuario(linea);
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
					Libro l=descomponerRegistroLibro(linea);
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
			p=new Prestamo(usuario, isbn, material, fechaActual(),"");

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
					Articulo a=descomponerRegistroArticulo(linea);
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
			p=new Prestamo(usuario, codigo+"", material, fechaActual(),"");

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
					Cdrom c=descomponerRegistroCdrom(linea);
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
			
			p=new Prestamo(usuario, codigo+"", material, fechaActual(),"");

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
					Revista r=descomponerRegistroRevista(linea);
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
			
			p=new Prestamo(usuario, codigo+"", material, fechaActual(),"");
		
			if(this.estaPrestado(p)){
				System.out.println("La "+material+" está prestada.");
				return;
			}
			registrarPrestamo(p);
			break;
		default:
			break;	
		}
	}

	
	private void devolverMaterial(String material){
		int codigo;
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
		codigo = PedirDatos.leerEntero("Introduce el código del "+material+"  a prestar: ");

		try {
			flectura = new BufferedReader(new FileReader(prestamos));
			fescritura = new BufferedWriter(new FileWriter(prestamostmp));

			linea = flectura.readLine();
			while (linea != null) {
				registro = linea.split("::");
				if (registro[1].equals(codigo+"") && registro[2].equals(material)) {
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
				this.modificarMaterial(material);
				break;
			case 3:
				this.borrarMaterial(material);
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