package biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

public class Biblioteca {
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	public Connection con;

	public Biblioteca(){
		this.con=conexion();
	}
	
	private Connection conexion(){
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el Driver.");
			System.exit(0);
			return null;
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "biblioteca", "biblioteca");	
			//Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/java","root","");			
			return con;
		} catch (SQLException e) {
			System.out.println("Error al conectar con la BD.");
			System.exit(0);
			return null;
		}
	}
	
	private void desconexion(){
		try {
			this.con.close();
		} catch (SQLException e) {
			System.out.println("Error al desconectar con la BD.");
		}
	}
		
	private String fechaActual(){
		 Calendar c = Calendar.getInstance();
	     return c.getTime()+"";
	}
	
	/*private void registrarPrestamo(Prestamo p){
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
		int codigo=0;
		int usuario=0;
		
		System.out.println("Introduce el código del usuario:: ");
		try {
			usuario=Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Error, inserte un número entero.");
		} catch (IOException e) {
			System.out.println("Error al leer datos.");
		}
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
			String isbn="";
			System.out.println("Introduce el ISBN del libro a prestar: ");
			try {
				isbn = teclado.readLine();
			} catch (IOException e1) {
				System.out.println("Error al introducir datos");
			}
			
			
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
			System.out.println("Introduce el código del Artículo a prestar: ");
			try {
				codigo=Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Error, inserte un número entero.");
			} catch (IOException e) {
				System.out.println("Error al leer datos.");
			}
			
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
			System.out.println("Introduce el código del CD-ROM a prestar: ");
			try {
				codigo=Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Error, inserte un número entero.");
			} catch (IOException e) {
				System.out.println("Error al leer datos.");
			}			
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
			System.out.println("Introduce el código de la Revista a prestar: ");
			try {
				codigo=Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Error, inserte un número entero.");
			} catch (IOException e) {
				System.out.println("Error al leer datos.");
			}			
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
		int codigo=0;
		String[] registro=new String[6];
		Prestamo p;
		String linea, isbn="";
		
		if(material.equals("Libro")){
			System.out.println("Introduce el ISBN del libro a devolver: ");
			try {
				isbn = teclado.readLine();
			} catch (IOException e1) {
				System.out.println("Error al introducir datos");
			}

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
		System.out.println("Introduce el código del "+material+" a devolver: ");
		try {
			codigo=Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Error, inserte un número entero.");
		} catch (IOException e) {
			System.out.println("Error al leer datos.");
		}

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
		int opcion=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Libro");
			System.out.println("2.Revista");
			System.out.println("3.Artículo");
			System.out.println("4.CD-ROM");
			System.out.println("0.Volver al menú principal");
			System.out.println("Introduce material a prestar");
			
			try {
				opcion=Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Error, inserte un número entero.");
			} catch (IOException e) {
				System.out.println("Error al leer datos.");
			}
			
			switch (opcion) {
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
		}while(opcion!=0);
		
	}
	
	private void devolverPrestamo(){
		int opcion=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Libro");
			System.out.println("2.Revista");
			System.out.println("3.Artículo");
			System.out.println("4.CD-ROM");
			System.out.println("0.Volver al menú principal");
			System.out.println("Introduce material a devolver");
			
			try {
				opcion=Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Error, inserte un número entero.");
			} catch (IOException e) {
				System.out.println("Error al leer datos.");
			}
			switch (opcion) {
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
		}while(opcion!=0);
		
	}
	/*
	private void listarMaterial(String material){
		String linea;
		
		switch (material) {
		case "Libro":
			try{
				flectura=new BufferedReader(new FileReader(libros));
					
				linea=flectura.readLine();
				while(linea!=null){
					Libro l=descomponerRegistroLibro(linea);
					System.out.println(l.toString());
					System.out.println();
					linea=flectura.readLine();
				}
	
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		case "Articulo":
			try {
				flectura=new BufferedReader(new FileReader(articulos));
				
				linea=flectura.readLine();
				while(linea!=null){
					Articulo a=descomponerRegistroArticulo(linea);
					System.out.println(a.toString());
					System.out.println();
					linea=flectura.readLine();
				}

				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;		
		case "CD-ROM":
			try {
				flectura=new BufferedReader(new FileReader(cdroms));
				
				linea=flectura.readLine();
				while(linea!=null){
					Cdrom c=descomponerRegistroCdrom(linea);
					System.out.println(c.toString());
					linea=flectura.readLine();
				}
				
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;				
		case "Revista":
			try {
				flectura=new BufferedReader(new FileReader(revistas));
				
				linea=flectura.readLine();
				while(linea!=null){
					Revista r=descomponerRegistroRevista(linea);
					System.out.println(r.toString());
					System.out.println();
					linea=flectura.readLine();
				}
				
				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		case "Usuario":
			try {
				flectura=new BufferedReader(new FileReader(usuarios));
				
				linea=flectura.readLine();
				while(linea!=null){
					Usuario u=descomponerRegistroUsuario(linea);
					System.out.println(u.toString());
					System.out.println();
					linea=flectura.readLine();
				}

				flectura.close();
			} catch (IOException e) {
				System.out.println("Error al manejar ficheros.");
			}
			break;
		default:
			break;	
		}
	}
	
	private void menuMaterial(String material){
		int opcion=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Nuevo "+material);
			System.out.println("2.Modificar "+material);
			System.out.println("3.Borrar "+material);
			System.out.println("4.Listar "+material+"s");
			System.out.println("5.Buscar "+material);
			System.out.println("0.Volver al menú principal");
			System.out.println("Elija una opcion:");
			
			try {
				opcion=Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Error, inserte un número entero.");
			} catch (IOException e) {
				System.out.println("Error al leer datos.");
			}
			
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
			case 4:
				this.listarMaterial(material);
				break;
			case 5:
				this.buscarMaterial(material);
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(opcion!=0);
	}
	*/
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
			System.out.println("Elija una opcion:");
			
			try {
				opcion=Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Error, inserte un número entero.");
			} catch (IOException e) {
				System.out.println("Error al leer datos.");
			}
	
			switch (opcion) {
			case 0:
				System.out.println("Programa terminado.");
				this.desconexion();
				break;
			case 1:
				GestionLibro gl=new GestionLibro(this.con);
				gl.menu();
				break;
			case 2:
				GestionRevista gar=new GestionRevista(this.con);
				gar.menu();
				break;
			case 3:
				GestionCdrom gc=new GestionCdrom(this.con);
				gc.menu();
				break;
			case 4:
				GestionArticulo ga=new GestionArticulo(this.con);
				ga.menu();
				break;
			case 5:
				GestionUsuario gu=new GestionUsuario(this.con);
				gu.menu();
				break;
			case 6:
				GestionPrestamo gp=new GestionPrestamo(this.con);
				break;
			case 7:
				GestionPrestamo gp2=new GestionPrestamo(this.con);
				//this.devolverPrestamo();
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(opcion!=0);
	}
}