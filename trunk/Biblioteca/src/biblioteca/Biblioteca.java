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
			titulo=PedirDatos.leerCadena("Introduce T�tulo:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			editorial=PedirDatos.leerCadena("Introduce Editorial:");
			libros.add(new Libro(isbn, signatura, titulo, autor, materia, editorial));
			break;
		case "Articulo":
			cod=PedirDatos.leerEntero("Introduce C�digo del Art�culo:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce T�tulo:");
			numPaginas=PedirDatos.leerEntero("Introduce n�mero de p�ginas:");
			articulos.add(new Articulo(cod, titulo, autor, numPaginas));
			break;
		case "CD-ROM":
			cod=PedirDatos.leerEntero("Introduce C�digo de CD-ROM:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce T�tulo:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			editorial=PedirDatos.leerCadena("Introduce Editorial:");
			cdrom.add(new Cdrom(cod, signatura, titulo, autor, materia, editorial));
			break;
		case "Revista":
			cod=PedirDatos.leerEntero("Introduce C�digo de CD-ROM:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			nombre=PedirDatos.leerCadena("Introduce Nombre:");
			revistas.add(new Revista(cod, signatura, nombre, materia));
			break;
		case "Usuario":
			cod=PedirDatos.leerEntero("Introduce C�digo de CD-ROM:");
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
			titulo=PedirDatos.leerCadena("Introduce T�tulo:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			editorial=PedirDatos.leerCadena("Introduce Editorial:");
			libros.add(new Libro(isbn, signatura, titulo, autor, materia, editorial));
			break;
		case "Articulo":
			cod=PedirDatos.leerEntero("Introduce C�digo del Art�culo:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce T�tulo:");
			numPaginas=PedirDatos.leerEntero("Introduce n�mero de p�ginas:");
			articulos.add(new Articulo(cod, titulo, autor, numPaginas));
			break;
		case "CD-ROM":
			cod=PedirDatos.leerEntero("Introduce C�digo de CD-ROM:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce T�tulo:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			editorial=PedirDatos.leerCadena("Introduce Editorial:");
			cdrom.add(new Cdrom(cod, signatura, titulo, autor, materia, editorial));
			break;
		case "Revista":
			cod=PedirDatos.leerEntero("Introduce C�digo de CD-ROM:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			nombre=PedirDatos.leerCadena("Introduce Nombre:");
			revistas.add(new Revista(cod, signatura, nombre, materia));
			break;
		case "Usuario":
			cod=PedirDatos.leerEntero("Introduce C�digo de CD-ROM:");
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
			System.out.println("0.Volver al men� principal");
			
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
				System.out.println("Debe selecionar una opci�n correcta. Vuelva a intentarlo.");
				break;
			}
		}while(opcion!=0);
	}
	
	public void menu(){
		int opcion=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Gesti�n de Libros");
			System.out.println("2.Gesti�n de Revistas");
			System.out.println("3.Gesti�n de CD-ROM");
			System.out.println("4.Gesti�n de Articulos");
			System.out.println("5.Gesti�n de Usuarios");
			System.out.println("6.Realizar Pr�stamo");
			System.out.println("7.Devolver Pr�stamo");
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
				this.menuMaterial("Art�culo");
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
				System.out.println("Debe selecionar una opci�n correcta. Vuelva a intentarlo.");
				break;
			}
		}while(opcion!=0);
	}
}
