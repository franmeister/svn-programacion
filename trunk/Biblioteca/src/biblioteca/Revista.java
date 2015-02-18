package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Revista {
	private int codRevista;
	private String signatura;
	private String nombre;
	private String materia;
	
	public Revista(){
		
	}
	
	public Revista(int codRevista, String signatura, String nombre,
			String materia) {
		this.codRevista = codRevista;
		this.signatura = signatura;
		this.nombre = nombre;
		this.materia = materia;
	}

	public int getCodRevista() {
		return codRevista;
	}

	public void setCodRevista(int codRevista) {
		this.codRevista = codRevista;
	}

	public String getSignatura() {
		return signatura;
	}

	public void setSignatura(String signatura) {
		this.signatura = signatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String toString() {
		return "Código Revista:" + codRevista + "\nSignatura:" + signatura
				+ "\nNombre:" + nombre + "\nMateria:" + materia;
	}
	
	public boolean equals(Revista r){
		if(this.codRevista==r.getCodRevista()&&this.nombre.equals(r.getNombre())&&this.materia.equals(r.getMateria())&&this.signatura.equals(r.getSignatura())){
			return true;
		}
		return false;
	}
	

	public void pedirRevista(){	
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		try{
			System.out.println("Introduce Código de la Revista:");
			this.codRevista = Integer.parseInt(teclado.readLine());
			System.out.println("Introduce Signatura:");
			this.signatura = teclado.readLine();
			System.out.println("Introduce Materia:");
			this.materia = teclado.readLine();
			System.out.println("Introduce Nombre:");
			this.nombre = teclado.readLine();
		}catch(IOException e){
			System.out.println("Error al introducir datos.");
		}catch(NumberFormatException e){
			System.out.println("El código debe de ser un número.");
		}
	}
}
