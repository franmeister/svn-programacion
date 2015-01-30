package biblioteca;

public class Libro {
	
	private String ISBN;
	private String signatura;
	private String titulo;
	private String autor;
	private String materia;
	private String editorial;
	
	public Libro(String iSBN, String signatura, String titulo, String autor,
			String materia, String editorial) {
		super();
		ISBN = iSBN;
		this.signatura = signatura;
		this.titulo = titulo;
		this.autor = autor;
		this.materia = materia;
		this.editorial = editorial;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
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
	
	public boolean equals(Libro l){
		return (this.ISBN.equals(l.getISBN()))&&(this.signatura.equals(l.getSignatura()))&&(this.titulo.equals(l.getTitulo()))&&(this.autor.equals(l.getAutor()))&&(this.materia.equals(l.getMateria()))&&(this.editorial.equals(l.getEditorial()));
	}
	

	@Override
	public String toString() {
		return "ISBN: " + ISBN + "\n Signatura: " + signatura + "\n Titulo: "
				+ titulo + "\n Autor: " + autor + "\n Materia: " + materia
				+ "\n Editorial: " + editorial;
	}
	
	
	

}
