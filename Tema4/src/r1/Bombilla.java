package r1;

public class Bombilla {
    //definir los atributos
    boolean encendida;
    int potencia;
    int numEncendidos=0;
    boolean fundida;
     
    //Constructores
    public Bombilla(int potencia){
        this.potencia=potencia;
    }
     
    //definir los metodos
    private boolean fundida(){
    	if(this.fundida){ 
    		System.out.println("La bombilla de "+this.potencia+" está fundida");
    		return true;
    	}
    	return fundida;
    }
    
    public void encender(){
    	if(fundida()){ 
    		return;
    	}
        if (this.encendida){
            System.out.println("La bombilla de "+this.potencia+" ya estaba encendida");
            return;
        }
		encendida=true;
		numEncendidos++;
        if(this.numEncendidos==1000){
        	this.fundida=true;
        	this.encendida=false;
            System.out.println("La bombilla de "+this.potencia+" se ha fundido");
            return;
        }
		System.out.println("La bombilla de "+this.potencia+" vatios está encendida");
    }
     
    public void apagar(){
    	if(fundida()){ 
    		return;
    	}
        if (this.encendida){
        	encendida=false;
        	System.out.println("La bombilla de "+this.potencia+" vatios está apagada");
        	return;
        }
        System.out.println("La bombilla de "+this.potencia+" ya estaba apagada");
        
    }
     
}

/* Crea la clase Bombilla de las transparencias, ahora retoca la clase Bombilla para 
que cumpla con los siguientes requisitos: 
• Si la bombilla estaba encendida y se vuelve a encender se debe mostrar el 
mensaje “La bombilla ya estaba encendida” y no aumentar el contador de 
número encendidos. 
• Si la bombilla estaba apagada y se vuelve a apagar se debe mostrar el 
mensaje “La bombilla ya estaba apagada”. 
• Cuando se produzca el encendido 1000 la bombilla debe fundirse y escribir 
el mensaje “La bombilla se ha fundido”. En este estado, si se intenta 
encender o apagar se debe mostrar el mensaje “La bombilla está fundida”.*/