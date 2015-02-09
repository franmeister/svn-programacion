package relacion1;

import java.sql.*;

public class Ejer6 {

	public static void main(String[] args) throws ClassNotFoundException {
		try {

			//CONECTAR: Asegurarnos de que el Driver se carga en memoria de java, para ello
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
			//CONECTAR: CONECTAMOS A LA BASE DE DATOS
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "java", "java");
			
			//CONSULTAR: CREAMOS UN OBJETO STATEMENT VACÍO
			Statement stmt = conn.createStatement();
			Statement stmt2=conn.createStatement();
			
			//CONSULTAR: EJECUTAMOS EL STATEMENT
			String sql="select * from depart";
			ResultSet rset = stmt.executeQuery(sql);
			String sql2="select * from emple";
			ResultSet rset2 = stmt2.executeQuery(sql2);
			
			
			//MOSTRAMOS LOS NOMBRES DE LAS COLUMNAS
			ResultSetMetaData rsmd=rset.getMetaData();
			int numColum=rsmd.getColumnCount();
			for(int i=1;i<=numColum;i++){
				System.out.print(rsmd.getColumnName(i)+"-");
				//System.out.println(rsmd.getColumnTypeName(i));
			}
			System.out.println();
			
			//PROCESAR LOS RESULTADOS
			while (rset.next()){ //AVANZAMOS SOBRE EL RESULTSET
				int dept_no=rset.getInt("DEPT_NO");
				System.out.print (dept_no+"-"); //OBTEN. VALOR COLUMNA N 
				System.out.print (rset.getString("DNOMBRE")+"-"); //OBTEN. VALOR COLUMNA N 
				System.out.println (rset.getString("LOC")); //OBTEN. VALOR COLUMNA N 
				//System.out.println (rset.getString(“COLUM1”)); //OBTIENE VALOR ATRIBUTO COLUM1
				//Los datos obtenidos son de tipo String.
				
			}
			
			System.out.println();
			
			//MOSTRAMOS LOS NOMBRES DE LAS COLUMNAS de EMPLE
			rsmd=rset2.getMetaData();
			numColum=rsmd.getColumnCount();
			for(int i=1;i<=numColum;i++){
				System.out.print(rsmd.getColumnName(i)+"-");
				//System.out.println(rsmd.getColumnTypeName(i));
			}
			System.out.println();
			
			//PROCESAR LOS RESULTADOS DE EMPLE
			while (rset2.next()){ //AVANZAMOS SOBRE EL RESULTSET
				System.out.print (rset2.getInt("EMP_NO")+"-"); //OBTEN. VALOR COLUMNA N 
				System.out.print (rset2.getString("APELLIDO")+"-"); //OBTEN. VALOR COLUMNA N 
				System.out.print (rset2.getString("OFICIO")); //OBTEN. VALOR COLUMNA N 
				System.out.print (rset2.getInt("DIR")+"-"); //OBTEN. VALOR COLUMNA N 
				System.out.print (rset2.getString("FECHA_ALT")+"-"); //OBTEN. VALOR COLUMNA N 
				System.out.print (rset2.getDouble("SALARIO")+"-"); //OBTEN. VALOR COLUMNA N 
				System.out.print (rset2.getDouble("COMISION")+"-"); //OBTEN. VALOR COLUMNA N 
				System.out.print (rset2.getDouble("TOTAL")+"-"); //OBTEN. VALOR COLUMNA N 
				System.out.println (rset2.getInt("DEPT_NO")); //OBTEN. VALOR COLUMNA N 
				//System.out.println (rset.getString(“COLUM1”)); //OBTIENE VALOR ATRIBUTO COLUM1
				//Los datos obtenidos son de tipo String. 
			}
			//Si en la BD fueran numéricos, tenemos que convertirlos con parse.
			//CERRAR: CERRAMOS LA CONEXIÓN
			rset.close();
			rset2.close();
			stmt.close();
			stmt2.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
	}
		
}
