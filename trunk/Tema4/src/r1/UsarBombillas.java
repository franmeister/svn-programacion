package r1;

public class UsarBombillas {
	 
    public static void main(String[] args) {
        Bombilla b1=new Bombilla(80);
        Bombilla b2=new Bombilla(60);
 
        //if(!b1.fundida){
            b1.encender();
            b1.encender();

            System.out.println("La bombilla de "+b1.potencia+" se ha encendido "+b1.numEncendidos+" veces");
            b1.apagar();
            b1.apagar();
            b1.encender();
            System.out.println("La bombilla de "+b1.potencia+" se ha encendido "+b1.numEncendidos+" veces");
            b1.encender();
            System.out.println("La bombilla de "+b1.potencia+" se ha encendido "+b1.numEncendidos+" veces");


        //}
        b2.encender();
        b2.apagar();
        System.out.println("La bombilla de "+b2.potencia+" se ha encendido "+b2.numEncendidos+" veces");

         
    }
 
}
