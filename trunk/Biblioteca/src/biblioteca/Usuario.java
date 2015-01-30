package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Usuario {
	private int codUsuario;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	public Usuario(){
		
	}
	
	public Usuario(int codUsuario, String nombre, String apellido1,
			String apellido2) {
		this.codUsuario = codUsuario;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String toString() {
		return "Código Usuario:" + codUsuario + "\nNombre:" + nombre
				+ "\nPrimer Apellido:" + apellido1 + "\nSegundo Apellido:" + apellido2;
	}
	
	public boolean equals(Usuario u){
		if(this.codUsuario==u.getCodUsuario()&&this.nombre.equals(u.getNombre())&&this.apellido1.equals(u.getApellido1())&&this.apellido2==u.getApellido2()){
			return true;
		}
		return false;
	}
	
	public void pedirUsuario(boolean modificar){	//Si se llama desde modificar material no pedira codigo
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		try{
			if(!modificar){
				System.out.println("Introduce Código del Usuario:");
				this.codUsuario = Integer.parseInt(teclado.readLine());
			}
			System.out.println("Introduce Nombre:");
			this.nombre = teclado.readLine();
			System.out.println("Introduce Primer Apellido:");
			this.apellido1 =teclado.readLine();
			System.out.println("Introduce Segundo Apellido:");
			this.apellido2 = teclado.readLine();
		}catch(IOException e){
			System.out.println("Error al introducir datos.");
		}catch(NumberFormatException e){
			System.out.println("El código debe de ser un número.");
		}
	}

	
	
}
