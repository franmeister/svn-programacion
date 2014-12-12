
public class PositivosNegativos {

	public static void main(String[] args) {
		int pos=0, neg=0, n;
		
		if(args.length==0){
			System.out.println("No se ha introducido ningún parámetro.");
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
					System.out.println("Error. el parámetro \""+args[i]+"\" no es un número entero, solo se puede recibir este tipo.");
				}
			}
			System.out.println(pos+" números son positivos.");
			System.out.println(neg+" números son negativos.");
		}
	}

}
