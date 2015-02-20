package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionArticulo {
	private Connection con;

	public GestionArticulo(Connection con) {
		this.con = con;
	}
	
	private void nuevoArticulo(){
		Articulo a=new Articulo();
		a.pedirArticulo();
		
		String sql="insert into articulo values("+a.getCodArticulo()+",'"+a.getTitulo()+"','"
				+a.getAutor()+"',"+a.getNumPaginas()+")";

		try {
			Statement stmt=con.createStatement();
			int res=stmt.executeUpdate(sql);
			
			if(res==1){
				System.out.println("El artículo se ha insertado correctamente.");
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void listarArticulo(){
		Articulo a = new Articulo();
		String sql="select * from articulo";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				a.setCodArticulo(rset.getInt("CODARTICULO"));
				a.setTitulo(rset.getString("TITULO"));
				a.setAutor(rset.getString("AUTOR"));
				a.setNumPaginas(rset.getInt("NUMPAGINAS"));
				
				System.out.println(a.toString()+"\n");
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void buscarArticulo(int cod){
		Articulo a = new Articulo();
		String sql="select * from articulo where codarticulo="+cod;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				a.setCodArticulo(rset.getInt("CODARTICULO"));
				a.setTitulo(rset.getString("TITULO"));
				a.setAutor(rset.getString("AUTOR"));
				a.setNumPaginas(rset.getInt("NUMPAGINAS"));
				
				System.out.println(a.toString()+"\n");
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private int pedirCodigo(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		int cod=-1;
		try {
			System.out.println("Introduzca el código: ");
			cod = Integer.parseInt(teclado.readLine());
		} catch (IOException e) {
			System.out.println("Error al introducir datos.");
		}
		return cod;
	}
	
	private void borrarArticulo(int cod){
		String sql="delete from articulo where codarticulo="+cod;
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			int res=stmt.executeUpdate(sql);
			stmt.close();

			if(res>=1){
				System.out.println("El articulo se ha borrado correctamente.");
				return;
			}
			System.out.println("El articulo no se encuentra en la BDD.");
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void modificarArticulo(int cod){
		Articulo a = new Articulo();
		a.pedirArticulo();
		
		String sql="update articulo set codarticulo="+a.getCodArticulo()+",titulo='"+a.getTitulo()+"',autor='"
				+a.getAutor()+"',numpaginas="+a.getNumPaginas()+" where codarticulo="+cod;

		Statement stmt;
		try {
			stmt = con.createStatement();
			int res=stmt.executeUpdate(sql);
			stmt.close();
			if(res>=1){
				System.out.println("El artículo se ha modificiado correctamente.");
				return;
			}
			System.out.println("El artículo no se encuentra en la BDD.");
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
		
	}
	
	public void menu(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		int opcion=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Nuevo artículo");
			System.out.println("2.Modificar artículo");
			System.out.println("3.Borrar artículo");
			System.out.println("4.Listar artículos");
			System.out.println("5.Buscar artículo");
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
				this.nuevoArticulo();
				break;
			case 2:
				this.modificarArticulo(this.pedirCodigo());
				break;
			case 3:
				this.borrarArticulo(this.pedirCodigo());
				break;
			case 4:
				this.listarArticulo();
				break;
			case 5:
				this.buscarArticulo(this.pedirCodigo());
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(opcion!=0);
	}
}
