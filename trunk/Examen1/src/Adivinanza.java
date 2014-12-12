
public class Adivinanza {

	public static void main(String[] args) {
		int n=(int) (Math.round(Math.random()*9+1));
		int res, i=1;

		res=PedirDatos.leerEntero("Adivina el número que pienso, introduce uno: ");

		while(i<10){		
			if(res==n){
				System.out.println("Lo acertaste!!!");
				break;
			}else{
				res=PedirDatos.leerEntero("Error! Inténtalo de nuevo: ");
				i++;
			}
		}
	}

}
