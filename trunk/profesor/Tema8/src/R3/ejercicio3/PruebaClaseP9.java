package R3.ejercicio3;

public class PruebaClaseP9 {

	public static void main(String[] args) {
		Persona[] p=new Persona[5]; 
		p[0]=new Persona("Lara", "Croft", "32146547-D");
		p[1]=new Persona("Pedro", "Sánchez", "32146547-D");
		p[2]=new Persona("Eva", "González", "32146547-D");
		p[3]=new Persona("Clara", "Lagos", "32146547-D");
		p[4]=new Persona("Pepito", "Jiménez", "32146547-D");
		
		Autobus a=new Autobus("654-RGP", 150, 4.2, 120, 30);
		
		a.repostar(40);
		a.arrancarMotor();
		a.subirPasajero(p[0]);
		a.subirPasajero(p[1]);
		a.subirPasajero(p[2]);
	}

}
