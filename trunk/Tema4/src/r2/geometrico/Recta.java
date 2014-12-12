package r2.geometrico;

public class Recta {
	private Punto p;
	private Vector v;
	
	public Recta(Punto p, Vector v){
		this.p=p;
		this.v=v;
	}
	
	public Recta(Vector v){
		this.v=v;
		this.p=new Punto(0,0);
	}
	
	public Recta(Punto p1, Punto p2){
		this.p=p1;
		this.v=new Vector(p2.getX(),p2.getY());
		}

	public Punto getP() {
		return p;
	}

	public void setP(Punto p) {
		this.p = p;
	}

	public Vector getV() {
		return v;
	}

	public void setV(Vector v) {
		this.v = v;
	}

	public boolean igual(Recta r){
		if((this.v.igual(r.v))&&(this.p.igual(r.p))){
			return true;
		}
		return false;
	}
	
	public boolean perpendicular(Recta r){
		if(this.v.perpendicular(r.v)){
			return true;
		}
		return false;
	}
	
	public boolean paralelo(Recta r){
		if(this.v.getA()/r.v.getA() == this.v.getB()/r.v.getB()){
			return true;
		}
		return false;
	}
	
	public boolean pertenece(Punto p){
		 if(p.getY()==this.v.getA()*p.getX()+this.v.getB()){
			 return true;
		 }
		 return false;
	}
	
	public Recta paralelaPunto(Punto p){
		return new Recta(p,this.v);
	}
	
	public Recta perpendicularPunto(Punto p){
		return new Recta(p,new Vector(this.v.getA(),-this.v.getB()));
	}
}
