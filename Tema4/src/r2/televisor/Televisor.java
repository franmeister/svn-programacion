package r2.televisor;

public class Televisor {
	private String marca;
	private String modelo;
	private int anio; // entero entre 1950 y 2200
	private boolean panoramica;
	private boolean stereo;
	private boolean encendida;
	private int volumen; // entero entre 0 y 100
	private int canal; // entero entre 0 y 99
	
	public Televisor(String marcaIni, String modeloIni, int anioIni){
		this.marca=marcaIni;
		this.modelo=modeloIni;
		if(anioIni<=2200 && anioIni>=1950){
			this.anio=anioIni;
			return;
		}
		this.anio=2000;
	}
	
	private boolean estaEncendida(){
		if(!this.encendida){
			System.out.println("Televisor apagado.");
			return false;
		}
		return true;
	}
	
	public void encender(){
		if(!this.encendida){
			this.encendida=true;
			System.out.println("La televisión está encendida.");
		}
	}
	
	public void apagar(){
		if(this.encendida){
			this.encendida=false;
			System.out.println("La televisión está apagada.");
		}
	}
	
	public void seleccionarCanal(int nuevoCanal){
		if(estaEncendida()){
			if(nuevoCanal>=0 && nuevoCanal<=99){
				this.canal=nuevoCanal;
				System.out.println("El canal actual es: "+this.canal);
				return;
			}
		System.out.println("Canal erróneo.");
		}
	}
	
	public int obtenerCanal(){
		if(estaEncendida()){
			return this.canal;
		}
		return 0;
		
	}
	
	public void subirCanal(){
		if(estaEncendida()){
			if(this.canal>0 && this.canal<99){
				this.canal++;
				System.out.println("El canal actual es: "+this.canal);
				return;
			}
			System.out.println("Canal erróneo.");
		}
	}
	
	public void bajarCanal(){
		if(estaEncendida()){
			if(this.canal>0 && this.canal<99){
				this.canal--;
				System.out.println("El canal actual es: "+this.canal);
				return;
			}
			System.out.println("Canal erróneo.");
		}
	}
	
	public void cambiarVolumen(int nuevoVolumen){
		if(estaEncendida()){
			if(nuevoVolumen>=0 && nuevoVolumen<=100){
				this.volumen=nuevoVolumen;
				System.out.println("El volumen actual es: "+this.volumen);
				return;
			}
			System.out.println("Volumen erróneo.");
		}
	}
	
	public void imprimirCaracterísticas(){
		System.out.println("Televisor [marca=" + marca + ", modelo=" + modelo + ", año="
				+ anio + ", panoramica=" + panoramica + ", stereo=" + stereo
				+ ", encendida=" + encendida + ", volumen=" + volumen
				+ ", canal=" + canal + "]");
	}

}
