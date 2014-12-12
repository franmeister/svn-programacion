package r1;

public class Factura {
	private Producto P;
	private Cliente C;
	private int unidades;
	
	public Factura(Producto p, Cliente c, int unidades) {
		P = p;
		C = c;
		this.unidades = unidades;
	}
	
	private double importeTotal(){
		return (P.getPrecio() * this.unidades * 1.21);
	}
	
	public String toString(){
		return C.toString()+"\n\n"+this.unidades+" -- "+P.toString()+"\n\n"+
	"                               Total:  "+importeTotal();
	}
}

/*
-----------------------------------------
|				Factura					|
|---------------------------------------|
|P Producto								|
|C Cliente								|
|unidades int							|
|---------------------------------------|
|Constructores							|
|importeTotal()							|
|toString								|
-----------------------------------------
*/