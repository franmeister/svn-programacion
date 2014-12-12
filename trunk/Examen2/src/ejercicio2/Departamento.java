package ejercicio2;

public class Departamento {
	private int codigo=1;
	private String descripcion;
	
	public Departamento(int codigo, String descripcion) {
		this.descripcion = descripcion.toUpperCase();
		validarCodigo(codigo);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		validarCodigo(codigo);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion.toUpperCase();
	}
	
	private boolean validarCodigo(int cod){
		do{
			if(cod>0 && cod<101){
				this.codigo=cod;
				return true;
			}
			System.out.println("Error. El código debe estar comprendido entre 1 y 100.");
			cod=PedirDatos.leerEntero("Intentalo de nuevo: ");
		}while(true);
	}

	@Override
	public String toString() {
		return codigo + " --> " + descripcion;
	}
	
	
}
