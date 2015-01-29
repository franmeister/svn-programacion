package biblioteca;

public class Prestamo {
	private int codUsuario;
	private String codMaterial;
	private String material;
	private String fechaPrestamo;
	private String fechaDevolucion;
	
	
	public Prestamo(int codUsuario, String codMaterial, String material,
			String fechaPrestamo, String fechaDevolucion) {
		this.codUsuario = codUsuario;
		this.codMaterial = codMaterial;
		this.material = material;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}

	public String getCodMaterial() {
		return codMaterial;
	}

	public String getFechaDevolucion() {
		return fechaDevolucion;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public String getMaterial() {
		return material;
	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	
}
