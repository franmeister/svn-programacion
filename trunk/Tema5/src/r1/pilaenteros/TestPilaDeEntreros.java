package r1.pilaenteros;

public class TestPilaDeEntreros {

	public static void main(String[] args) {
		PilaDeEnteros p=new PilaDeEnteros();
		
		p.push(1005);
		p.push(3010);
		p.push(3111);
		p.push(3333);
		for (int i=1;i<=96;i++){
			p.push(i);
		}
		
		for (int i=1;i<=100;i++){
			System.out.println(p.pop());
		}
		
		p.buscar(3333);
		System.out.print(p.getValorPila(3));
	}

}
