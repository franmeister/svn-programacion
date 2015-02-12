package relacion1.ejercicio7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	
	public void menu(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		int op=-1;
		boolean seguir=false;

		do{
			System.out.println();
			System.out.println("1. Gestionar empleados");
			System.out.println("2. Gestionar departamentos");
			System.out.println("3. Imprimir ...");
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
