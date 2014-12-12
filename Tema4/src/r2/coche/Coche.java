package r2.coche;

public class Coche {
	private String matricula;
	private double maxLitrosDeposito;
	private double maxLitrosReserva;
	private double velocidadMaxima;
	private double consumoMedio100km; 
	private boolean motorArrancado;
	private boolean estaEnReserva;
	private double numLitrosActual;
	private double velocidadActual;  //La velocidad debe ser mayor o igual a cero y se mide en km/h. 
	private double kilometraje; 
	
	public Coche(String mat, double	maxLitrosDeposito, double consumoMedio, double velocidadMax){
		this.matricula=mat;
		if(maxLitrosDeposito>0){
			this.maxLitrosDeposito=maxLitrosDeposito;
		}else{
			this.maxLitrosDeposito=50;
		}
		if(consumoMedio>0){
			this.consumoMedio100km=consumoMedio;
		}else{
			this.consumoMedio100km=7.5;
		}
		if(velocidadMax>0){
			this.velocidadMaxima=velocidadMax;
		}else{
			this.velocidadMaxima=180;
		}
		this.maxLitrosReserva=maxLitrosDeposito*0.15;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getMaxLitrosDeposito() {
		return maxLitrosDeposito;
	}

	public double getMaxLitrosReserva() {
		return maxLitrosReserva;
	}

	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public double getConsumoMedio100km() {
		return consumoMedio100km;
	}

	public boolean isMotorArrancado() {
		return motorArrancado;
	}

	public boolean isEstaEnReserva() {
		return estaEnReserva;
	}

	public double getNumLitrosActual() {
		return numLitrosActual;
	}

	public double getVelocidadActual() {
		return velocidadActual;
	}

	public double getKilometraje() {
		return kilometraje;
	}
	
	
	private boolean estaArrancado(){
		if(this.motorArrancado){
			return true;
		}
		System.out.println("El coche con matrícula "+this.matricula+" está apagado.");
		return false;
	}
	
	private void estaReserva(){
		if(this.numLitrosActual<=this.maxLitrosReserva){
			this.estaEnReserva=true;
			System.out.println("El coche con matrícula "+this.matricula+" está en reserva de combustible.");
			return;
		}
		this.estaEnReserva=false;
		
	}
	
	public void arrancarMotor(){
		if(estaArrancado()){
			System.out.println("El coche con matrícula "+this.matricula+" está ya arrancado.");
			return;
		}
		if(this.numLitrosActual>0){
			this.motorArrancado=true;
			System.out.println("El coche con matrícula "+this.matricula+" ha arrancado.");
			estaReserva();
			return;
		}
		System.out.println("El coche con matrícula "+this.matricula+" no tiene combustible.");		
	}
	
	public void pararMotor(){
		if(estaArrancado()){
			this.motorArrancado=false;
			System.out.println("El coche con matrícula "+this.matricula+" se ha apagado.");
		}
	}
	
	public void repostar(double litros){
		if(litros>0){
			this.numLitrosActual+=litros;
			if(this.numLitrosActual>this.maxLitrosDeposito){
				this.numLitrosActual=this.maxLitrosDeposito;
				System.out.println("El coche con matrícula "+this.matricula+" ha rebosado el depósito.");
			}
		}
		System.out.println("El coche con matrícula "+this.matricula+" tiene "+this.numLitrosActual+" litros de combustible.");
	}
	
	public void fijarVelocidad(double velocidad){
		if(estaArrancado()){
			if(velocidad<0){
				this.velocidadActual=0;
				System.out.println("El coche con matrícula "+this.matricula+" ha cambiado la velocidad a "+this.velocidadActual+".");
				return;
			}
			if(velocidad>this.velocidadMaxima){
				this.velocidadActual=this.velocidadMaxima;
				System.out.println("El coche con matrícula "+this.matricula+" ha cambiado la velocidad a "+this.velocidadActual+".");
				return;
			}
			this.velocidadActual=velocidad;
			System.out.println("El coche con matrícula "+this.matricula+" ha cambiado la velocidad a "+this.velocidadActual+".");
		}
	}

	public void recorrerDistancia(double km){
		double litrosNecesarios, consumoIns, distanciaReal;
		
		if(estaArrancado()){
			if(this.velocidadActual==0){
				System.out.println("El coche con matrícula "+this.matricula+" tiene velocidad 0. No recorre distancia.");
				return;
			}
			if(km<=0){
				System.out.println("Los KM no son correctos. El coche con matrícula "+this.matricula+" no recorre distancia.");
				return;
			}
			consumoIns=consumoMedio100km*(1+(velocidadActual-100)/100);
			litrosNecesarios=km*consumoIns/100;
			if(litrosNecesarios<=this.numLitrosActual){
				this.kilometraje+=km;
				this.numLitrosActual-=litrosNecesarios;
				System.out.println("El coche con matricula "+this.matricula+" ha recorrido "+km+" kilómetros.");
				estaReserva();
				return;
			}
			distanciaReal=100*numLitrosActual/consumoIns;
			this.kilometraje+=distanciaReal;
			this.numLitrosActual=0;
			estaReserva();
			System.out.println("El coche con matrícula "+this.matricula+" ha recorrido "+distanciaReal+" kilómetros.\nEl coche con matrícula "+this.matricula+" esta sin combustible.\nEl coche con matrícula "+this.matricula+" esta parado."); 
		}
	}

}