package teoria;

public class Cliente {
	private String dni;
	private String nombre;
	private String direccion;
	
	public Cliente(String dni, String nombre, String direccion) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Cliente:\n" + dni + "\n" + nombre + "\n"+ direccion;
	}
}
