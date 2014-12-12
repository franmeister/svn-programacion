package r1;

public class Ejercicio5 {

	public static void main(String[] args) {
		int[] a;
		a = new int[args.length];
		int tmp;
		
		for(int i=0;i<args.length;i++){
			a[i]=Integer.parseInt(args[i]);
		}
		
		for(int j=0;j<a.length-1;j++){
			for(int k=j+1;k<a.length;k++){
				if(a[j]>a[k]){
					tmp=a[j];
					a[j]=a[k];
					a[k]=tmp;
				}
			}
		}
		
		for(int l=0;l<a.length;l++){
			System.out.print(a[l]+" ");
 		}
	}

}
