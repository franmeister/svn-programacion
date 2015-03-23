package R3.ejercicio2;

public class Radar {
	private double velocidadLimite;
	private String ubicacion;
	
	public Radar(String ubicacion, double velocidadLimite){
		this.ubicacion=ubicacion;
		if(velocidadLimite<=0){
			this.velocidadLimite=100;
			return;
		}
		this.velocidadLimite=velocidadLimite;
	}
	
	public void pasaVehiculo(Vehiculo v){
		if(v.getVelocidadActual()>=(this.velocidadLimite+15)){
			imponeMulta(v);
		}
	}
	
	public String getUbicacion(){
		return this.ubicacion;
	}
	
	public void setUbicacion(String dir){
		this.ubicacion=dir;
	}
	
	public void imponeMulta(Vehiculo v){
		System.out.println("Velocidad máxima permitida de "+this.getUbicacion()+" : "+this.velocidadLimite+"Km/h");
		System.out.println("Velocidad del vehículo "+v.getMatricula()+" : "+v.getVelocidadActual()+"Km/h");
		System.out.println("Se sanciona al propietario :"+v.getPropietario());
	}
}
