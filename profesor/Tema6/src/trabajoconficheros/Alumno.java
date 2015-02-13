package trabajoconficheros;

public class Alumno {
	private String dni;
	private String nombre;
	private double nota;
	public Alumno(String dni, String nombre, double nota) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.nota = nota;
	}
	
	
	public String getDni() {
		return dni;
	}


	public String getNombre() {
		return nombre;
	}


	public double getNota() {
		return nota;
	}


	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", nota=" + nota
				+ "]";
	}
	
	

}
