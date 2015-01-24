package relacion1.agendaDeContactos;

public class Contacto {
	private String nombre, direccion, municipio, provincia, cp, telefonoFijo, telefonoMovil;

	public Contacto(String nombre, String direccion, String municipio,
			String provincia, String cp, String telefonoFijo,
			String telefonoMovil) {
		if(verificarNombre(nombre)){
			this.nombre = nombre;
		}
		if(verificarDireccion(direccion)){
			this.direccion = direccion;
		}
		if(verificarMunicipio(municipio)){
			this.municipio = municipio;
		}
		if(verificarProvincia(provincia)){
			this.provincia = provincia;
		}
		if(verificarCP(cp)){
			this.cp = cp;
		}
		if(verificarTelefono(telefonoFijo,"fijo")){
			this.telefonoFijo = telefonoFijo;
		}
		if(verificarTelefono(telefonoMovil,"móvil")){
			this.telefonoMovil = telefonoMovil;
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getMunicipio() {
		return municipio;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getCp() {
		return cp;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	private boolean verificarNombre(String s){
		if(s.length()>60){
			//System.out.println("Error. Nombre y apellidos no puede tener mas de 60 carácteres.");
			return false;
		}
		return true;
	}
	
	private boolean verificarDireccion(String s){
		if(s.length()>40){
			//System.out.println("Error. La dirección no puede tener mas de 40 carácteres.");
			return false;
		}
		return true;
	}
	
	private boolean verificarCP(String s){
		if(!s.matches("^\\d{5}$")){
			//System.out.println("Error. El código postal debe de tener 5 números.");
			return false;
		}
		return true;
	}
	
	private boolean verificarMunicipio(String s){
		if(s.length()>30){
			//System.out.println("Error. El municipio no puede tener mas de 30 carácteres.");
			return false;
		}
		return true;
	}
	
	private boolean verificarProvincia(String s){
		if(s.length()>15){
			//System.out.println("Error. La provincia no puede tener mas de 15 carácteres.");
			return false;
		}
		return true;
	}
	
	private boolean verificarTelefono(String s, String tipo){
		if(!s.matches("^\\d{9}$")){
			//System.out.println("Error. El teléfono "+tipo+" debe de tener 9 números.");
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "--> Nombre y Apellidos=" + nombre + "\n\t Dirección=" + direccion
				+ "\n\t Municipio=" + municipio + "\n\t Provincia=" + provincia
				+ "\n\t CP=" + cp + "\n\t Teléfono Fijo=" + telefonoFijo
				+ "\n\t Teléfono Móvil=" + telefonoMovil;
	}
	
	
}