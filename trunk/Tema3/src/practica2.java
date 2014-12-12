
public class practica2 {

	public static void main(String[] args) {
		int i=0, voc=0, num=0, con=0;

		while (i<args.length) {
			try {
				Integer.parseInt(args[i]);
				num++;
			} catch (Exception e) {
				if (args[i].equals("a") || args[i].equals("e") || args[i].equals("i") || args[i].equals("o") || args[i].equals("u")){
					voc++;
				}else{
					con++;
				}
			}
			i++;
		}
		System.out.println(voc+" argumentos son vocales.");
		System.out.println(con+" argumentos son consonantes.");
		System.out.println(num+" argumentos son números.");
	}

}
