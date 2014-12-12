package r1;

public class PruebaFecha {

	public static void main(String[] args) {
		Fecha f = new Fecha();		
		Fecha f1 = new Fecha();
		
		f.setFecha(2, 2, 2012);
		System.out.println(f.toString());
		f.setDia(-3);
		System.out.println(f.toString());
		f.setMes(10);
		System.out.println(f.toString());
		
		f1.setFecha(10, 10, 2010);
		System.out.println(f1.toString());


	}

}
