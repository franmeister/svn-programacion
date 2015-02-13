package ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Empresa {
	
	Connection conn;
	public Empresa(){
		this.conexion();
		
	}
	
	private Connection conexion(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//CONECTAR: CONECTAMOS A LA BASE DE DATOS
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "java", "java");
			
			return conn;
		}catch(SQLException e){
			System.out.println("Error de Conexión");
			System.exit(0);
			return null;
		}catch(ClassNotFoundException e) {
			System.out.println("No se encuentra el driver de ORACLE");
			System.exit(0);
			return null;
		}

	}
	private void desconexion(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	public void menu(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		int opcion=0;
		boolean seguir=false;
		do{
			System.out.println("1.Gestión Departamentos");
			System.out.println("2.Gestión Empleados");
			System.out.println("3.Imprimir datos empresa");
			System.out.println("4.Salir");
			System.out.println("Elija una opción");
			while(!seguir){
				try{
					opcion=Integer.parseInt(teclado.readLine());
					seguir=true;
				}catch(IOException e){
					System.out.println("Debe de introducir un numero");
				}
			}
			seguir=false;
			switch (opcion) {
			case 1:
				(new GestionDepartamentos(conn)).menu();
				break;
			case 2:
				(new GestionEmpleados(conn)).menu();
				break;
			case 3:
				
				break;
			case 4:
				this.desconexion();
				System.out.println("Adios!!!");
				break;
			default:
				System.out.println("Debe de elegir una opción entre 1 y 5");
				break;
			}
		}while (opcion!=4);
	}
}
