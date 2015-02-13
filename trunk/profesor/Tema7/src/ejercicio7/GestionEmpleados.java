package ejercicio7;

import java.io.*;
import java.sql.*;

public class GestionEmpleados {

	Connection conn;
	
	public GestionEmpleados(Connection conn){
		this.conn=conn;
		
	}
	
	
	private void nuevoEmpleado(){
	
		Empleado e=new Empleado();
		e.pedirEmpleado();
		
		String sql= "Insert into emple values "
				+ "("+e.getEmp_no()+",'"+e.getApellido()+"','"+
				e.getOficio()+"',"+e.getDir()+",'"+e.getFecha_alt()+"',"+e.getSalario()+","
				+e.getComision()+","+e.getTotal()+","+e.getDept_no()+")";

		System.out.println(sql);
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e1) {
			System.out.println("Error de base de datos");
		}
	}
	private void borrarEmpleado(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		int emp_no;
		try{
		System.out.println("dime el numero del empleado a borrar");
		emp_no=Integer.parseInt(teclado.readLine());
		}catch(Exception e){
			System.out.println("error");
			return;
		}
		String sql="DELETE FROM EMPLE where emp_no="+emp_no;
		
		try {
			Statement stmp = conn.createStatement();
			stmp.executeUpdate(sql);
			stmp.close();
		} catch (SQLException e) {
			System.out.println("error de BD");
		}
	}
	
	
	public void menu(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		int opcion=0;
		boolean seguir=false;
		do{
			System.out.println("1.Nuevo Empleado");
			System.out.println("2.Borrar Empleado");
			System.out.println("3.Modificar Empleado");
			System.out.println("4.Listar Empleado");
			System.out.println("5.Listar Empleado por Departamento");
			System.out.println("6.Salir");
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
				this.nuevoEmpleado();
				break;
			case 2:
				this.borrarEmpleado();
				break;
			case 3:
				//this.
				break;
			case 4:
				//this.
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("Debe de elegir una opción entre 1 y 6");
				break;
			}
		}while (opcion!=6);
	}
	
	
}

