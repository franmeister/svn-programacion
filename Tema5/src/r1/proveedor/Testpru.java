package r1.proveedor;

public class Testpru {

	public static void main(String[] args) {
		int opcion=0;
		String nom,dir,tel;
		Empresa em=new Empresa();
		
		do{
			System.out.println("\n");
			System.out.println("1.Crear Proveedor");
			System.out.println("2.Listar Proveedores");
			System.out.println("3.Buscar Proveedor");
			System.out.println("4.Borrar Proveedor");
			System.out.println("5.Modificar Proveedor");
			System.out.println("6.Comprar a Proveedor");
			System.out.println("7.Ver Total Adeudado");
			System.out.println("8.Salir");
			//System.out.println();
			
			opcion=PedirDatos.leerEntero("Elija una opcion:");
			
			switch (opcion) {
			case 1:
				nom=PedirDatos.leerCadena("Introduce nombre de proveedor: ");
				dir=PedirDatos.leerCadena("Introduce dirección: (puede ser nulo)");
				tel=PedirDatos.leerCadena("Introduce teléfono: (puede ser nulo)");

				if(em.crearProveedor(nom, dir, tel)){
					System.out.println("Se ha creado correctamente.");
					break;
				}
				System.out.println("No se ha podido crear.");
				break;
			case 2:
				em.listarProveedores();
				break;
			case 3:
				nom=PedirDatos.leerCadena("Introduce nombre de proveedor a buscar: ");
				try{
					System.out.println(em.mostrarProveedor(nom));
				}catch(NullPointerException e){
					System.out.println("El proveedor "+nom+" no existe.");
				}
				break;
			case 4:
				nom=PedirDatos.leerCadena("Introduce nombre de proveedor a borrar: ");
				try{
					em.borrarProveedor(nom);
					System.out.println("El proveedor "+nom+" se ha borrado correctamente.");
				}catch(NullPointerException e){
					System.out.println("El proveedor "+nom+" no existe.");
				}
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				break;
			default:
				System.out.println("Error. Introduce un número de 1 a 8.");
				break;
			}
		}while(opcion!=8);
	}
}
