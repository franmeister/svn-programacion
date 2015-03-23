package animales;

public class Gato extends Felino {
	String nombre;
	public Gato(){
		super(20);
		nombre="Isidoro";
	}
	public void maullido(){
		System.out.println("miauuuu!!");
	}
	
	public void haceRuido(){
		super.haceRuido();
		maullido();
	}
}
