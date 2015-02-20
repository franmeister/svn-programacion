package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionLibro {
	private Connection con;

	public GestionLibro(Connection con) {
		this.con = con;
	}

	private void nuevoLibro() {
		Libro l = new Libro();
		l.pedirLibro();

		String sql = "insert into libro values('"+l.getIsbn()+"','"+l.getSignatura()
				+ "','"+l.getTitulo() + "','"+l.getAutor() + "','"+l.getMateria()
				+ "','" + l.getEditorial()+ "')";

		try {
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);

			if (res == 1) {
				System.out.println("El libro se ha insertado correctamente.");
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void listarLibro(){
		Libro l = new Libro();
		String sql="select * from libro";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				l.setIsbn(rset.getString("ISBN"));
				l.setSignatura(rset.getString("SIGNATURA"));
				l.setTitulo(rset.getString("TITULO"));
				l.setAutor(rset.getString("AUTOR"));
				l.setMateria(rset.getString("MATERIA"));
				l.setEditorial(rset.getString("EDITORIAL"));
				
				System.out.println(l.toString()+"\n");
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void buscarLibro(String isbn){
		Libro l = new Libro();
		String sql="select * from libro where isbn='"+isbn+"'";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				l.setIsbn(rset.getString("ISBN"));
				l.setSignatura(rset.getString("SIGNATURA"));
				l.setTitulo(rset.getString("TITULO"));
				l.setAutor(rset.getString("AUTOR"));
				l.setMateria(rset.getString("MATERIA"));
				l.setEditorial(rset.getString("EDITORIAL"));
				
				System.out.println(l.toString()+"\n");
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}

	private String pedirIsbn(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		String isbn="";
		try {
			System.out.println("Introduzca el ISBN: ");
			isbn = teclado.readLine();
		} catch (IOException e) {
			System.out.println("Error al introducir datos.");
		}
		return isbn;
	}
	
	private void borrarLibro(String isbn){
		String sql="delete from libro where isbn='"+isbn+"'";
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			int res=stmt.executeUpdate(sql);
			
			if(res>=1){
				System.out.println("El libro se ha borrado correctamente.");
				return;
			}
			System.out.println("El libro no se encuentra en la BDD.");
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	public void menu() {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int opcion = -1;
		do {
			System.out.println("\n");
			System.out.println("1.Nuevo Libro");
			System.out.println("2.Modificar Libro");
			System.out.println("3.Borrar Libro");
			System.out.println("4.Listar Libros");
			System.out.println("5.Buscar Libro");
			System.out.println("0.Volver al menú principal");
			System.out.println("Elija una opcion:");

			try {
				opcion = Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Error, inserte un número entero.");
			} catch (IOException e) {
				System.out.println("Error al leer datos.");
			}

			switch (opcion) {
			case 0:
				break;
			case 1:
				this.nuevoLibro();
				break;
			case 2:
				// this.modificarMaterial(material);
				break;
			case 3:
				this.borrarLibro(this.pedirIsbn());
				break;
			case 4:
				this.listarLibro();
				break;
			case 5:
				this.buscarLibro(this.pedirIsbn());
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		} while (opcion != 0);
	}
}

