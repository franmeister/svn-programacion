import java.util.Scanner;

public class suma {

	public static void main(String[] args) {
		int i = 0, u = 0, c = 0, d = 0, m = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Introduce número: ");
		int n = s.nextInt();
		s.close();
		while (i < n) {
			if (u == 9) {
				u = 0;
				d++;
			} else {
				u++;
			}
			if (d == 10) {
				d = 0;
				c++;
			}
			if (c == 10){
				c = 0;
				m++;
			}
			i++;
			//System.out.println(u + "  " + d + "   " + i);
		}
		System.out.println(m+" + "+c + " + " + d + " + " + u + " = "+(m+c+d+u));
	}
}
