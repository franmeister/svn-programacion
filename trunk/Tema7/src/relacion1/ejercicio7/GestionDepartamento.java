package relacion1.ejercicio7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionDepartamento {

	private Connection con;
	
	public GestionDepartamento(Connection con){
		this.con=con;
	}
	
	public void nuevoDepart(){
		Departamento d=new Departamento();
		d.pedirDepartamento(false);
		try {
			Statement stmt = con.createStatement();
			String sql="insert into depart values "
					+ "("+d.getDept_no()+",'"+d.getDnombre()+"','"+d.getLoc()+"')";
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han insertado "+res+" departamento/s.");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en la BBDD.");
		}
	}
	
	public void menu(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		int op=-1;
		boolean seguir=false;

		do{
			System.out.println("1. Añadir departamento");
			System.out.println("2. Modificar departamento");
			System.out.println("3. Eliminar departamento");
			System.out.println("4. Listar departamentos");
			System.out.println("0. Volver");	
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
				this.nuevoDepart();
				break;
			case 0:
				break;
			default:
				System.out.println("Debe introducir un numero entre 0 y 4");
				break;
			}
		}while(op!=0);
	}
	
}