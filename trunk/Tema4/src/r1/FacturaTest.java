package r1;

public class FacturaTest {

	public static void main(String[] args) {
		Producto P = new Producto(25,"Impresora",120.99);
		Cliente C = new Cliente("Aitor","Menta","Calle Sin Nombre nº1","333666999Y");
		Factura F = new Factura (P,C,5);
		
		System.out.print(F.toString());
	}

}
