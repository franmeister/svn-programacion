public class practica1 {

	public static void main(String[] args) {
		int i=0, cad=0, num=0;

		while (i<args.length) {
			try {
				Integer.parseInt(args[i]);
				num++;
			} catch (Exception e) {
				cad++;
			}
			i++;
		}
		System.out.println(cad+" argumentos son cadenas.");
		System.out.println(num+" argumentos son números.");
	}

}
