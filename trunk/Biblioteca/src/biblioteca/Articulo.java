package biblioteca;

public class Articulo {
	private int codArticulo;
	private String titulo;
	private String autor;
	private int numPaginas;
	//private Vector keywords;
	
	public Articulo(){
		
	}
	
	public Articulo(int codArticulo, String titulo, String autor, int numPaginas) {
		this.codArticulo = codArticulo;
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
		//this.keywords = keywords;
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

	/*public Vector getKeywords() {
		return keywords;
	}

	public void setKeywords(Vector keywords) {
		this.keywords = keywords;
	}*/

	public String toString() {
		return "Código de Articulo:" + codArticulo + "\nTítulo:" + titulo
				+ "\nAutor:" + autor + "\nNúmero de Páginas:" + numPaginas;
				//+ "\nkeywords:" + keywords;
	}
	
	public boolean equals(Articulo a){
		if(this.codArticulo==a.getCodArticulo()&&this.titulo.equals(a.getTitulo())&&this.autor.equals(a.getAutor())&&this.numPaginas==a.getNumPaginas()){
			return true;
		}
		return false;
	}
		
}