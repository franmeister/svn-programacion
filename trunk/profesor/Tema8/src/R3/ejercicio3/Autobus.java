package R3.ejercicio3;

public class Autobus extends Vehiculo implements TransportaPasajeros {
	private int numPlazas;
	private int PasajerosActual;
	Persona[] asientos;
	public Autobus(String mat, double maxLitrosDeposito, double consumoMedio,
			double velocidadMax, int numPlazas) {
		super(mat, maxLitrosDeposito, consumoMedio, velocidadMax);
		if(numPlazas<=0){
			this.numPlazas=10;
		}
		this.numPlazas=numPlazas;
		asientos=new Persona[numPlazas];
	}

	@Override
	public boolean subirPasajero(Persona p) {
		if(this.getVelocidadActual()==0&&this.getNumPlazasLibres()>0){
			this.PasajerosActual++;
			this.asientos[this.PasajerosActual]=p;
			System.out.println(p.getNombre()+" "+p.getApellidos()+" ocupa el asiento "+this.PasajerosActual);
			return true;
		}
		System.out.println("Autobus lleno o en marcha");
		return false;
	}

	@Override
	public boolean bajarPasajero(Persona p) {
		if(this.velocidadActual==0&&this.getNumActualPasajeros()>0){
			if(this.asientos[this.PasajerosActual].equals(p)){
				System.out.println(p+" ha bajado del autobús");
				this.PasajerosActual--;
				return true;
			}else{
				System.out.println("No hay pasajeros");
				return false;
			}
		}
		System.out.println("No se puede bajar el pasajero. El autobús está en marcha o no hay pasajeros");
		return false;
	}

	@Override
	public Persona[] getEstadoOcupacion() {
		asientos=new Persona[this.PasajerosActual];
		return asientos;
	}

	@Override
	public int getNumActualPasajeros() {
		return this.PasajerosActual;
	}

	@Override
	public int getNumMaximoPasajeros() {
		return this.numPlazas;
	}

	@Override
	public int getNumPlazasLibres() {
		return this.numPlazas-this.getNumActualPasajeros();
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
		double consumoInstantaneo=(2-(this.numPlazas-this.getNumLitrosActual())/this.numPlazas)*(this.consumoMedio100km*(1+(velocidadActual-100)/100));
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
	
}
