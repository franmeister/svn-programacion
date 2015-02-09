package relacion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejecicio6_2 {

	public static void main(String[] args) {
		try {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "java", "java");
			
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();
			
			String sql="select * from depart";
			ResultSet rset = stmt.executeQuery(sql);
			
			while (rset.next()){
				int dept_no=rset.getInt("DEPT_NO");
				System.out.print (dept_no+"-");
				System.out.print (rset.getString("DNOMBRE")+"-");
				System.out.println (rset.getString("LOC"));
				
				String sql2="select * from emple where dept_no="+dept_no;
				ResultSet rset2 = stmt2.executeQuery(sql2);
				
				while (rset2.next()){
					System.out.println (rset2.getInt("EMP_NO")+"-"+rset2.getString("APELLIDO")+"-"
								+rset2.getString("OFICIO")+(rset2.getInt("DIR")+"-")
								+rset2.getString("FECHA_ALT")+"-"+rset2.getDouble("SALARIO")+"-"
								+rset2.getDouble("COMISION")+"-"+rset2.getDouble("TOTAL")+"-"
								+rset2.getInt("DEPT_NO"));
				}
				System.out.println();
				rset2.close();
			}
			rset.close();
			stmt.close();
			stmt2.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
