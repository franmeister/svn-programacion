package R3.ejercicio2;

import Relacion1.Coche2;

public class Persona {
	private String nombre;
	private String apellidos;
	private String dni;
	Vehiculo [] vehiculos=new Vehiculo [10];
	private int numVehiculosActual;
	private int vehiculoEnUso;
	int pos=0;
	
	public Persona(String nom, String apellidos, String dni){
		this.nombre=nom;
		this.apellidos=apellidos;
		this.dni=dni;
	}

	
	public String getNombre() {
		return nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public String getDni() {
		return dni;
	}



	public void compraVehiculo(Vehiculo v){
		if(pos>=10){
			System.out.println("No puede tener más de 10 vehículos la persona");
			return;
		}
		pos++;
		vehiculos[pos]=v;
		v.setPropietario(this);
		
		
	}
	
	public void eligeVehiculo(Vehiculo v, double distancia, double velocidad){
		if(pos<=0){
			System.out.println("La persona no tiene vehículo");
			return;
		}
		if(pos>0){
			vehiculos[pos]=v;
		}
		this.vehiculoEnUso=pos;
		v.fijarvelocidad(velocidad);
		v.recorrerDistancia(distancia);
		pos++;
	}
	
	public void eligeVehiculoEnUso(int num){
		num=pos;
	}
	public Vehiculo[] getVehiculos(){
		
		return vehiculos;
	}
	
	public boolean poseeVehiculo(){
		if(pos<=0){
			return false;
		}
		return true;
	}
	
	public void imprimirDatosPersonales(){
		System.out.println("Nombre: "+getNombre()+"\n Apellidos: "+getApellidos()+"\n Dni: "+getDni());
	}
}
