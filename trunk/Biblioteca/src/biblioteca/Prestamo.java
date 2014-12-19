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

	public Calendar getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Calendar fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public String getCodMaterial() {
		return codMaterial;
	}

	public String getMaterial() {
		return material;
	}

	public Calendar getFechaDevolucion() {
		return fechaDevolucion;
	}
	
	
}
