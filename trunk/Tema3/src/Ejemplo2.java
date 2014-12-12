
public class Ejemplo2 {

	public static double areaTriangulo(double base,double altura){
		double res;
		res=(base+altura)/2;
		res=Math.round(res*1000);
		res/=1000;
		return res;
		
	}
	public static void main(String[] args) {
		double alt=13.444,bas=10.365;
		System.out.print(areaTriangulo(bas,alt));
	}

}
