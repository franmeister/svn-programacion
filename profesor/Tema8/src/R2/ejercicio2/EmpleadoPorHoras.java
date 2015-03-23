package R2.ejercicio2;

public class EmpleadoPorHoras extends Empleado {
	final double precioHora=5;
	double numeroHoras;
	
	public EmpleadoPorHoras(String nombre, int edad, String dni,int numeroHoras){
		super(nombre,edad,dni);
		this.numeroHoras=numeroHoras;
	}

	protected double salario(){
		this.sueldo=precioHora*numeroHoras;
		return super.salario();
	}

}
