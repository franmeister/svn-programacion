package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionPrestamo {
	private Connection con;

	public GestionPrestamo(Connection con) {
		this.con = con;
	}
	
	public void realizarPrestamo(){
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
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
	
	private boolean buscarUsuario(int cod){
		String sql="select count(*) from usuario where codusuario="+cod;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				if(rset.getInt(1)<1){
					rset.close();
					stmt.close();
					return false;
				}
			}
			rset.close();
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Error en BD.");
			return false;
		}
	}
	
	private void prestarMaterial(String material){
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		int codigo=0;
		boolean existeUsu=this.buscarUsuario(this.pedirUsuario());
		boolean existeMat=false;
		Prestamo p;
				
		if(!existeUsu){
			System.out.println("No existe el usuario.");
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

	
	public void devolverPrestamo(){
		
	}
	
	private int pedirUsuario(){
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		int usuario = -1;
		System.out.println("Introduce el código del usuario:: ");
		try {
			usuario=Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Error, inserte un número entero.");
		} catch (IOException e) {
			System.out.println("Error al leer datos.");
		}	
		return usuario;
	}
	
}
