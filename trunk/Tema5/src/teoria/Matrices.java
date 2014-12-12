package teoria;

public class Matrices {
	public static void main(String[] args) {
		int[][] m=new int[2][6];
		
		m[0][0]=10;
		m[0][1]=20;
		m[0][2]=30;
		m[0][3]=40;
		m[1][0]=50;
		m[1][1]=60;
		m[1][2]=70;
		m[1][3]=80;
		m[1][4]=90;
		m[1][5]=100;
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[i].length;j++){
				System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
		
		
		
		int[] a={1,2,3,4};
		int[] b={5,6,7,8};
		
		int[][] n={a,b};
	}

}
