package R3.ejercicio2;

public class Camion extends Vehiculo{
	protected double KilosMaxCarga;
	protected double KilosCargaActual;
	
	public Camion(String mat, double maxLitrosDeposito, double consumoMedio,
			double velocidadMax, double KilosMaxCarga) {
		super(mat, maxLitrosDeposito, consumoMedio, velocidadMax);
		this.KilosMaxCarga=KilosMaxCarga;
	}
	@Override
	public void recorrerDistancia(double kilometros) {
		if(!this.motorArrancado){
			System.out.println("El motor no se ha arrancado");
			return;
		}
		if(velocidadActual==0){
			System.out.println("El coche está parado");
			return;
		}
		if(kilometros<=0){
			System.out.println("Error en el programa, la distancia no puede ser menor o igual que 0");
			return;
		}
		double consumoInstantaneo=(2-(this.getKilosMaxCarga()-this.getKilosCargaActual())/this.getKilosMaxCarga())*(this.consumoMedio100km*(1+(velocidadActual-100)/100));
		double litrosNecesarios=kilometros*consumoInstantaneo/100;
		if(this.motorArrancado){
			if(litrosNecesarios<numLitrosActual){
				this.kilometraje=kilometraje+kilometros;
				this.numLitrosActual=numLitrosActual-litrosNecesarios;
				
				System.out.println("El conche con matrícula "+this.matricula+" ha recorrido "+this.kilometraje+" km/h");
				if(this.getEstaEnReserva()){
					System.out.println("El coche con matrícula "+this.matricula+" está en reserva de combustible");
					return;
				}
			}else{
				double distanciaReal=100*(numLitrosActual/consumoInstantaneo);
				this.kilometraje=kilometraje+distanciaReal;
				this.numLitrosActual=0;
				System.out.println("El coche con matrícula "+this.matricula+" ha recorrido "+this.kilometraje);
				System.out.println("El coche con matrícula "+this.matricula+" está sin combustible");
				System.out.println("El coche con matrícula "+this.matricula+" está parado");
			}
		
		}else{
			System.out.println("El coche con matrícula "+this.matricula+" no se ha arrancado");
		}
		
		this.kilometraje=kilometraje+kilometros;
		
	}
		
	public double getKilosMaxCarga() {
		return KilosMaxCarga;
	}
	
	public double getKilosCargaActual() {
		return KilosCargaActual;
	}
	
	public void carga(double kilos){
		this.KilosCargaActual=this.getKilosCargaActual()+kilos;
	}
	
	public void descarga(double kilos){
		this.KilosCargaActual=this.getKilosCargaActual()-kilos;
	}
	
	
}
