package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionCdrom {
	private Connection con;

	public GestionCdrom(Connection con) {
		this.con = con;
	}

	private void nuevoCdrom() {
		Cdrom c = new Cdrom();
		c.pedirCdrom();

		String sql = "insert into cdrom values("+c.getCodCdrom()+",'"+c.getSignatura()
				+ "','"+c.getTitulo() + "','"+c.getAutor() + "','"+c.getMateria()
				+ "','" + c.getEditorial()+ "')";

		try {
			Statement stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);

			if (res == 1) {
				System.out.println("El CD-ROM se ha insertado correctamente.");
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
			System.out.println("1.Nuevo CD-ROM");
			System.out.println("2.Modificar CD-ROM");
			System.out.println("3.Borrar CD-ROM");
			System.out.println("4.Listar CD-ROMS");
			System.out.println("5.Buscar CD-ROM");
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
				this.nuevoCdrom();
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
