package relacion1.agendaContactos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contacto {
	private String nombre, direccion, municipio, provincia, cp, telefonoFijo, telefonoMovil;
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	private void verificarNombre(){
		System.out.println("Introduce nombre y apellidos: ");
		String nom="";
		
		try {
			nom = teclado.readLine();
		} catch (IOException e1) {
			System.out.println("Error al introducir datos.");
		}
		
		if(nom.length()>60){
			this.nombre = nom.substring(0,60);
			return;
		}
		this.nombre = nom;

	}
	
	private void verificarDireccion(){
		System.out.println("Introduce dirección: ");
		String dir="";
		
		try {
			dir = teclado.readLine();
		} catch (IOException e1) {
			System.out.println("Error al introducir datos.");
		}
		
		if(dir.length()>40){
			this.direccion = dir.substring(0,40);
			return;
		}
		this.direccion = dir;
	}
	
	private void verificarCP(){
		boolean v=false;
		System.out.println("Introduce CP: ");
		String cp="";
		try {
			cp = teclado.readLine();
		} catch (IOException e1) {
			System.out.println("Error al introducir datos.");
		}
		
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
	
	private void verificarMunicipio(){
		System.out.println("Introduce municipio: ");
		String mun="";
		try {
			mun = teclado.readLine();
		} catch (IOException e1) {
			System.out.println("Error al introducir datos.");
		}
		
		if(mun.length()>30){
			this.municipio = mun.substring(0,30);
			return;
		}
		this.municipio = mun;
	}
	
	private void verificarProvincia(){
		System.out.println("Introduce provincia: ");
		String pro="";
		
		try {
			pro = teclado.readLine();
		} catch (IOException e1) {
			System.out.println("Error al introducir datos.");
		}
		
		if(pro.length()>15){
			this.provincia = pro.substring(0,15);
			return;
		}
		this.provincia = pro;
	}
	
	private void verificarTelefono(String tipo){
		boolean v=false;
		
		System.out.println("Introduce teléfono "+tipo+": ");
		String tel="";
		try {
			tel = teclado.readLine();
		} catch (IOException e1) {
			System.out.println("Error al introducir datos.");
		}
		
		while(!v){
			if(!tel.matches("^\\d{9}$")){
				System.out.println("Error, el teléfono "+tipo+" debe ser número de 9 cifras. Introduce teléfono de nuevo: ");
				try {
					tel=teclado.readLine();
				} catch (IOException e) {
					System.out.println("Error al introducir datos.");
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

	public void pedirContacto(){
		this.verificarNombre();
		this.verificarDireccion();
		this.verificarMunicipio();
		this.verificarProvincia();
		this.verificarCP();
		this.verificarTelefono("fijo");
		this.verificarTelefono("movil");
	}
	
	@Override
	public String toString() {
		return "--> Nombre y Apellidos=" + nombre + "\n\t Dirección=" + direccion
				+ "\n\t Municipio=" + municipio + "\n\t Provincia=" + provincia
				+ "\n\t CP=" + cp + "\n\t Teléfono Fijo=" + telefonoFijo
				+ "\n\t Teléfono Móvil=" + telefonoMovil;
	}
	
}
