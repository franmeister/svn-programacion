import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ModificarDepart {

	public static void main(String[] args) throws ClassNotFoundException {
		//CONECTAR: Asegurarnos de que el Driver se carga en memoria de java, para ello
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		try {
			//CONECTAR: CONECTAMOS A LA BASE DE DATOS
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "java", "java");
			
			//CONSULTAR: CREAMOS UN OBJETO STATEMENT VACÍO
			Statement stmtDepart=conn.createStatement();
			//String sql="insert into depart (dept_no, dnombre,loc) values (50,'PROGRAMACION','CORDOBA')";
			//String sql="delete depart where dept_no=50";
			String sql="update depart set loc='CORDOBA' where dept_no=40";
			int res=stmtDepart.executeUpdate(sql);
			System.out.println("Se han actualizado "+res+" filas");
			
			stmtDepart.close();
			conn.close();
		}catch(SQLException e){
			System.out.println("Error");
		}
	}

}
