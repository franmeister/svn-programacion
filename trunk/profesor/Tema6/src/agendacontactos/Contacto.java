package agendacontactos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contacto {
	
	private String nombre;
	private String direccion;
	private String CP;
	private String Municipio;
	private String Provincia;
	private String Telfijo;
	private String Telmovil;
	
	public Contacto(){
		
	}
	public Contacto(String nombre, String direccion, String CP,
			String municipio, String provincia, String telfijo, String telmovil) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.CP = CP;
		Municipio = municipio;
		Provincia = provincia;
		Telfijo = telfijo;
		Telmovil = telmovil;
	}

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCP() {
		return CP;
	}
	public void setCP(String CP) {
		this.CP = CP;
	}
	public String getMunicipio() {
		return Municipio;
	}
	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	
	public String getTelfijo() {
		return Telfijo;
	}
	public void setTelfijo(String telfijo) {
		Telfijo = telfijo;
	}
	public String getTelmovil() {
		return Telmovil;
	}
	public void setTelmovil(String telmovil) {
		Telmovil = telmovil;
	}
	@Override
	public String toString() {
		return "Contacto:\n" + nombre + "\n" + direccion
				+ "\n" + CP + " - " + Municipio + " - "	+ Provincia 
				+ "\nTeléfonos " + Telfijo + ", " + Telmovil;
	}
	public void pedirContacto(){
		BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("introduczca el nombre");
			 this.nombre=teclado.readLine();
			System.out.println("introduczca la direccion");
			direccion=teclado.readLine();
			System.out.println("introduczca el Cp");
			CP=teclado.readLine();
			System.out.println("introduczca el municipio");
			Municipio=teclado.readLine();
			System.out.println("introduczca la provincia");
			this.Provincia=teclado.readLine();
			System.out.println("introduczca el telefono fijo");
			this.Telfijo=teclado.readLine();
			System.out.println("introduczca el telefono movil");
			this.Telmovil=teclado.readLine();
			
			
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
	}
	
	

}
