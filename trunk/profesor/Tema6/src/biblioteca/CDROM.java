package biblioteca;

public class CDROM {

	private int codCDROM;
	private String signatura;
	private String titulo;
	private String autor;
	private String materia;
	private String editorial;
	
	public CDROM(int codCDROM, String signatura, String titulo, String autor,
			String materia, String editorial) {
		super();
		this.codCDROM = codCDROM;
		this.signatura = signatura;
		this.titulo = titulo;
		this.autor = autor;
		this.materia = materia;
		this.editorial = editorial;
	}

	public int getCodCDROM() {
		return codCDROM;
	}

	public void setCodCDROM(int codCDROM) {
		this.codCDROM = codCDROM;
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
	
	public boolean equals(CDROM c){
		return (this.codCDROM==(c.getCodCDROM()))&&(this.signatura.equals(c.getSignatura()))&&(this.titulo.equals(c.getTitulo()))&&(this.autor.equals(c.getAutor()))&&(this.materia.equals(c.getMateria()))&&(this.editorial.equals(c.getEditorial()));
	}
	
	
	
	
}
