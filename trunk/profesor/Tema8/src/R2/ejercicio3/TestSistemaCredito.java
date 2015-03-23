package R2.ejercicio3;

public class TestSistemaCredito {

	public static void main(String[] args) {
		Credito cr=new Credito();
		
		ClienteConDescubierto ccd=new ClienteConDescubierto();
		/*
		ccd.cargar(600);
		ccd.devuelvePagos();
		*/
		cr.solicitarCredito(ccd);
		
		ClienteConDescuentoFijo ccdf=new ClienteConDescuentoFijo();
		/*ccdf.cargar(600);
		ccdf.devuelvePagos();
		*/
		cr.solicitarCredito(ccdf);
		
		ClienteConDescuentoVariable ccdv=new ClienteConDescuentoVariable();
		/*ccdv.cargar(600);
		ccdv.devuelvePagos();
		*/
		cr.solicitarCredito(ccdv);
	}

}
