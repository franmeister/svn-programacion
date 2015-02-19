package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionRevista {
	private Connection con;

	public GestionRevista(Connection con) {
		this.con = con;
	}

	private void nuevoRevista() {
		Revista r = new Revista();
		r.pedirRevista();

		String sql = "insert into revista values("+r.getCodRevista()+",'"+r.getSignatura()
				+ "','"+r.getNombre() + "','"+r.getMateria()+ "')";

		try {
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);

			if (res == 1) {
				System.out.println("El revista se ha insertado correctamente.");
			}

		} catch (SQLException e) {
			System.out.println("Error en BD.");
		}
	}

	public void menu() {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int opcion = -1;
		do {
			System.out.println("\n");
			System.out.println("1.Nuevo Revista");
			System.out.println("2.Modificar Revista");
			System.out.println("3.Borrar Revista");
			System.out.println("4.Listar Revistas");
			System.out.println("5.Buscar Revista");
			System.out.println("0.Volver al menú principal");
			System.out.println("Elija una opcion:");

			try {
				opcion = Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Error, inserte un número entero.");
			} catch (IOException e) {
				System.out.println("Error al leer datos.");
			}

			switch (opcion) {
			case 0:
				break;
			case 1:
				this.nuevoRevista();
				break;
			case 2:
				// this.modificarMaterial(material);
				break;
			case 3:
				// this.borrarMaterial(material);
				break;
			case 4:
				// this.listarMaterial(material);
				break;
			case 5:
				// this.buscarMaterial(material);
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		} while (opcion != 0);
	}
}
