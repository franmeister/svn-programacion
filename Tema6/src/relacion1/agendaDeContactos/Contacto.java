package relacion1.agendaDeContactos;

public class Contacto {
	private String nombre, direccion, municipio, provincia;
	private int cp, telefonoFijo, telefonoMovil;
	
	public Contacto(String nombre, String direccion, String municipio,
			String provincia, int cp, int telefonoFijo, int telefonoMovil) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.municipio = municipio;
		this.provincia = provincia;
		this.cp = cp;
		this.telefonoFijo = telefonoFijo;
		this.telefonoMovil = telefonoMovil;
	}
	
	
}
