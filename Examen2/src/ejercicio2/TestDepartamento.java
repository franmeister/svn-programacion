package ejercicio2;

import java.util.Calendar;

public class TestDepartamento {

	public static void main(String[] args) {
		Departamento d1=new Departamento(20, "inform�tica");
		
		Empleado e1=new Empleado("12345678A", "JUAN MART�N P�REZ", "PROGRAMADOR", 2007, 1000, d1);
		Empleado e2=new Empleado("37654321Z", "ANA L�PEZ GONZ�LEZ", "ANALISTA", 2004, 1500, d1);
		Empleado e3=new Empleado("123321", "ANA", "ANALISTA", 2004, 1500, d1);
		Empleado e4=new Empleado("423456789", "ANA", "ANALISTA", 2004, 1500, d1);
		
		System.out.println();
		System.out.println(e1);
		System.out.println();
		System.out.println(e2);
	}
}
