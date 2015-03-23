package R3.ejercicio1;

import Relacion1.Coche;

public class Persona {
	String nombre;
	String apellidos;
	String dni;
	Coche cochePropio=new Coche();
	
	public Persona(){
	}
	public Persona(String nombre, String apellidos, String dni, Coche c) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.cochePropio=c;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Coche getCochePropio() {
		return cochePropio;
	}
	public void setCochePropio(Coche cochePropio) {
		this.cochePropio = cochePropio;
	}
	
	public void compraCoche(){
		cochePropio.setPropietario(this);
	}
	
	public void usaCoche(double distancia, double velocidad){
		if(!this.poseeCoche()){
			System.out.println("La persona no posee coche");
			return;
		}
		cochePropio.esArrancado();
		cochePropio.fijarvelocidad(velocidad);
		cochePropio.setVelocidadMaxima(velocidad);
		cochePropio.setDistancia(distancia);
	}
	
	public Coche getCocheEnPropiedad(){
		return cochePropio;
	}
	
	public boolean poseeCoche(){
		if(cochePropio==null){
			return false;
		}
		return true;
	}
	
	public void imprimirDatosPersonales(){
		
	}
	
	
	@Override
	public String toString() {
		return "Persona [getNombre()=" + getNombre() + ", getApellidos()="
				+ getApellidos() + ", getDni()=" + getDni()
				+ ", getCochePropio()=" + getCochePropio() + "]";
	}
	
	
}
