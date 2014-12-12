
public class Nota {

	public static void main(String[] args) {
		String res="Suspenso";
		double nota;
		
		do{
			nota=PedirDatos.leerDecimal("Introduce nota: ");
		}while((nota>10)||(nota<0));
		
		if(nota>=5){
			res="Aprobado";
			if(nota>=7){
				res="Notable";
				if(nota>=9){
					res="Sobresaliente";
					if(nota==10){
						res="Matrícula de honor";
					}
				}
			}
		}
		System.out.print(res);

	}
}

