package animales;

public class Felino extends Mamifero{
	protected int diasSinCazar;
	
	public Felino(int diasSinCazar){
		diasSinCazar=this.diasSinCazar;
	}
	
	public void caza(){
		
	}
	
	public void haceRuido(){
		super.haceRuido();
		System.out.println("Elije un felino concreto");
	}
}
