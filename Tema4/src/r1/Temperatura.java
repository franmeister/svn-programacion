package r1;

public class Temperatura {
	private Fecha f;
	private double temMax, temMin;
	
    public Temperatura(Fecha f, int temMax, int temMin){
    	super();
        this.f=f;
        this.temMax=temMax;
        this.temMin=temMin;
    }
    
    public Temperatura(){
    	
    }

	public double getTemMax() {
		return temMax;
	}

	public void setTemMax(int temMax) {
		this.temMax = temMax;
	}

	public double getTemMin() {
		return temMin;
	}

	public void setTemMin(int temMin) {
		this.temMin = temMin;
	}
    
    public double getTemMed(){
    	return (this.temMax+this.temMin)/2;
    }

	public void setF(Fecha f) {
		this.f = f;
	}

	public Fecha getF() {
		return f;
	}

	@Override
	public String toString() {
		return "fecha=" + this.f + ", temMax=" + temMax
				+ ", temMin=" + temMin + ", Temperatura Media=" + getTemMed() + "]";
	}
}



/* Crea una clase Temperatura, con los siguiente atributos:
a) Una fecha (Composición)
b) Una temperatura máxima y una temperatura mínima.
Los métodos:
c) Los constructores
d) Modificar temperaturas
e) Devolver temp. max, temp. min. y temp_media
f) toString: Que debe mostrar en pantalla la fecha, la temp. max., la temp.
min y la temp. media.*/