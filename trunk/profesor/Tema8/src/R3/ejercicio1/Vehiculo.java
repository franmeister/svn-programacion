package R3.ejercicio1;

import Relacion1.Persona;

public abstract class Vehiculo {
	//Propiedades independientes del estado
		protected String matricula;
		protected double maxLitrosDeposito=50;
		protected double maxLitrosReserva=maxLitrosDeposito*0.15;
		protected double velocidadMaxima=180;
		protected double consumoMedio100km=7.5;
		Persona propietario;
		
		//Propiedades que definen el estado del coche
		protected boolean motorArrancado;
		private boolean estaEnReserva;
		protected double numLitrosActual;
		protected double velocidadActual;
		protected double kilometraje;
		
		
		public Vehiculo(String mat, double maxLitrosDeposito, double consumoMedio, double velocidadMax){
			this.matricula=mat;
			if((maxLitrosDeposito>0)&&(maxLitrosDeposito<50)){
				this.maxLitrosDeposito=maxLitrosDeposito;
			}
			if((consumoMedio>0)&&(consumoMedio<7.5)){
				this.consumoMedio100km=consumoMedio;
			}
			
			if((velocidadMax>0)&&(velocidadMax<180)){
				this.velocidadMaxima=velocidadMax;
			}
				
		}
		
		public boolean esArrancado(){
			if(motorArrancado){
				System.out.println("El vehículo ya está arrancado");
				return true;
			}
			return true;
		}
		
		public boolean getMotorArrancado() {
			
			return motorArrancado;
		}

		
		public boolean getEstaEnReserva() {
			if(numLitrosActual<this.maxLitrosReserva){
				
				System.out.println("El vehículo con matrícula "+this.matricula+"está en reserva de combustible");
			}
			return estaEnReserva;
		}

		public void arrancarMotor(){
			if(this.motorArrancado){
				System.out.println("El vehículo con matrícula "+this.matricula+" ya estaba arrancado");
				return;
			}
			if((this.motorArrancado)&&(numLitrosActual>0)){
				System.out.println("El motor ya estaba arrancado");
				return;
			}
				if(numLitrosActual<=0){
				this.motorArrancado=false;
				System.out.println("No queda gasolina");
				return;
				}
				
			if(this.estaEnReserva){
				System.out.println("El vehículo con matrícula "+this.matricula+" está en reserva");
				return;
			}
			
			this.motorArrancado=true;
		}
		
		public void pararMotor(){
			if(this.motorArrancado){
				System.out.println("El motor se ha parado");
			}
			this.motorArrancado=false;
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
		
		public void repostar(double litros){
			if((numLitrosActual+litros)>this.maxLitrosDeposito){
				System.out.println("El vehículo con matrícula "+this.matricula+" ha rebosado el depósito");
				numLitrosActual=this.maxLitrosDeposito;
			}else{
				this.numLitrosActual=numLitrosActual+litros;
			}
			System.out.println("El vehículo con matrícula "+this.matricula+" tiene "+this.numLitrosActual+" litros de combustible");
		}
		
		public void fijarvelocidad(double velocidad){
			if(this.esArrancado()==true){
				if(velocidad>velocidadActual){
					velocidadActual=velocidad;
					System.out.println("La nueva velocidad es "+velocidadActual+" km/h");
					return;
				}
				if(velocidad<0){
					velocidadActual=0;
					System.out.println("La velocidad actual es "+velocidadActual);
					return;
				}
			}else{
				System.out.println("El vehículo con matrícula "+this.matricula+" no se ha arrancado");
			}
			this.velocidadActual=velocidad;
		}
		
		public abstract void recorrerDistancia(double kilometros);


		
		

		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public double getMaxLitrosDeposito() {
			return maxLitrosDeposito;
		}

		public void setMaxLitrosDeposito(double maxLitrosDeposito) {
			this.maxLitrosDeposito = maxLitrosDeposito;
		}

		public double getMaxLitrosReserva() {
			return maxLitrosReserva;
		}

		public void setMaxLitrosReserva(double maxLitrosReserva) {
			this.maxLitrosReserva = maxLitrosReserva;
		}

		public double getVelocidadMaxima() {
			return velocidadMaxima;
		}
		
		public void setDistancia(double distanciarecorrida){
			double distancia=distanciarecorrida;
		}
		
		public void setVelocidadMaxima(double velocidadMaxima) {
			this.velocidadMaxima = velocidadMaxima;
		}

		public double getConsumoMedio100km() {
			return consumoMedio100km;
		}

		public void setConsumoMedio100km(double consumoMedio100km) {
			this.consumoMedio100km = consumoMedio100km;
		}

		public Persona getPropietario() {
			return propietario;
		}

		public void setPropietario(Persona propietario) {
			this.propietario = propietario;
		}
		
		public boolean poseePropietario(){
			if(getPropietario()==null){
				return false;
			}
			return true;
		}
			
		@Override
		public String toString() {
			return "Vehículo [getMatricula()=" + getMatricula()
					+ ", getMaxLitrosDeposito()=" + getMaxLitrosDeposito()
					+ ", getMaxLitrosReserva()=" + getMaxLitrosReserva()
					+ ", getVelocidadMaxima()=" + getVelocidadMaxima()
					+ ", getConsumoMedio100km()=" + getConsumoMedio100km()
					+ ", getPropietario()=" + getPropietario() + "]";
		}
		
		
}
