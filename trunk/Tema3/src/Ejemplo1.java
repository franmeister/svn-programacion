
public class Ejemplo1 {

	public static double media(double a, double b, double c){
		double res;
		res=(a+b+c)/3;
		res=Math.round(res*100);
		res=res/100;
		return res;
	}
	public static void main(String[] args) {
		double a=1.5,b=5.2,c=6;
		System.out.print(media(a,b,c));
	}

}
