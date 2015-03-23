package R3.ejercicio2;

public class PruebaClaseP8 {

	public static void main(String[] args) {
		Persona p1=new Persona("Lola", "Montero", "32145236-D");
		Persona p2=new Persona("Angustias", "Jiménez", "12365478-L");
		
		Coche c=new Coche("236-RGP", 50, 5.4, 150);
		
		Camion ca=new Camion("215-DPC", 100, 6.3, 160, 1000);
		Radar r=new Radar("Av/ Kansas City", 60);
		
		p1.compraVehiculo(c);
		p2.compraVehiculo(ca);
		
		c.repostar(20);
		ca.repostar(20);
		
		p1.eligeVehiculo(c, 100, 100);
		p2.eligeVehiculo(ca, 100, 70);
		c.getVelocidadActual();
		ca.getVelocidadActual();
		
		r.pasaVehiculo(c);
		r.pasaVehiculo(ca);
	}

}
