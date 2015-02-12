package relacion1.ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Departamento {
	private int dept_no;
	private String dnombre, loc;
	
	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getDnombre() {
		return dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Departamento [dept_no=" + dept_no + ", dnombre=" + dnombre
				+ ", loc=" + loc + "]";
	}
	
	public void pedirDepartamento(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		try{
			System.out.println("Introduce código de departamento: ");
			this.dept_no = Integer.parseInt(teclado.readLine());
			System.out.println("Introduce nombre de departamento:");
			this.dnombre = teclado.readLine();
			System.out.println("Introduce localidad:");
			this.loc = teclado.readLine();
		}catch(IOException e){
			System.out.println("Error al introducir datos.");
		}catch(NumberFormatException e){
			System.out.println("Error. El código de departamento debe de ser un entero.");
		}
	}	
}