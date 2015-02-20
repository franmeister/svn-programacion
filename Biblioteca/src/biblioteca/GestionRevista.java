package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionRevista {
	private Connection con;

	public GestionRevista(Connection con) {
		this.con = con;
	}

	private void nuevoRevista() {
		Revista r = new Revista();
		r.pedirRevista();

		String sql = "insert into revista values("+r.getCodRevista()+",'"+r.getSignatura()
				+ "','"+r.getNombre() + "','"+r.getMateria()+ "')";

		try {
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);

			if (res == 1) {
				System.out.println("El revista se ha insertado correctamente.");
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void listarRevista(){
		Revista r = new Revista();
		String sql="select * from revista";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				r.setCodRevista(rset.getInt("CODREVISTA"));
				r.setSignatura(rset.getString("SIGNATURA"));
				r.setNombre(rset.getString("NOMBRE"));
				r.setMateria(rset.getString("MATERIA"));
				
				System.out.println(r.toString()+"\n");
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void buscarRevista(int cod){
		Revista r = new Revista();
		String sql="select * from revista where codrevista="+cod;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				r.setCodRevista(rset.getInt("CODREVISTA"));
				r.setSignatura(rset.getString("SIGNATURA"));
				r.setNombre(rset.getString("NOMBRE"));
				r.setMateria(rset.getString("MATERIA"));
				
				System.out.println(r.toString()+"\n");
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
	
	private void borrarRevista(int cod){
		String sql="delete from revista where codrevista="+cod;
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			int res=stmt.executeUpdate(sql);
			stmt.close();

			if(res>=1){
				System.out.println("La revista se ha borrado correctamente.");
				return;
			}
			System.out.println("La revista no se encuentra en la BDD.");
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void modificarRevista(int cod){
		Revista r = new Revista();
		r.pedirRevista();

		String sql = "update revista set codrevista="+r.getCodRevista()+",signatura='"+r.getSignatura()
				+ "',nombre='"+r.getNombre() + "',materia='"+r.getMateria()+ "where codrevista="+cod;

		try {
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			stmt.close();

			if (res == 1) {
				System.out.println("La revista se ha modificado correctamente.");
				return;
			}
			System.out.println("La revista no se encuentra en la BDD.");

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
			System.out.println("1.Nuevo Revista");
			System.out.println("2.Modificar Revista");
			System.out.println("3.Borrar Revista");
			System.out.println("4.Listar Revistas");
			System.out.println("5.Buscar Revista");
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
				this.nuevoRevista();
				break;
			case 2:
				this.modificarRevista(this.pedirCodigo());
				break;
			case 3:
				this.borrarRevista(this.pedirCodigo());
				break;
			case 4:
				this.listarRevista();
				break;
			case 5:
				this.buscarRevista(this.pedirCodigo());
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		} while (opcion != 0);
	}
}
