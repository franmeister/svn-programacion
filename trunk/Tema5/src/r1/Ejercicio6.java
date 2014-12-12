package r1;

public class Ejercicio6 {

	public static boolean esVampiro(int n) {
		String num = n + "";
		int lon = num.length(), con = 0;
		int[] a = new int[lon];
		int[] m = new int[lon*3];
		
		for (int i = 0; i < lon; i++) {
			a[i] = Integer.parseInt(num.substring(i, i + 1));
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if(j!=i){
					m[con] = a[i]*10 + a[j];
					con++;
				}
			}
		}

		for (int i = 0; i < m.length; i++) {
			for (int j = i + 1; j < m.length; j++) {
				if (m[i] * m[j] == n && m[i]%10!=0 && m[j]%10!=0) {  //los dos colmillos no pueden terminar en cero)
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int nu;
		do{
			nu = PedirDatos.leerEntero("Introduce un número de cuatro cifras: ");
		}
		while(nu>9999||nu<1000);
		System.out.print(esVampiro(nu));
	}
}