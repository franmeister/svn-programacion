import java.sql.*;


public class EmplePorDepart {

	public static void main(String[] args) throws ClassNotFoundException {
		//CONECTAR: Asegurarnos de que el Driver se carga en memoria de java, para ello
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		try {
			//CONECTAR: CONECTAMOS A LA BASE DE DATOS
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "java", "java");
			
			//CONSULTAR: CREAMOS UN OBJETO STATEMENT VACÍO
			Statement stmtDepart=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmtEmple=conn.createStatement();
			
			//CONSULTAR: EJECUTAMOS EL STATEMENT
			String sqlDepart="select * from depart";
			ResultSet rsetDepart = stmtDepart.executeQuery(sqlDepart);
			
			
			String sqlEmple;
			ResultSet rsetEmple;
			
			while(rsetDepart.next()){
				System.out.print(rsetDepart.getInt("DEPT_NO")+"-");
				System.out.print(rsetDepart.getString("DNOMBRE")+"-");
				System.out.println(rsetDepart.getString("LOC"));
				
				sqlEmple="Select * from emple where dept_no="+rsetDepart.getInt("DEPT_NO");
				rsetEmple=stmtEmple.executeQuery(sqlEmple);
				while(rsetEmple.next()){
					System.out.print (rsetEmple.getInt("EMP_NO")+"-"); //OBTEN. VALOR COLUMNA N 
					System.out.print (rsetEmple.getString("APELLIDO")+"-"); //OBTEN. VALOR COLUMNA N 
					System.out.print (rsetEmple.getString("OFICIO")); //OBTEN. VALOR COLUMNA N 
					System.out.print (rsetEmple.getInt("DIR")+"-"); //OBTEN. VALOR COLUMNA N 
					System.out.print (rsetEmple.getString("FECHA_ALT")+"-"); //OBTEN. VALOR COLUMNA N 
					System.out.print (rsetEmple.getDouble("SALARIO")+"-"); //OBTEN. VALOR COLUMNA N 
					System.out.print (rsetEmple.getDouble("COMISION")+"-"); //OBTEN. VALOR COLUMNA N 
					System.out.print (rsetEmple.getDouble("TOTAL")+"-"); //OBTEN. VALOR COLUMNA N 
					System.out.println (rsetEmple.getInt("DEPT_NO")); //OBTEN. VALOR COLUMNA N 
					
				}
				rsetEmple.close();
			}
			rsetDepart.close();
			stmtEmple.close();
			stmtDepart.close();
			conn.close();
		}catch(SQLException e){
			System.out.println("Error");
		}
		

	}

}
