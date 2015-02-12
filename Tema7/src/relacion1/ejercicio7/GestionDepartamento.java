package relacion1.ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionDepartamento {

	private Connection con;
	
	public GestionDepartamento(Connection con){
		this.con=con;
	}
	
	private void nuevoDepart(){
		Departamento d=new Departamento();
		d.pedirDepartamento();
		try {
			Statement stmt = con.createStatement();
			String sql="insert into depart values "
					+ "("+d.getDept_no()+",'"+d.getDnombre()+"','"+d.getLoc()+"')";
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han insertado "+res+" departamento/s.");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error de BDD.");
		}
	}
	
	private void listarDepart(){
		try {
			Statement stmt = this.con.createStatement();

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
			System.out.println("Error de BD.");
		}
	}
	
	private void borrarDepart(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		int cod=0;
		
		System.out.println("Introduce número de departamento a borrar: ");
		try {
			cod=Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Error, introduce un número entero.");
			this.borrarDepart();
			return;
		} catch (IOException e) {
			System.out.println("Error al leer datos.");
			this.borrarDepart();
			return;
		}
		String sql="delete from depart where dept_no="+cod;
		Statement stmt;
		try {
			stmt = this.con.createStatement();
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han borrado "+res+" departamento/s.");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error de BD.");
		}

	}
	
	private void modDepart(){
		System.out.println("Introduce los nuevos datos del departamento a modificar: ");
		Departamento d=new Departamento();
		d.pedirDepartamento();
		
		String sql="update depart set dnombre='"+d.getDnombre()
				+"',loc='"+d.getLoc()+"' "
				+"where dept_no="+d.getDept_no();
		try {
			Statement stmt=con.createStatement();
			int res=stmt.executeUpdate(sql);
			System.out.println("Se han modificado "+res+" departamento/s.");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error de BD");
		}
	}
		
	public void menu(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		int op=-1;
		boolean seguir=false;

		do{
			System.out.println();
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
			case 2:
				this.modDepart();
				break;
			case 3:
				this.borrarDepart();
				break;
			case 4:
				this.listarDepart();
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