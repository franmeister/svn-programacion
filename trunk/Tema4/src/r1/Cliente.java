package r1;

public class Cliente {
	private String nombre;
	private String apellidos;
	private String direccion;
	private String dni;
	
	public Cliente(String nombre, String apellidos, String direccion, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.dni = dni;
	}
	public Cliente(){
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return dni+"\n"+nombre+" "+apellidos+"\n"+direccion;
	}

}
/*
-----------------------------------------
|				Cliente					|
|---------------------------------------|
|nombre string							|
|apellido String						|
|direccion string						|
|dni String								|
|---------------------------------------|
|Constructores							|
|Get's y set's							|
|toString								|
-----------------------------------------

toString:
dni
nombre apellido
direccion
*/