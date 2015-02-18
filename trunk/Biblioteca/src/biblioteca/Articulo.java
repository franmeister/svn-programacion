package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Articulo {
	private int codArticulo;
	private String titulo;
	private String autor;
	private int numPaginas;
	
	public Articulo(){
		
	}
	
	public Articulo(int codArticulo, String titulo, String autor, int numPaginas) {
		this.codArticulo = codArticulo;
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
	}

	public int getCodArticulo() {
		return codArticulo;
	}

	public void setCodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
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

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String toString() {
		return "Código de Articulo:" + codArticulo + "\nTítulo:" + titulo
				+ "\nAutor:" + autor + "\nNúmero de Páginas:" + numPaginas;
	}
	
	public boolean equals(Articulo a){
		if(this.codArticulo==a.getCodArticulo()&&this.titulo.equals(a.getTitulo())&&this.autor.equals(a.getAutor())&&this.numPaginas==a.getNumPaginas()){
			return true;
		}
		return false;
	}
	
	public void pedirArticulo(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

		try{
			System.out.println("Introduce Código del Artículo:");
			this.codArticulo = Integer.parseInt(teclado.readLine());
			System.out.println("Introduce Autor:");
			this.autor = teclado.readLine();
			System.out.println("Introduce Título:");
			this.titulo = teclado.readLine();
			System.out.println("Introduce número de páginas:");
			this.numPaginas = Integer.parseInt(teclado.readLine());
		}catch(IOException e){
			System.out.println("Error al introducir datos.");
		}catch(NumberFormatException e){
			System.out.println("El código y el número de página debe de ser un número.");
		}
	}
		
}