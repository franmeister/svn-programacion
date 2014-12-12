package r1;

public class Producto {
	private int cod;
	private String desc;
	private double precio;
	
	public Producto(int cod, String desc, double precio) {
		this.cod = cod;
		this.desc = desc;
		this.precio = precio;
	}
	
	public Producto(){
		
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return cod + "---------------" + desc + "---------------" + precio+"€";
	}
	
	
}
/*
-----------------------------------------
|	         Producto					|
|---------------------------------------|
|codigo int								|
|descripcion String						|
|precio double							|
|---------------------------------------|
|Constructores							|
|Get's y set's							|
|toString								|
-----------------------------------------


toString:
	codigo -------- mesa ---------- precio
*/