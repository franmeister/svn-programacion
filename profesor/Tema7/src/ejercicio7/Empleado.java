package ejercicio7;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Empleado {
	int emp_no; 
	String apellido;
	String oficio;
	int dir;
	Calendar fecha_alt=Calendar.getInstance();
	double salario;
	double comision;
	double total;
	int dept_no;
	
	public Empleado(){
		
	}
	
	
	public Empleado(int emp_no, String apellido, String oficio,
			Calendar fecha_alt, double salario, double comision, double total,
			int dept_no) {
		this.emp_no = emp_no;
		this.apellido = apellido;
		this.oficio = oficio;
		this.fecha_alt = fecha_alt;
		this.salario = salario;
		this.comision = comision;
		this.total = total;
		this.dept_no = dept_no;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getApellido() {
		return apellido;
	}

	public int getDir(){
		return dir;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		if(this.oficio.length()>10){
			this.oficio=oficio.substring(0,10);
		}
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
		
	}

	public String getFecha_alt() {
		SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
		
		Date fecha_alta = this.fecha_alt.getTime();
		formatoFecha.format(fecha_alta);
			
		return formatoFecha.format(this.fecha_alt.getTime());
	}

	public void setFecha_alt(String fecha_alt) {
		int dia=Integer.parseInt(fecha_alt.substring(0, 2));
		int mes=Integer.parseInt(fecha_alt.substring(3, 5));
		int anio=Integer.parseInt(fecha_alt.substring(6, 10));
		this.fecha_alt.set(anio, mes-1, dia);
	}
	
	public int antiguedad(){
		 Calendar hoy=Calendar.getInstance();
		 hoy.getTime();
		 return hoy.YEAR-this.fecha_alt.YEAR;
	}
	

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public double getTotal() {
		
		return salario+comision;
	}


	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	@Override
	public String toString() {
		return "-->Empleado Nº" + emp_no + " - " + apellido
				+ "\n     Departamento=" + dept_no
				+ "\n    " + oficio + " - " + this.getFecha_alt() 
				+ "\n     " + salario + " + " + comision+ "=" + total;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (Double.doubleToLongBits(comision) != Double
				.doubleToLongBits(other.comision))
			return false;
		if (dept_no != other.dept_no)
			return false;
		if (emp_no != other.emp_no)
			return false;
		if (fecha_alt == null) {
			if (other.fecha_alt != null)
				return false;
		} else if (!fecha_alt.equals(other.fecha_alt))
			return false;
		if (oficio == null) {
			if (other.oficio != null)
				return false;
		} else if (!oficio.equals(other.oficio))
			return false;
		if (Double.doubleToLongBits(salario) != Double
				.doubleToLongBits(other.salario))
			return false;
		if (Double.doubleToLongBits(total) != Double
				.doubleToLongBits(other.total))
			return false;
		return true;
	}
	
	public void pedirEmpleado(){
		
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		boolean seguir=false;
		
		while(!seguir){
			try {
				System.out.println("Introduzca el Número de Empleado");
				this.emp_no=Integer.parseInt(teclado.readLine());
				seguir=true;
				System.out.println("Introduzca el apellido del Empleado");
				this.apellido=teclado.readLine();
				System.out.println("Introduzca el oficio del empleado");
				this.oficio=teclado.readLine();
				System.out.println("Introduzca el numero de empleado del jefe");
				this.dir=Integer.parseInt(teclado.readLine());
				System.out.println("Introduzca la fecha de alta (dd/mm/yyyy)");
				String fecha=teclado.readLine();
				this.setFecha_alt(fecha);
				System.out.println("Introduzca el salario");
				this.salario=Double.parseDouble(teclado.readLine());
				System.out.println("Introduzca la comision");
				this.comision=Double.parseDouble(teclado.readLine());
				System.out.println("Introduzca el numero del departamento");
				this.dept_no=Integer.parseInt(teclado.readLine());
			} catch (Exception e){
				System.out.println("Hay un error al introducir los datos, introduzcalos de nuevo");;
			}
		}
	}
	
	
}
