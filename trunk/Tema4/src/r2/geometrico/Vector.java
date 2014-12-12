package r2.geometrico;

public class Vector {
	private double a;
	private double b;
	
	public Vector(double a, double b){
		this.a=a;
		this.b=b;
	}
	
	public Vector(Punto p){
		this.a=p.getX();
		this.b=p.getY();
	}
	
	public Vector(Punto p1, Punto p2){
		this.a=p2.getX()-p1.getX();
		this.b=p2.getY()-p1.getY();
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
	
	public boolean igual(Vector v){
		if((this.a==v.getA())&&(this.b==v.getB())){
			return true;
		}
		return false;
	}
	
	public double longitud(){
		return (Math.sqrt(this.a*this.a+this.b*this.b));
	}
	
	public boolean proporcional(Vector v){
		if(this.a/v.getA() == this.b/v.getB()){
			return true;
		}
		return false;
	}
	
	public boolean perpendicular(Vector v){
		if((this.a * v.getA()+this.b * v.getB())==0){
			return true;
		}
		return false;
	}
	
	public Punto trasladar(Punto p){
		return new Punto(p.getX()+this.a,p.getY()+this.b);
	}
}
