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
			libros.add(new Libro(isbn, signatura, titulo, autor, materia, editorial));
			break;
		case "Articulo":
			cod=PedirDatos.leerEntero("Introduce Código del Artículo:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce Título:");
			numPaginas=PedirDatos.leerEntero("Introduce número de páginas:");
			articulos.add(new Articulo(cod, titulo, autor, numPaginas));
			break;
		case "CD-ROM":
			cod=PedirDatos.leerEntero("Introduce Código de CD-ROM:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce Título:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			editorial=PedirDatos.leerCadena("Introduce Editorial:");
			cdrom.add(new Cdrom(cod, signatura, titulo, autor, materia, editorial));
			break;
		case "Revista":
			cod=PedirDatos.leerEntero("Introduce Código de CD-ROM:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			nombre=PedirDatos.leerCadena("Introduce Nombre:");
			revistas.add(new Revista(cod, signatura, nombre, materia));
			break;
		case "Usuario":
			cod=PedirDatos.leerEntero("Introduce Código de CD-ROM:");
			nombre=PedirDatos.leerCadena("Introduce Nombre:");
			apellido1=PedirDatos.leerCadena("Introduce Primer Apellido:");
			apellido2=PedirDatos.leerCadena("Introduce Segundo Apellido:");
			usuarios.add(new Usuario(cod, nombre, apellido1, apellido2));
			break;
		default:
			break;
		}
	}
	
	private int buscar(){
		if
		return -1;
	}
	
	private void modificarMaterial(String material){
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
			libros.add(new Libro(isbn, signatura, titulo, autor, materia, editorial));
			break;
		case "Articulo":
			cod=PedirDatos.leerEntero("Introduce Código del Artículo:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce Título:");
			numPaginas=PedirDatos.leerEntero("Introduce número de páginas:");
			articulos.add(new Articulo(cod, titulo, autor, numPaginas));
			break;
		case "CD-ROM":
			cod=PedirDatos.leerEntero("Introduce Código de CD-ROM:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce Título:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			editorial=PedirDatos.leerCadena("Introduce Editorial:");
			cdrom.add(new Cdrom(cod, signatura, titulo, autor, materia, editorial));
			break;
		case "Revista":
			cod=PedirDatos.leerEntero("Introduce Código de CD-ROM:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			nombre=PedirDatos.leerCadena("Introduce Nombre:");
			revistas.add(new Revista(cod, signatura, nombre, materia));
			break;
		case "Usuario":
			cod=PedirDatos.leerEntero("Introduce Código de CD-ROM:");
			nombre=PedirDatos.leerCadena("Introduce Nombre:");
			apellido1=PedirDatos.leerCadena("Introduce Primer Apellido:");
			apellido2=PedirDatos.leerCadena("Introduce Segundo Apellido:");
			usuarios.add(new Usuario(cod, nombre, apellido1, apellido2));
			break;
		default:
			break;
		}
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
