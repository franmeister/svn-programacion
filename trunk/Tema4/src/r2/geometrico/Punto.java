package r2.geometrico;

public class Punto {
	private double x;
	private double y;
	
	public Punto(double a, double b){
		this.x=a;
		this.y=b;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public boolean igual(Punto p){
		if((this.x==p.getX())&&(this.y==p.getY())){
			return true;
		}
		return false;
	}
	
	public double distancia(){
		return (Math.sqrt(this.x*this.x+this.y*this.y));
	}
}
