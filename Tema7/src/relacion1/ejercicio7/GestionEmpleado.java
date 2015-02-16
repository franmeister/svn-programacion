package relacion1.ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionEmpleado {

	private Connection con;
	
	public GestionEmpleado(Connection con){
		this.con=con;
	}
	
	private void nuevoEmple(){
		Empleado e=new Empleado();
		e.pedirEmpleado();
		try {
			Statement stmt = this.con.createStatement();
			String sql="insert into emple values "
					+ "("+e.getEmp_no()+",'"+e.getApellido()+"','"+e.getOficio()+"',"
					+e.getDir()+",'"+e.getFecha_alt()+"',"+e.getSalario()+","+e.getComision()
					+","+e.getTotal()+","+e.getDept_no()+")";
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han insertado "+res+" departamento/s.");
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Error de BD.");
		}
	}
	
	private void listarEmple(){
		try {
			Statement stmt = this.con.createStatement();

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
				System.out.print (rset.getString("OFICIO")+"-"); 
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
			System.out.println("Error de BD.");
		}
	}
	
	private void borrarEmple(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		int cod=0;
		
		System.out.println("Introduce número de empleado a borrar: ");
		try {
			cod=Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Error, introduce un número entero.");
			this.borrarEmple();
			return;
		} catch (IOException e) {
			System.out.println("Error al leer datos.");
			this.borrarEmple();
			return;
		}
		String sql="delete from emple where emp_no="+cod;
		Statement stmt;
		try {
			stmt = this.con.createStatement();
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han borrado "+res+" empleado/s.");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error de BD.");
		}

	}
	
	private void modEmple(){
		System.out.println("Introduce los nuevos datos del departamento a modificar: ");
		Empleado e=new Empleado();
		e.pedirEmpleado();
		
		String sql="update emple set apellido='"+e.getApellido()
				+"',oficio='"+e.getOficio()+"',dir="+e.getDir()+",fecha_alt='"
				+e.getFecha_alt()+"',salario="+e.getSalario()+",comision="
				+e.getComision()+",total="+e.getTotal()+",dept_no="+e.getDept_no()
				+" where emp_no="+e.getEmp_no();
		try {
			Statement stmt=con.createStatement();
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han modificado "+res+" departamento/s.");
			stmt.close();
		} catch (SQLException e1) {
			System.out.println("Error de BD");
		}
	}
	
	private void listarPorDepart(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		Statement stmt;
		try {
			stmt = con.createStatement();
			int num=0;
			boolean seguir;
			do{
				try{
					System.out.println("Introduzca una número de departamento:");
					num=Integer.parseInt(teclado.readLine());
					seguir=true;
				}catch (Exception e) {
					System.out.println("Debe de introducir un numero entero");
					seguir=false;
				}
			}while(!seguir);
					
			String sql="select * from emple where dept_no="+num;
			ResultSet rset = stmt.executeQuery(sql);
					
			while (rset.next()){
				System.out.println (rset.getInt("EMP_NO")+"-"+rset.getString("APELLIDO")+"-"
							+rset.getString("OFICIO")+"-"+(rset.getInt("DIR")+"-")
							+rset.getString("FECHA_ALT")+"-"+rset.getDouble("SALARIO")+"-"
							+rset.getDouble("COMISION")+"-"+rset.getDouble("TOTAL")+"-"
							+rset.getInt("DEPT_NO"));
			}
			rset.close();
			stmt.close(); 
			con.close();
		} catch (SQLException e) {
			//System.out.println("Error de BD");
			e.printStackTrace();;
		}
	}
	
	public void menu(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		int op=-1;
		boolean seguir=false;

		do{
			System.out.println();
			System.out.println("1. Añadir empleado");
			System.out.println("2. Modificar empleado");
			System.out.println("3. Eliminar empleado");
			System.out.println("4. Listar empleados");
			System.out.println("5. Listar empleados por departamento");
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
				this.nuevoEmple();
				break;
			case 2:
				this.modEmple();
				break;
			case 3:
				this.borrarEmple();
				break;
			case 4:
				this.listarEmple();
				break;
			case 5:
				this.listarPorDepart();
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
