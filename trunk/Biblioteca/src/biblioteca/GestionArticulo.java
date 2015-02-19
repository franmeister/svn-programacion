package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionArticulo {
	private Connection con;

	public GestionArticulo(Connection con) {
		this.con = con;
	}
	
	private void nuevoArticulo(){
		Articulo a=new Articulo();
		a.pedirArticulo();
		
		String sql="insert into articulo values("+a.getCodArticulo()+",'"+a.getTitulo()+"','"
				+a.getAutor()+"',"+a.getNumPaginas()+")";

		try {
			Statement stmt=con.createStatement();
			int res=stmt.executeUpdate(sql);
			
			if(res==1){
				System.out.println("El art�culo se ha insertado correctamente.");
			}
			
		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}
	
	public void menu(){
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		int opcion=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Nuevo art�culo");
			System.out.println("2.Modificar art�culo");
			System.out.println("3.Borrar art�culo");
			System.out.println("4.Listar art�culos");
			System.out.println("5.Buscar art�culo");
			System.out.println("0.Volver al men� principal");
			System.out.println("Elija una opcion:");
			
			try {
				opcion=Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Error, inserte un n�mero entero.");
			} catch (IOException e) {
				System.out.println("Error al leer datos.");
			}
			
			switch (opcion) {
			case 0:
				break;
			case 1:
				this.nuevoArticulo();
				break;
			case 2:
				//this.modificarMaterial(material);
				break;
			case 3:
				//this.borrarMaterial(material);
				break;
			case 4:
				//this.listarMaterial(material);
				break;
			case 5:
				//this.buscarMaterial(material);
				break;
			default:
				System.out.println("Debe selecionar una opci�n correcta. Vuelva a intentarlo.");
				break;
			}
		}while(opcion!=0);
	}
}
