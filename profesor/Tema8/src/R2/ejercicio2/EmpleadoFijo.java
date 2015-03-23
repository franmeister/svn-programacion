package R2.ejercicio2;

import java.util.*;

public class EmpleadoFijo extends Empleado {
	GregorianCalendar fechaAlta;
	
	public EmpleadoFijo(String nombre, int edad, String dni, GregorianCalendar fechaAlta){
		super(nombre,edad,dni);
		this.fechaAlta=fechaAlta;
	}
	protected double salario(){
		double base=1000;
		final double complementoAnual=100;
		
		Calendar hoy=Calendar.getInstance();
		long numAnios=(hoy.get(Calendar.YEAR)-fechaAlta.get(Calendar.YEAR));
		
		sueldo = base+(complementoAnual*numAnios);
		
		return super.salario();
	}
}
