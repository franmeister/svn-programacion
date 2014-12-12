package biblioteca;

public class Cdrom {
	private int codCdrom;
	private String signatura;
	private String titulo;
	private String autor;
	private String materia;
	private String editorial;
	
	public Cdrom(){
		
	}
	
	public Cdrom(int codCdrom, String signatura, String titulo, String autor,
			String materia, String editorial) {
		this.codCdrom = codCdrom;
		this.signatura = signatura;
		this.titulo = titulo;
		this.autor = autor;
		this.materia = materia;
		this.editorial = editorial;
	}

	public int getCodCdrom() {
		return codCdrom;
	}

	public void setCodCdrom(int codCdrom) {
		this.codCdrom = codCdrom;
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
		return "Código CD-ROM:" + codCdrom + "\nSignatura:" + signatura
				+ "\nTítulo:" + titulo + "\nAutor:" + autor
				+ "\nMateria:" + materia + "\nEditorial:" + editorial;
	}
	
	public boolean equals(Cdrom c){
		if(this.codCdrom==c.codCdrom&&this.signatura.equals(c.signatura)&&this.titulo.equals(c.titulo)&&this.materia.equals(c.materia)&&this.editorial.equals(c.editorial)&&this.autor.equals(c.autor)){
			return true;
		}
		return false;
	}
	
	
}
