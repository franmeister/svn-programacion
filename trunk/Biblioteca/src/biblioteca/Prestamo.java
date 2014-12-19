package biblioteca;

import java.util.Calendar;

public class Prestamo {
	private int codUsuario;
	private String codMaterial;
	private String material;
	private Calendar fechaPrestamo;
	private Calendar fechaDevolucion;
	
	public Prestamo(int codUsuario, String codMaterial, String material,
			Calendar fechaPrestamo) {
		this.codUsuario = codUsuario;
		this.codMaterial = codMaterial;
		this.material = material;
		this.fechaPrestamo = fechaPrestamo;
	}

	public String getCodMaterial() {
		return codMaterial;
	}

	public Calendar getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Calendar fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	
}
