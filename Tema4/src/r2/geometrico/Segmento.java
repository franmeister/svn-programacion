package r2.geometrico;

public class Segmento {
	private Punto a;
	private Punto b;
	
	public Segmento(Punto p1, Punto p2){
		this.a=p1;
		this.b=p2;
	}

	public Punto getA() {
		return a;
	}

	public void setA(Punto a) {
		this.a = a;
	}

	public Punto getB() {
		return b;
	}

	public void setB(Punto b) {
		this.b = b;
	}
	
	public boolean igual(Segmento s){
		if((this.a.igual(s.a))&&(this.b.igual(s.b))){
			return true;
		}
		return false;
	}
	
	public double longitud(){
		return Math.sqrt(Math.pow(this.b.getX() - this.a.getX(),2)+Math.pow(this.b.getY() - this.a.getY(),2));
	}
	
	public boolean proporcional(Segmento s){
			if((this.a.getX()/s.a.getX() == this.b.getX()/s.b.getX())&&(this.a.getX()/s.a.getX() == this.b.getX()/s.b.getX())){
				return true;
			}
			return false;
	}
	
	public double pendiente(){
		return (this.b.getY()-this.a.getY())/(this.b.getX()-this.a.getX()); 
	}
	
	public boolean perpendicular(Segmento s){
		if((this.pendiente() * s.pendiente()) == -1){
			return true;
		}
		return false;
	}
	
	public boolean paralelo(Segmento s){
		if(this.pendiente() == s.pendiente()){
			return true;
		}
		return false;
	}
	
	public Punto puntoMedio(){
		return new Punto((this.b.getX()-this.a.getX()/2),(this.b.getY()-this.a.getY()/2));
	}
	
	public boolean pertenece(Punto p){
		if((this.a.getX() < p.getX()) && (p.getX() < this.b.getX()) && (this.a.getY() < p.getY())&&(p.getY() < this.b.getY())){
			if(new Vector(this.a,p).proporcional(new Vector(this.a,this.b))){
				return true;
			}
		}
		return false;
	}
	
	public Recta recta(){
		return new Recta(this.a,this.b);
	}
	
	public Recta mediatriz(){
		return recta().perpendicularPunto(this.puntoMedio());
	}
}
