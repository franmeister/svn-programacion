package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionCdrom {
	private Connection con;

	public GestionCdrom(Connection con) {
		this.con = con;
	}

	private void nuevoCdrom() {
		Cdrom c = new Cdrom();
		c.pedirCdrom();

		String sql = "insert into cdrom values("+c.getCodCdrom()+",'"+c.getSignatura()
				+ "','"+c.getTitulo() + "','"+c.getAutor() + "','"+c.getMateria()
				+ "','" + c.getEditorial()+ "')";

		try {
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			stmt.close();

			if (res == 1) {
				System.out.println("El CD-ROM se ha modificado correctamente.");
				return;
			}
			System.out.println("El artículo no se encuentra en la BDD.");

		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}

	private void listarCdrom(){
		Cdrom c = new Cdrom();
		String sql="select * from cdrom";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				c.setCodCdrom(rset.getInt("CODCDROM"));
				c.setSignatura(rset.getString("SIGNATURA"));
				c.setTitulo(rset.getString("TITULO"));
				c.setAutor(rset.getString("AUTOR"));
				c.setMateria(rset.getString("MATERIA"));
				c.setEditorial(rset.getString("EDITORIAL"));
				
				System.out.println(c.toString()+"\n");
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void modificarCdrom(int cod){
		Cdrom c = new Cdrom();
		c.pedirCdrom();
		
		String sql="update cdrom set codcdrom="+c.getCodCdrom()+",signatura='"+c.getSignatura()
				+ "',titulo='"+c.getTitulo() + "',autor='"+c.getAutor() + "',materia='"+c.getMateria()
				+ "',editorial='" + c.getEditorial()+" where codcdrom="+cod;
		
		try {
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			stmt.close();

			if (res == 1) {
				System.out.println("El CD-ROM se ha insertado correctamente.");
				return;
			}
			System.out.println("El CD-ROM no se encuentra en la BDD.");

		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void buscarCdrom(int cod){
		Cdrom c = new Cdrom();
		String sql="select * from cdrom where codcdrom="+cod;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				c.setCodCdrom(rset.getInt("CODCDROM"));
				c.setSignatura(rset.getString("SIGNATURA"));
				c.setTitulo(rset.getString("TITULO"));
				c.setAutor(rset.getString("AUTOR"));
				c.setMateria(rset.getString("MATERIA"));
				c.setEditorial(rset.getString("EDITORIAL"));
				
				System.out.println(c.toString()+"\n");
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
	
	private void borrarCdrom(int cod){
		String sql="delete from cdrom where codcdrom="+cod;
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			int res=stmt.executeUpdate(sql);
			stmt.close();

			if(res>=1){
				System.out.println("El CD-ROM se ha borrado correctamente.");
				return;
			}
			System.out.println("El CD-ROM no se encuentra en la BDD.");
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
			System.out.println("1.Nuevo CD-ROM");
			System.out.println("2.Modificar CD-ROM");
			System.out.println("3.Borrar CD-ROM");
			System.out.println("4.Listar CD-ROMS");
			System.out.println("5.Buscar CD-ROM");
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
				this.nuevoCdrom();
				break;
			case 2:
				this.modificarCdrom(this.pedirCodigo());
				break;
			case 3:
				this.borrarCdrom(this.pedirCodigo());
				break;
			case 4:
				this.listarCdrom();
				break;
			case 5:
				this.buscarCdrom(this.pedirCodigo());
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		} while (opcion != 0);
	}
}
