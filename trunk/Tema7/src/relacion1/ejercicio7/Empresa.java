package relacion1.ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
		File f=new File("E:\\Users\\USUARIO\\Desktop\\svnJava\\Tema7\\src\\relacion1\\ejercicio7\\empresa.txt");
		BufferedWriter fescritura = null;
		try {
			fescritura=new BufferedWriter(new FileWriter(f));
		} catch (IOException e1) {
			System.out.println("Error al manejar ficheros.");
		}
		double totalDep=0, total=0;
		try{
			Statement stmt=this.con.createStatement();
			Statement stmt2=this.con.createStatement();

			String sql="select * from depart";
			ResultSet rset=stmt.executeQuery(sql);
			while (rset.next()){
				try {
					fescritura.write(this.addEspacios("Nº Departamento",6)+this.addEspacios("Nombre", 30)+this.addEspacios("Localidad",15));
					fescritura.newLine();
					fescritura.write("---------------------------------------------------------------------------");
					fescritura.newLine();
				} catch (IOException e1) {
					System.out.println("Error al escribir en fichero");
				}
				Departamento d=new Departamento();
				d.setDept_no(rset.getInt("DEPT_NO"));
				d.setDnombre(rset.getString("DNOMBRE"));
				d.setLoc(rset.getString("LOC"));
				try{
					fescritura.write(this.formatoDepart(d));
					fescritura.newLine();
					fescritura.newLine();
					fescritura.write(this.addEspacios("Nº Empleado",6)+this.addEspacios("Nombre", 30)
							+this.addEspacios("Oficio",15)+this.addEspacios("Salario", 11)+this.addEspacios("Total", 10));
					fescritura.newLine();
					fescritura.write("---------------------------------------------------------------------------");
					fescritura.newLine();
				} catch (IOException e1) {
					System.out.println("Error al escribir en fichero");
				}
				String sql2="select * from emple where dept_no="+rset.getInt("DEPT_NO");
				ResultSet rset2=stmt2.executeQuery(sql2);
				while(rset2.next()){
					Empleado e=new Empleado();
					e.setEmp_no(rset2.getInt("EMP_NO"));
					e.setApellido(rset2.getString("APELLIDO"));
					e.setOficio(rset2.getString("OFICIO"));
					e.setSalario(rset2.getDouble("SALARIO"));
					e.setComision(rset2.getDouble("COMISION"));
					try {
						fescritura.write(this.formatoEmple(e));
						fescritura.newLine();
					} catch (IOException e1) {
						System.out.println("Error al escribir en fichero");
					}
					totalDep+=rset2.getDouble("SALARIO");
				}
				total+=totalDep;
				try {
					fescritura.write(this.addEspacios("", 42)+"Total Departamento: "+totalDep);
					fescritura.newLine();
					fescritura.newLine();
				} catch (IOException e1) {
					System.out.println("Error al escribir en fichero");
				}
				totalDep=0;
			}
			try {
				fescritura.write(this.addEspacios("", 45)+"Total Empresa: "+total);
				fescritura.flush();
				fescritura.close();
			} catch (IOException e1) {
				System.out.println("Error al escribir en fichero");
			}
			rset.close();
			stmt.close();
		}catch(SQLException e){
			System.out.println("Error en la BD.");
		}
	}
	
	private String formatoDepart(Departamento d){
		return this.addEspacios(d.getDept_no()+"", 6)+this.addEspacios(d.getDnombre(), 30)+this.addEspacios(d.getLoc(), 15);
	}
	
	private String formatoEmple(Empleado e){
		return this.addEspacios(e.getEmp_no()+"", 6)+this.addEspacios(e.getApellido(), 30)+this.addEspacios(e.getOficio(), 15)
				+this.addEspacios(e.getSalario()+"", 11)+this.addEspacios(e.getTotal()+"", 10);
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
