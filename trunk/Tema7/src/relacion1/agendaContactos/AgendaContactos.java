package relacion1.agendaContactos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AgendaContactos {
	
	public Connection con;
	
	public AgendaContactos(){
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
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "java", "java");	
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
	
	private void nuevoContacto(){
		Contacto c = new Contacto();
		c.pedirContacto();
		
		String sql="insert into contactos values('"+c.getNombre()+"','"+c.getDireccion()+"',"+c.getCp()+",'"
					+c.getMunicipio()+"','"+c.getProvincia()+"',"+c.getTelefonoFijo()+","+c.getTelefonoMovil()+")";
		
		try {
			Statement stmt=con.createStatement();
			int res=stmt.executeUpdate(sql);
			
			if(res==1){
				System.out.println("El contacto se ha insertado correctamente.");
			}
			
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
		
	}
	
	private String pedirNombre(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		String nombre="";
		try {
			System.out.println("Introduzca el nombre de contacto: ");
			nombre = teclado.readLine();
		} catch (IOException e) {
			System.out.println("Error al introducir datos.");
		}
		return nombre;
	}
	
	private void verContacto(String nom){
		String sql="select * from contactos where nombre='"+nom+"'";
		Contacto c=new Contacto();
		
		try {
			Statement stmt=con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				c.setCp(rset.getInt("CP")+"");
				c.setDireccion(rset.getString("DIRECCION"));
				c.setMunicipio(rset.getString("MUNICIPIO"));
				c.setNombre(rset.getString("NOMBRE"));
				c.setProvincia(rset.getString("PROVINCIA"));
				c.setTelefonoFijo(rset.getInt("TEL_FIJO")+"");
				c.setTelefonoMovil(rset.getInt("TEL_MOVIL")+"");

				System.out.println(c.toString());
			}
			
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	private void listarContactos(){
		String sql="select * from contactos";
		Contacto c=new Contacto();

		try {
			Statement stmt=con.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			
			while(rset.next()){
				c.setCp(rset.getInt("CP")+"");
				c.setDireccion(rset.getString("DIRECCION"));
				c.setMunicipio(rset.getString("MUNICIPIO"));
				c.setNombre(rset.getString("NOMBRE"));
				c.setProvincia(rset.getString("PROVINCIA"));
				c.setTelefonoFijo(rset.getInt("TEL_FIJO")+"");
				c.setTelefonoMovil(rset.getInt("TEL_MOVIL")+"");

				System.out.println(c.toString());
			}

		} catch (SQLException e) {
			System.out.println("Error en BD.");

		}
	}
	
	private void modificarContacto(String nom){
		Contacto c = new Contacto();
		c.pedirContacto();
		
		String sql="update contactos set nombre='"+c.getNombre()+"',direccion='"+c.getDireccion()+"',cp="+c.getCp()
				+",municipio='"+c.getMunicipio()+"',provincia='"+c.getProvincia()+"',tel_fijo="+c.getTelefonoFijo()
				+",tel_movil="+c.getTelefonoMovil()+" where nombre='"+nom+"'";
		System.out.println(sql);
		Statement stmt;
		try {
			stmt = con.createStatement();
			int res=stmt.executeUpdate(sql);
			
			if(res>=1){	//En el caso que haya más de un contacto con el mismo nombre
				System.out.println("El contacto se ha modificiado correctamente.");
				return;
			}
			System.out.println("El contacto no se encuentra en la BDD.");
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
		
	}
	
	private void borrarContacto(String nom){
		String sql="delete from contactos where nombre='"+nom+"'";
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			int res=stmt.executeUpdate(sql);
			
			if(res>=1){	//En el caso que haya más de un contacto con el mismo nombre
				System.out.println("El contacto se ha borrado correctamente.");
				return;
			}
			System.out.println("El contacto no se encuentra en la BDD.");
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
		
	}
	
	public void menu(){
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		int op=-1;
		boolean seguir=false;
		
		do{
			System.out.println();
			System.out.println("1. Añadir Contacto");
			System.out.println("2. Ver Contacto");
			System.out.println("3. Modificar Contacto");
			System.out.println("4. Borrar Contacto");
			System.out.println("5. Listar Contactos");
			System.out.println("0. Salir");
			do{
				try{
					System.out.println("Introduzca una opción:");
					op=Integer.parseInt(teclado.readLine());
					seguir=true;
				}catch (Exception e) {
					System.out.println("Debe de introducir un numero entero");
					seguir=false;
				}
			}while(!seguir);
		
			switch (op) {
			case 1:
				this.nuevoContacto();
				break;
			case 2:
				this.verContacto(this.pedirNombre());
				break;
			case 3:
				this.modificarContacto(this.pedirNombre());
				break;
			case 4:
				this.borrarContacto(this.pedirNombre());
				break;
			case 5:
				this.listarContactos();
				break;
			case 0:
				System.out.println("Programa terminado.");
				this.desconexion();
				break;
			default:
				System.out.println("Debe introducir un numero entre 0 y 5");
				break;
			}
		}while(op!=0);
	}

}
