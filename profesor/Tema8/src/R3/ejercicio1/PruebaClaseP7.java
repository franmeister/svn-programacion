package R3.ejercicio1;

public class PruebaClaseP7 {

	public static void main(String[] args) {
		Coche c=new Coche("4544-FNJ", 60, 5.9, 180);
		
		Camion ca=new Camion("8899-ZTR", 100, 9.4, 170, 1000);
		
		ca.repostar(20);
		c.repostar(20);
		ca.carga(1000);
		
		ca.arrancarMotor();
		c.arrancarMotor();
		
		c.fijarvelocidad(100);
		ca.fijarvelocidad(100);
		
		ca.recorrerDistancia(100);
		c.recorrerDistancia(100);
		
		c.getNumLitrosActual();
		ca.getNumLitrosActual();
		
		c.getPropietario();
	}

}
