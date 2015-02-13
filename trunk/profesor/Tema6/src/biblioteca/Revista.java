package biblioteca;

public class Revista {
	
	private int codigoRevista;
	private String signatura;
	private String nombre;
	private String materia;
	
	public Revista(int codigoRevista, String signatura, String nombre,
			String materia) {
		super();
		this.codigoRevista = codigoRevista;
		this.signatura = signatura;
		this.nombre = nombre;
		this.materia = materia;
	}

	public int getCodigoRevista() {
		return codigoRevista;
	}

	public void setCodigoRevista(int codigoRevista) {
		this.codigoRevista = codigoRevista;
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
	
	public boolean equals(Revista r){
		return (this.codigoRevista==(r.getCodigoRevista()))&&(this.signatura.equals(r.getSignatura()))&&(this.nombre.equals(r.getNombre()))&&(this.materia.equals(r.getMateria()));
	}

	@Override
	public String toString() {
		return "Codigo Revista: " + codigoRevista + "\n Signatura: "
				+ signatura + "\n Nombre: " + nombre + "\n Materia: " + materia;
	}
	
	

}
