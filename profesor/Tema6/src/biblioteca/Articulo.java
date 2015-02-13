package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Articulo {

	private int codigoArticulo;
	private String titulo;
	private String autor;
	private int numeroPaginas;
	
	public Articulo(){
		
	}
	public Articulo(int codigoArticulos, String titulo, String autor,
			int numeroPaginas) {
		super();
		this.codigoArticulo = codigoArticulos;
		this.titulo = titulo;
		this.autor = autor;
		this.numeroPaginas = numeroPaginas;
	}

	public int getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(int codigoArticulos) {
		this.codigoArticulo = codigoArticulos;
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

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	public boolean equals(Articulo a){
		return (this.codigoArticulo==(a.getCodigoArticulo()))&&(this.titulo.equals(a.getTitulo()))&&(this.autor.equals(a.getAutor()))&&(this.numeroPaginas==(a.getNumeroPaginas()));
	}

	@Override
	public String toString() {
		return "Codigo Articulo: " + codigoArticulo + "\n Titulo: "
				+ titulo + "\n Autor: " + autor + "\n Numero Paginas: "
				+ numeroPaginas;
	}
	
	public void pedirArticulo(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Introduzca el código del artículo");
			this.codigoArticulo=Integer.parseInt(teclado.readLine());
			System.out.println("Introduzca el título");
			this.titulo=teclado.readLine();
			System.out.println("Introduzca el autor");
			this.autor=teclado.readLine();
			System.out.println("Introduzca el numero de página");
			this.numeroPaginas=Integer.parseInt(teclado.readLine());
			
		}catch(IOException e){
			System.out.println("Consulte con Antonio");
		}
	}
	
	
	
}
