package relacion1.ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Empleado {
	private int emp_no, dir, dept_no;
	private String apellido, oficio;
	private double salario, comision, total;
	private Calendar fecha_alt;

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
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
		return this.comision+this.salario;
	}

	public String getFecha_alt() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(this.fecha_alt.getTime());
	}

	public void setFecha_alt(String fecha) {
		this.fecha_alt=Calendar.getInstance();
		int dia=Integer.parseInt(fecha.substring(0, 2));
		int mes=Integer.parseInt(fecha.substring(3, 5));
		int ano=Integer.parseInt(fecha.substring(6, 10));
		this.fecha_alt.set(ano, mes-1, dia);
	}

	@Override
	public String toString() {
		return "Empleado [emp_no=" + emp_no + ", dir=" + dir + ", dept_no="
				+ dept_no + ", apellido=" + apellido + ", oficio=" + oficio
				+ ", salario=" + salario + ", comision=" + comision
				+ ", total=" + total + ", fecha_alt=" + fecha_alt + "]";
	}
	
	public void pedirEmpleado(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		try{
			System.out.println("Introduce código de empleado: ");
			this.emp_no = Integer.parseInt(teclado.readLine());
			System.out.println("Introduce apellido: ");
			this.apellido = teclado.readLine();
			System.out.println("Introduce oficio:");
			this.oficio = teclado.readLine();
			System.out.println("Introduce código del jefe si procede: ");
			try{
				this.dir = Integer.parseInt(teclado.readLine());
			}catch(NumberFormatException ne){
				this.dir=0;
			}			
			System.out.println("Introduce código de departamento al que pertence: ");
			this.dept_no = Integer.parseInt(teclado.readLine());
			System.out.println("Introduce salario: ");
			this.salario = Double.parseDouble(teclado.readLine());
			System.out.println("Introduce comision: ");
			this.comision = Double.parseDouble(teclado.readLine());
			System.out.println("Introduce fecha de alta: (Formato \"dd/MM/yyyy\")");
			this.setFecha_alt(teclado.readLine());
		}catch(IOException e){
			System.out.println("Error al introducir datos.");
		}catch(NumberFormatException e){
			System.out.println("Error. El código de empleado debe de ser un entero.");
		}
	}	
}
