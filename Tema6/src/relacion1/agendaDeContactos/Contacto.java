package relacion1.agendaDeContactos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contacto {
	private String nombre, direccion, municipio, provincia, cp, telefonoFijo, telefonoMovil;
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));

	public Contacto(String nombre, String direccion, String municipio,
			String provincia, String cp, String telefonoFijo,
			String telefonoMovil) {
		
		this.verificarNombre(nombre);
		this.verificarDireccion(direccion);
		this.verificarMunicipio(municipio);
		this.verificarProvincia(provincia);
		this.verificarCP(cp);
		this.verificarTelefono(telefonoFijo,"fijo");
		this.verificarTelefono(telefonoMovil,"movil");
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

	private void verificarNombre(String nom){
		if(nom.length()>60){
			this.nombre = nom.substring(0,60);
			return;
		}
		this.nombre = nom;

	}
	
	private void verificarDireccion(String dir){
		if(dir.length()>40){
			this.direccion = dir.substring(0,40);
			return;
		}
		this.direccion = dir;
	}
	
	private void verificarCP(String cp){
		boolean v=false;
		
		while(!v){
			if(!cp.matches("^\\d{5}$")){
				System.out.println("Error, el Código Postal debe ser número de 5 cifras. Introduce de nuevo: ");
				try {
					cp=teclado.readLine();
				} catch (IOException e) {
					System.out.println("Error al introducir datos");
				}
				continue;
			}
			v=true;
			this.cp=cp;
		}
	}
	
	private void verificarMunicipio(String mun){
		if(mun.length()>30){
			this.municipio = mun.substring(0,30);
			return;
		}
		this.municipio = mun;
	}
	
	private void verificarProvincia(String pro){
		if(pro.length()>15){
			this.provincia = pro.substring(0,15);
			return;
		}
		this.provincia = pro;
	}
	
	private void verificarTelefono(String tel, String tipo){
		boolean v=false;
		
		while(!v){
			if(!tel.matches("^\\d{9}$")){
				System.out.println("Error, el teléfono "+tipo+" debe ser número de 9 cifras. Introduce teléfono de nuevo: ");
				try {
					tel=teclado.readLine();
				} catch (IOException e) {
					System.out.println("Error al introducir datos");
				}
				continue;
			}
			v=true;
			if(tipo.equals("fijo")){
				this.telefonoFijo=tel;
			}else{
				this.telefonoMovil=tel;
			}
		}
	}

	@Override
	public String toString() {
		return "--> Nombre y Apellidos=" + nombre + "\n\t Dirección=" + direccion
				+ "\n\t Municipio=" + municipio + "\n\t Provincia=" + provincia
				+ "\n\t CP=" + cp + "\n\t Teléfono Fijo=" + telefonoFijo
				+ "\n\t Teléfono Móvil=" + telefonoMovil;
	}
	
}