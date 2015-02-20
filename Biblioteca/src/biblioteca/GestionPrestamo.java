package biblioteca;

import java.sql.Connection;

public class GestionPrestamo {
	private Connection con;

	public GestionPrestamo(Connection con) {
		this.con = con;
	}
}
