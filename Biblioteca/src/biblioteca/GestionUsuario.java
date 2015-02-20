package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionUsuario {

	private Connection con;

	public GestionUsuario(Connection con) {
		this.con = con;
	}

	private void nuevoUsuario() {
		Usuario u = new Usuario();
		u.pedirUsuario();

		String sql = "insert into usuario values("+u.getCodUsuario()+",'"+u.getNombre()
				+ "','"+u.getApellido1() + "','"+u.getApellido2()+ "')";

		try {
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);

			if (res == 1) {
				System.out.println("El usuario se ha insertado correctamente.");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void listarUsuario(){
		Usuario u = new Usuario();
		String sql="select * from usuario";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				u.setCodUsuario(rset.getInt("CODUSUARIO"));
				u.setNombre(rset.getString("NOMBRE"));
				u.setApellido1(rset.getString("APELLIDO1"));
				u.setApellido2(rset.getString("APELLIDO2"));
				
				System.out.println(u.toString()+"\n");
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void buscarUsuario(int cod){
		Usuario u = new Usuario();
		String sql="select * from usuario where codusuario="+cod;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				u.setCodUsuario(rset.getInt("CODUSUARIO"));
				u.setNombre(rset.getString("NOMBRE"));
				u.setApellido1(rset.getString("APELLIDO1"));
				u.setApellido2(rset.getString("APELLIDO2"));
				
				System.out.println(u.toString()+"\n");
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
	
	private void borrarUsuario(int cod){
		String sql="delete from usuario where codusuario="+cod;
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			int res=stmt.executeUpdate(sql);
			
			if(res>=1){
				System.out.println("El usuario se ha borrado correctamente.");
				return;
			}
			System.out.println("El usuario no se encuentra en la BDD.");
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
			System.out.println("1.Nuevo Usuario");
			System.out.println("2.Modificar Usuario");
			System.out.println("3.Borrar Usuario");
			System.out.println("4.Listar Usuarios");
			System.out.println("5.Buscar Usuario");
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
				this.nuevoUsuario();
				break;
			case 2:
				// this.modificarMaterial(material);
				break;
			case 3:
				this.borrarUsuario(this.pedirCodigo());
				break;
			case 4:
				this.listarUsuario();
				break;
			case 5:
				this.buscarUsuario(this.pedirCodigo());
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		} while (opcion != 0);
	}
}