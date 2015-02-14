package relacion1.ejercicio7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Empresa {

	public Connection con;
	
	public Empresa(){
		this.con=conexion();
	}
	
	private Connection conexion(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el Driver.");
			System.exit(0);
			return null;
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "java", "java");			
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
	
	private String addEspacios(String dato,int caracteres){
		String ret="";
		for (int i=dato.length();i<caracteres;i++){
			ret=ret+" ";
		}
		ret=(dato+ret).substring(0,caracteres);
		return ret;
	}
	
	private void imprimirDatos(Connection con){
		try{
			Statement stmt=this.con.createStatement();
			String sql="select * from depart";
			ResultSet rset=stmt.executeQuery(sql);
			System.out.println(this.addEspacios("Nº Departamento",6)+this.addEspacios("Nombre", 30)+this.addEspacios("Localidad",15));
			while (rset.next()){
				Departamento d=new Departamento();
				d.setDept_no(rset.getInt("DEPT_NO"));
				d.setDnombre(rset.getString("DNOMBRE")+"-");
				d.setLoc(rset.getString("LOC"));
				System.out.println(this.formatoDepart(d));
			}
			System.out.println();
			rset.close();
			stmt.close();
		}catch(SQLException e){
			System.out.println("Error en la BD.");
		}
	}
	
	private String formatoDepart(Departamento d){
		return this.addEspacios(d.getDept_no()+"", 6)+this.addEspacios(d.getDnombre(), 30)+this.addEspacios(d.getLoc(), 15);
	}
	
	
	
	public void menu(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		int op=-1;
		boolean seguir=false;

		do{
			System.out.println();
			System.out.println("1. Gestionar empleados");
			System.out.println("2. Gestionar departamentos");
			System.out.println("3. Imprimir datos empresa");
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
				GestionEmpleado ge= new GestionEmpleado(this.con);
				ge.menu();
				break;
			case 2:
				GestionDepartamento gd= new GestionDepartamento(this.con);
				gd.menu();
				break;
			case 3:
				this.imprimirDatos(this.con);
				break;
			case 0:
				System.out.println("Programa terminado.");
				this.desconexion();
				break;
			default:
				System.out.println("Debe introducir un numero entre 0 y 3");
				break;
			}
		}while(op!=0);
	}
}
