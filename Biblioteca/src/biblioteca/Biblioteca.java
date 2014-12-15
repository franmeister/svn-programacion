package biblioteca;

import java.util.Vector;

public class Biblioteca {
	
	private Vector<Articulo> articulos=new Vector<Articulo>();
	private Vector<Libro> libros=new Vector<Libro>();
	private Vector<Cdrom> cdrom=new Vector<Cdrom>();
	private Vector<Revista> revistas=new Vector<Revista>();
	private Vector<Usuario> usuarios=new Vector<Usuario>();
	
	private void nuevoMaterial(String material){
		String isbn, signatura, titulo, autor, materia, editorial, nombre, apellido1, apellido2;
		int numPaginas, cod;
		
		switch (material) {
		case "Libro":
			isbn=PedirDatos.leerCadena("Introduce ISBN:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce Título:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			editorial=PedirDatos.leerCadena("Introduce Editorial:");
			this.libros.add(new Libro(isbn, signatura, titulo, autor, materia, editorial));
			break;
		case "Articulo":
			cod=PedirDatos.leerEntero("Introduce Código del Artículo:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce Título:");
			numPaginas=PedirDatos.leerEntero("Introduce número de páginas:");
			this.articulos.add(new Articulo(cod, titulo, autor, numPaginas));
			break;
		case "CD-ROM":
			cod=PedirDatos.leerEntero("Introduce Código de CD-ROM:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce Título:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			editorial=PedirDatos.leerCadena("Introduce Editorial:");
			this.cdrom.add(new Cdrom(cod, signatura, titulo, autor, materia, editorial));
			break;
		case "Revista":
			cod=PedirDatos.leerEntero("Introduce Código de Revista:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			nombre=PedirDatos.leerCadena("Introduce Nombre:");
			this.revistas.add(new Revista(cod, signatura, nombre, materia));
			break;
		case "Usuario":
			cod=PedirDatos.leerEntero("Introduce Código de Usuario:");
			nombre=PedirDatos.leerCadena("Introduce Nombre:");
			apellido1=PedirDatos.leerCadena("Introduce Primer Apellido:");
			apellido2=PedirDatos.leerCadena("Introduce Segundo Apellido:");
			this.usuarios.add(new Usuario(cod, nombre, apellido1, apellido2));
			break;
		default:
			break;
		}
	}
	
	private int buscar(String material, int cod){
		switch (material) {
		case "Revista":
			for(int i=0;i<revistas.size();i++){
				if(this.revistas.elementAt(i).getCodRevista()==cod){
					return i;
				}	
			}
			break;
		case "CD-ROM":
			for(int i=0;i<cdrom.size();i++){
				if(this.cdrom.elementAt(i).getCodCdrom()==cod){
					return i;
				}	
			}
			break;
		case "Usuario":
			for(int i=0;i<usuarios.size();i++){
				if(this.usuarios.elementAt(i).getCodUsuario()==cod){
					return i;
				}	
			}
			break;
		case "Articulo":
			for(int i=0;i<articulos.size();i++){
				if(this.articulos.elementAt(i).getCodArticulo()==cod){
					return i;
				}	
			}
			break;
		default:
			break;
		}
		return -1;
	}
	
	private int buscarLibro(String isbn){
		for(int i=0;i<libros.size();i++){
			if(this.libros.elementAt(i).getIsbn().equals(isbn)){
				return i;
			}
		}
		return -1;
	}
	
	private void modificarMaterial(String material){
		//
		if(material.equals("Libro")){
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a modificar: ");
			if(this.buscarLibro(isbn)==-1){
				System.out.println("No existe el libro con el ISBN "+isbn+".");
			}
			//modificar
			return;
		}
		int codigo=PedirDatos.leerEntero("Introduce el código del objeto a modificar: ");
		if(this.buscar(material,codigo)==-1){
			System.out.println("No existe "+material+" con el código "+codigo+".");
		}
		//modificar		
	}
	
	private void menuMaterial(String material){
		int opcion=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Nuevo "+material);
			System.out.println("2.Modificar "+material);
			System.out.println("3.Borrar "+material);
			System.out.println("0.Volver al menú principal");
			
			opcion=PedirDatos.leerEntero("Elija una opcion:");
			
			switch (opcion) {
			case 0:
				break;
			case 1:
				this.nuevoMaterial(material);
				break;
			case 2:
				this.modificarMaterial(material);
				break;
			case 3:
				//this.borrarMaterial();
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(opcion!=0);
	}
	
	public void menu(){
		int opcion=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Gestión de Libros");
			System.out.println("2.Gestión de Revistas");
			System.out.println("3.Gestión de CD-ROM");
			System.out.println("4.Gestión de Articulos");
			System.out.println("5.Gestión de Usuarios");
			System.out.println("6.Realizar Préstamo");
			System.out.println("7.Devolver Préstamo");
			System.out.println("0.Salir");
			
			opcion=PedirDatos.leerEntero("Elija una opcion:");
	
			switch (opcion) {
			case 0:
				break;
			case 1:
				this.menuMaterial("Libro");
				break;
			case 2:
				this.menuMaterial("Revista");
				break;
			case 3:
				this.menuMaterial("CD-ROM");
				break;
			case 4:
				this.menuMaterial("Artículo");
				break;
			case 5:
				this.menuMaterial("Usuario");
				break;
			case 6:
				//this.realizarPrestamo();
				break;
			case 7:
				//this.devolverPrestamo();
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(opcion!=0);
	}
}
