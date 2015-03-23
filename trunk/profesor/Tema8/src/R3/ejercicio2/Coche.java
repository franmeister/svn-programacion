package R3.ejercicio2;

public class Coche extends Vehiculo{

	public Coche(String mat, double maxLitrosDeposito, double consumoMedio,
			double velocidadMax) {
		super(mat, maxLitrosDeposito, consumoMedio, velocidadMax);
	}

	@Override
	public void recorrerDistancia(double kilometros) {
		if(!this.motorArrancado){
			System.out.println("El motor no se ha arrancado");
			return;
		}
		if(velocidadActual==0){
			System.out.println("El coche est� parado");
			return;
		}
		if(kilometros<=0){
			System.out.println("Error en el programa, la distancia no puede ser menor o igual que 0");
			return;
		}
		double consumoInstantaneo=this.consumoMedio100km*(1+(velocidadActual-100)/100);
		double litrosNecesarios=kilometros*consumoInstantaneo/100;
		if(this.motorArrancado){
			if(litrosNecesarios<numLitrosActual){
				this.kilometraje=kilometraje+kilometros;
				this.numLitrosActual=numLitrosActual-litrosNecesarios;
				
				System.out.println("El conche con matr�cula "+this.matricula+" ha recorrido "+this.kilometraje+" km/h");
				if(this.getEstaEnReserva()){
					System.out.println("El coche con matr�cula "+this.matricula+" est� en reserva de combustible");
					return;
				}
			}else{
				double distanciaReal=100*(numLitrosActual/consumoInstantaneo);
				this.kilometraje=kilometraje+distanciaReal;
				this.numLitrosActual=0;
				System.out.println("El coche con matr�cula "+this.matricula+" ha recorrido "+this.kilometraje);
				System.out.println("El coche con matr�cula "+this.matricula+" est� sin combustible");
				System.out.println("El coche con matr�cula "+this.matricula+" est� parado");
			}
		
		}else{
			System.out.println("El coche con matr�cula "+this.matricula+" no se ha arrancado");
		}
		
		this.kilometraje=kilometraje+kilometros;
	}


	
}
