package r2.coche;

public class PruebaCoche {

	public static void main(String[] args) {
		Coche c = new Coche("5466-FNZ", 60 , 7.1 , 200);
		c.repostar(15);
		c.arrancarMotor();
		c.fijarVelocidad(80);
		c.recorrerDistancia(10);
		c.fijarVelocidad(120);
		c.recorrerDistancia(300);
		c.pararMotor();
	}

}
