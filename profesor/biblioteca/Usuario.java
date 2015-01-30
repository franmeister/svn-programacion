package biblioteca;

public class Usuario {
	
	private int codigoUsuario;
	private String nombre;
	private String apellidos;
	
	public Usuario(int codigoUsuario, String nombre, String apellidos) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codUsuario) {
		this.codigoUsuario = codUsuario;
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

	@Override
	public String toString() {
		return "Usuario: "+ codigoUsuario + "\n Nombre: " + nombre
				+ "\n Apellidos: " + apellidos;
	}
	
	
}
