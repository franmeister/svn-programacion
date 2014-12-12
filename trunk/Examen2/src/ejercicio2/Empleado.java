package ejercicio2;

import java.util.Calendar;

public class Empleado {
	private String nif, nombre, oficio;
	private int anoAlta;
	private double salario;
	private Departamento departamento;
	
	public Empleado(String nif, String nombre, String oficio, int anoAlta,
			double salario, Departamento departamento) {
		if(!validarNif(nif)){
			System.out.println("No se ha podido crear el Empleado con nif "+nif);
			return;
		}
		this.nif=nif;
		this.nombre = nombre;
		this.oficio = oficio;
		this.anoAlta = anoAlta;
		this.salario = salario;
		this.departamento = departamento;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		do{
			if(validarNif(nif)){
				this.nif=nif;
				return;
			}
			System.out.println("Error. El NIF debe ser 8 números y una letra.");
			nif=PedirDatos.leerCadena("Introduce de nuevo: ");
		}while (true);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public int getAnoAlta() {
		return anoAlta;
	}

	public void setAnoAlta(int anoAlta) {
		this.anoAlta = anoAlta;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	private boolean validarNif(String nif){
		if(nif.length()==9 && nif.substring(8, 9).matches("^[A-Z]|[a-z]")){
			return true;
		}
		return false;
	}
	
	private double calcularIncentivo(){	// año actual
		return 20*(this.anoActual()-this.anoAlta);
	}

	@Override
	public String toString() {
		return nif + " - " + nombre + "\n" + oficio + " CON "+ (this.anoActual()-this.anoAlta) + " AÑOS DE ANTIGÜEDAD\nSalario "
				+ salario + " € + INCENTIVOS "+ calcularIncentivo() + " = " + (this.salario+calcularIncentivo())
				+ " € \nPERTENECE AL DEPARTAMENTO: " + departamento;
	}
	
	private int anoActual(){
		 Calendar c = Calendar.getInstance();
	     return Integer.parseInt(c.getTime().toString().substring(24));
	}
}
