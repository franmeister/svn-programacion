package r1;

public class PruebaBombilla {
	public static void main(String[] args) {
		int i;
		Bombilla b = new Bombilla(80);
		// Creamos un objeto bombilla

		// La encendemos y apagamos 1000 veces
		for (i = 1; i <= 1000; i++) {
			b.encender();
			b.apagar();
		}
		// Y otra vez más, aunque ya debe estar fundida
		b.encender();
		b.encender();
		b.encender();
		b.apagar();
	}
}