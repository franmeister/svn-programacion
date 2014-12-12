package r1;

public class PruebaTemperatura {

	public static void main(String[] args) {
		Fecha f = new Fecha();		
		f.setFecha(2, 2, 2012);
		Temperatura t=new Temperatura(f,25,20);
		System.out.println(t.toString());
		t.setTemMax(30);
		System.out.println(t.toString());

		f.setFecha(12, 2, 2014);
		Temperatura t1=new Temperatura(f,22,15);
		System.out.println(t1.toString());
	}

}
