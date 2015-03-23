package animales;

public class Tigre extends Felino{
	String habitat;
	
	public Tigre(String habitat, int diasSinCazar){
		super(diasSinCazar);
		this.habitat=habitat;
		
	}
	public void rugido(){
		System.out.println("ooooooooooooooooooooooh!!!");
	}
	
	public void haceRuido(){
		super.haceRuido();
		this.rugido();
	}

}
