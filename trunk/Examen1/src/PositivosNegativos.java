
public class PositivosNegativos {

	public static void main(String[] args) {
		int pos=0, neg=0, n;
		
		if(args.length==0){
			System.out.println("No se ha introducido ning�n par�metro.");
		}else{
			for (int i=0;i<args.length;i++){
				try{
					n=Integer.parseInt(args[i]);
					if(n>=0){
						pos++;
					}else{
						neg++;
					}
				}catch(Exception e){
					System.out.println("Error. el par�metro \""+args[i]+"\" no es un n�mero entero, solo se puede recibir este tipo.");
				}
			}
			System.out.println(pos+" n�meros son positivos.");
			System.out.println(neg+" n�meros son negativos.");
		}
	}

}
