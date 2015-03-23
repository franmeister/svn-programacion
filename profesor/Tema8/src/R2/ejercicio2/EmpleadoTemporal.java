package R2.ejercicio2;

import java.util.Calendar;

public class EmpleadoTemporal extends Empleado {
	Calendar fechaAlta;
	Calendar fechaBaja;
	
	public EmpleadoTemporal(String nombre, int edad, String dni){
		super(nombre,edad,dni);
		this.sueldo=1000;
	}
	
}
