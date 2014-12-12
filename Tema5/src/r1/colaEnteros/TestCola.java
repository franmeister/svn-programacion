package r1.colaEnteros;

public class TestCola {

	public static void main(String[] args) {
		Cola c= new Cola();
		
		System.out.println(c.frente());

		for (int i=1;i<=100;i++){
			c.encolar(i);
		}
		c.encolar(3);


		System.out.println(c.frente());
		System.out.println(c.desencolar());
		System.out.println(c.frente());
		System.out.println(c.desencolar());
		System.out.println(c.frente());

	}

}
