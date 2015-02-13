package ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Departamento {
	int dept_no;
	String dnombre;
	String loc;
	public Departamento(){
		
	}
	public Departamento(int dept_no, String dnombre, String loc) {
		super();
		this.dept_no = dept_no;
		this.dnombre = dnombre;
		this.loc = loc;
	}
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
		return "Departamento " + dept_no + " - " + dnombre + " - " + loc;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (dept_no != other.dept_no)
			return false;
		if (dnombre == null) {
			if (other.dnombre != null)
				return false;
		} else if (!dnombre.equals(other.dnombre))
			return false;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		return true;
	}
	
	public void pedirDepartamento(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		boolean seguir=false;
		
		while(!seguir){
			try {
				System.out.println("Introduzca el Número de Departamento");
				this.dept_no=Integer.parseInt(teclado.readLine());
				seguir=true;
				System.out.println("Introduzca el nombre de Departamento");
				this.dnombre=teclado.readLine();
				System.out.println("Introduzca la localidad del Departamento");
				this.loc=teclado.readLine();
			} catch (Exception e){
				System.out.println("el numero de departamento debe de ser un numero");;
			}
		}
	}
	
}
