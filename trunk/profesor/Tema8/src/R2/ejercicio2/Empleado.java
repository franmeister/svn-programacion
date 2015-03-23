package R2.ejercicio2;

public class Empleado {
	protected String nombre;
	protected int edad;
	protected String dni;
	protected double sueldo;
	public Empleado(String nombre, int edad, String dni) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
	}
	
	public Empleado() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	
	@Override
	public String toString() {
		return "Empleado: " + dni+ "-" +nombre + " de " + edad + " años de edad gana " + salario() + "€ al mes";
	}

	protected double salario(){
		return sueldo;
	}
	
}
