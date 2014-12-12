package teoria;

public class Vectores {

	public static void main(String[] args) {
		
		int[] a={1,2,3,4,5,6,7,8,9};
		
		for(int i=0;i<a.length;i++){
			//System.out.println(a[i]);
		}
		int[] b=new int[6];
		b[0]=1;
		b[1]=2;
		b[5]=6;

		String[] cadenas=new String[3];
		cadenas[0]="Hola";
		cadenas[1]="a";
		cadenas[2]="todos";
		
		for(int i=0;i<cadenas.length;i++){
			System.out.print(cadenas[i]+" ");
		}
		
		String[] cadenas2={"Hola","a","todos"};
		
	}

}
