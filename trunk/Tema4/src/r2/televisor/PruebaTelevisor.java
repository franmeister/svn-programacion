package r2.televisor;

public class PruebaTelevisor {

	public static void main(String[] args) {
		Televisor t =new Televisor("Sony","Triniton 4",2003);
		
		t.imprimirCaracterísticas();
		t.encender();
		System.out.println("El canal actual es: "+t.obtenerCanal());
		t.bajarCanal();
		t.seleccionarCanal(23);
		t.subirCanal();
		t.cambiarVolumen(300);
		t.cambiarVolumen(50);
		t.imprimirCaracterísticas();
		t.apagar();
		t.seleccionarCanal(60);
		t.apagar();
	}

}
