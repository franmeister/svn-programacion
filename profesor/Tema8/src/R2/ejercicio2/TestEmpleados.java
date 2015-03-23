package R2.ejercicio2;

import java.util.GregorianCalendar;

public class TestEmpleados {

	public static void main(String[] args) {
		EmpleadoTemporal et=new EmpleadoTemporal("Pepe", 34, "12345678A");
		System.out.println(et);
		
		EmpleadoFijo ef=new EmpleadoFijo("Ana", 36, "87654321Z", new GregorianCalendar(2000,02,12));
		System.out.println(ef);

		EmpleadoPorHoras eh=new EmpleadoPorHoras("Juan", 28, "11111111A", 45);
		System.out.println(eh);
	}

}
