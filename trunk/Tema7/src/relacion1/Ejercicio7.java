package relacion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio7 {

	private static void menu(Connection con){
		System.out.println("1. Empleados");
		System.out.println("2. Departamentos");
		System.out.println("3. Salir");

		
		System.out.println("1. Listar empleados");
		System.out.println("2. Añadir empleado");
		System.out.println("3. Modificar empleado");
		System.out.println("4. Borrar empleado");
		System.out.println("5. Salir");

	}
	
	private static void listarEmple(Connection con){
		try {
			Statement stmt = con.createStatement();

			String sql="select * from emple";
			ResultSet rset = stmt.executeQuery(sql);
			ResultSetMetaData rsmd=rset.getMetaData();
			int numColum=rsmd.getColumnCount();
			for(int i=1;i<=numColum;i++){
				System.out.print(rsmd.getColumnName(i)+"-");
			}
			System.out.println();
			
			while (rset.next()){ 
				System.out.print (rset.getInt("EMP_NO")+"-"); 
				System.out.print (rset.getString("APELLIDO")+"-");
				System.out.print (rset.getString("OFICIO")); 
				System.out.print (rset.getInt("DIR")+"-"); 
				System.out.print (rset.getString("FECHA_ALT")+"-");
				System.out.print (rset.getDouble("SALARIO")+"-");
				System.out.print (rset.getDouble("COMISION")+"-");
				System.out.print (rset.getDouble("TOTAL")+"-");
				System.out.println (rset.getInt("DEPT_NO"));
	
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	private static void listarDepart(Connection con){
		try {
			Statement stmt = con.createStatement();

			String sql="select * from depart";
			ResultSet rset = stmt.executeQuery(sql);
			ResultSetMetaData rsmd=rset.getMetaData();
			int numColum=rsmd.getColumnCount();
			for(int i=1;i<=numColum;i++){
				System.out.print(rsmd.getColumnName(i)+"-");
			}
			System.out.println();
			
			while (rset.next()){
				int dept_no=rset.getInt("DEPT_NO");
				System.out.print (dept_no+"-"); 
				System.out.print (rset.getString("DNOMBRE")+"-");
				System.out.println (rset.getString("LOC"));				
			}
			
			System.out.println();
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	private static void insertarEmple(Connection con){
		try {
			Statement stmt = con.createStatement();

			String sql="insert..."; //pedir
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han insertado "+res+" empleado/s.");

			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	private static void insertarDepart(Connection con){
		try {
			Statement stmt = con.createStatement();

			String sql="insert..."; //pedir
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han insertado "+res+" departamento/s.");
			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	private static void modEmple(Connection con){
		try {
			Statement stmt = con.createStatement();

			String sql="update..."; //pedir
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han modificado "+res+" empleado/s.");

			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	private static void modDepart(Connection con){
		try {
			Statement stmt = con.createStatement();

			String sql="update..."; //pedir
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han modificado "+res+" departamento/s.");

			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	private static void eliminarEmple(Connection con){
		try {
			Statement stmt = con.createStatement();

			String sql="delete..."; //pedir
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han modificado "+res+" empleado/s.");

			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	private static void eliminarDepart(Connection con){
		try {
			Statement stmt = con.createStatement();

			String sql="delete..."; //pedir
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han borrado "+res+" departamento/s.");

			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "java", "java");
			
			menu(con);
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
