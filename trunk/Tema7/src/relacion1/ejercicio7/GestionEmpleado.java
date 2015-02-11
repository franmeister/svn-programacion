package relacion1.ejercicio7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;

public class GestionEmpleado {

	private Connection con;
	
	public GestionEmpleado(Connection con){
		this.con=con;
	}
	
	private void nuevoEmple(){
		Empleado e=new Empleado();
		e.pedirEmpleado(false);
		
		//String sql="insert into emple values ("+e.getEmp_no()+","
	}
	
	public void menu(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		int op=-1;
		boolean seguir=false;

		do{
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
