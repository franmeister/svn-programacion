package ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionDepartamentos {

	Connection conn;
	public GestionDepartamentos(Connection conn){
		this.conn=conn;
	}
	
	private void nuevoDepartamento(){
		Departamento d=new Departamento();
		d.pedirDepartamento();
		
		String sql="Insert into depart values "
		+"("+d.getDept_no()+",'"+d.getDnombre()+"','"+d.getLoc()+"')";                                 
		
		try {
			Statement stmt=conn.createStatement();
			int res=stmt.executeUpdate(sql);
			if(res==1){
				System.out.println("Departamento creado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error de BD");
		}
	}
	
	private void borrarDepartamento(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		boolean seguir=false;
		int dept_no=0;
		while(!seguir){
			try {
				System.out.println("Introduzca el Número de Departamento");
				dept_no=Integer.parseInt(teclado.readLine());
				seguir=true;
			} catch (Exception e){
				System.out.println("el numero de departamento debe de ser un numero");;
			}
		}

		String sql="delete from depart where dept_no="+dept_no;
		
		try {
			Statement stmt=conn.createStatement();
			int res=stmt.executeUpdate(sql);
			if(res==1){
				System.out.println("Departamento "+dept_no+ " borrado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error de BD");
		}
	}
	
	private void modificarDepartamento(){
		System.out.println("Introduzca los nuevos datos del departamento a modificar");
		Departamento d=new Departamento();
		d.pedirDepartamento();
		
		String sql="update depart set dnombre='"+d.getDnombre()
				+"',loc='"+d.getLoc()+"' "
				+"where dept_no="+d.getDept_no();
		
		try {
			Statement stmt=conn.createStatement();
			int res=stmt.executeUpdate(sql);
			if(res==1){
				System.out.println("Departamento "+d.getDept_no()+ " modificado correctamente");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error de BD");
		}

	}
	private void listarDepartamentos(){
		String sql="Select * from depart";
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			while(rset.next()){
				System.out.print(rset.getInt("DEPT_NO")+" - ");
				System.out.print(rset.getString("DNOMBRE")+" - ");
				System.out.println(rset.getString("LOC"));
			}
			
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error de BD");
		}
		
	}
	public void menu(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		int opcion=0;
		boolean seguir=false;
		do{
			System.out.println("1.Nuevo Departamento");
			System.out.println("2.Borrar Departamento");
			System.out.println("3.Modificar Departamento");
			System.out.println("4.Listar Departamentos");
			System.out.println("5.Salir");
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
				this.nuevoDepartamento();
				break;
			case 2:
				this.borrarDepartamento();
				break;
			case 3:
				this.modificarDepartamento();
				break;
			case 4:
				this.listarDepartamentos();
				break;
			case 5:
				break;
			default:
				System.out.println("Debe de elegir una opción entre 1 y 5");
				break;
			}
		}while (opcion!=5);
	}
	
	
}
