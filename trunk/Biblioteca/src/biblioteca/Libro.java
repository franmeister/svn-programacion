package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Libro {
	private String isbn;
	private String signatura;
	private String titulo;
	private String autor;
	private String materia;
	private String editorial;
	
	public Libro(){
		
	}
	
	public Libro(String isbn, String signatura, String titulo, String autor,
			String materia, String editorial) {
		this.isbn = isbn;
		this.signatura = signatura;
		this.titulo = titulo;
		this.autor = autor;
		this.materia = materia;
		this.editorial = editorial;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getSignatura() {
		return signatura;
	}

	public void setSignatura(String signatura) {
		this.signatura = signatura;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String toString() {
		return "ISBN:" + isbn + "\nSignatura:" + signatura + "\nTítulo="
				+ titulo + "\nAutor:" + autor + "\nMateria:" + materia
				+ "\nEditorial=" + editorial;
	}
	
	public boolean equals(Libro l){
		if(this.autor.equals(l.getAutor())&&this.editorial.equals(l.getEditorial())&&this.isbn.equals(l.getIsbn())&&this.materia.equals(l.getMateria())&&this.signatura.equals(l.getSignatura())&&this.titulo.equals(l.getTitulo())){
			return true;
		}
		return false;
	}
	
	public void pedirLibro(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		try{
			System.out.println("Introduce ISBN:");
			this.isbn = teclado.readLine();
			System.out.println("Introduce Signatura:");
			this.signatura = teclado.readLine();
			System.out.println("Introduce Autor:");
			this.autor = teclado.readLine();
			System.out.println("Introduce Título:");
			this.titulo = teclado.readLine();
			System.out.println("Introduce Materia:");
			this.materia = teclado.readLine();
			System.out.println("Introduce Editorial:");
			this.editorial = teclado.readLine();
		}catch(IOException e){
			System.out.println("Error al introducir datos.");
		}
	}
}
