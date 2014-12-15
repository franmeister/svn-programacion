package biblioteca;

import java.util.Vector;

public class Biblioteca {
	
	private Vector<Articulo> articulos=new Vector<Articulo>();
	private Vector<Libro> libros=new Vector<Libro>();
	private Vector<Cdrom> cdrom=new Vector<Cdrom>();
	private Vector<Revista> revistas=new Vector<Revista>();
	private Vector<Usuario> usuarios=new Vector<Usuario>();
	
	private Libro crearLibro(){
		String isbn = PedirDatos.leerCadena("Introduce ISBN:");
		String signatura = PedirDatos.leerCadena("Introduce Signatura:");
		String autor = PedirDatos.leerCadena("Introduce Autor:");
		String titulo = PedirDatos.leerCadena("Introduce T�tulo:");
		String materia = PedirDatos.leerCadena("Introduce Materia:");
		String editorial = PedirDatos.leerCadena("Introduce Editorial:");
		return new Libro(isbn, signatura, titulo, autor, materia, editorial);
	}
	
	private Articulo crearArticulo(){
		int cod = PedirDatos.leerEntero("Introduce C�digo del Art�culo:");
		String autor = PedirDatos.leerCadena("Introduce Autor:");
		String titulo = PedirDatos.leerCadena("Introduce T�tulo:");
		int numPaginas = PedirDatos.leerEntero("Introduce n�mero de p�ginas:");
		return new Articulo(cod, titulo, autor, numPaginas);
	}
	
	private Cdrom crearCdrom(){
		int cod = PedirDatos.leerEntero("Introduce C�digo de CD-ROM:");
		String signatura = PedirDatos.leerCadena("Introduce Signatura:");
		String autor = PedirDatos.leerCadena("Introduce Autor:");
		String titulo = PedirDatos.leerCadena("Introduce T�tulo:");
		String materia = PedirDatos.leerCadena("Introduce Materia:");
		String editorial = PedirDatos.leerCadena("Introduce Editorial:");
		return new Cdrom(cod, signatura, titulo, autor, materia, editorial);
	}

	private Revista crearRevista(){
		int cod = PedirDatos.leerEntero("Introduce C�digo de Revista:");
		String signatura = PedirDatos.leerCadena("Introduce Signatura:");
		String materia = PedirDatos.leerCadena("Introduce Materia:");
		String nombre = PedirDatos.leerCadena("Introduce Nombre:");
		return new Revista(cod, signatura, nombre, materia);
	}
	
	private Usuario crearUsuario(){
		int cod = PedirDatos.leerEntero("Introduce C�digo de Usuario:");
		String nombre = PedirDatos.leerCadena("Introduce Nombre:");
		String apellido1 = PedirDatos.leerCadena("Introduce Primer Apellido:");
		String apellido2 = PedirDatos.leerCadena("Introduce Segundo Apellido:");
		return new Usuario(cod, nombre, apellido1, apellido2);
	}

	private void nuevoMaterial(String material){
		switch (material) {
		case "Libro":
			this.libros.add(crearLibro());
			break;
		case "Articulo":
			this.articulos.add(crearArticulo());
			break;
		case "CD-ROM":
			this.cdrom.add(crearCdrom());
			break;
		case "Revista":
			this.revistas.add(crearRevista());
			break;
		case "Usuario":
			this.usuarios.add(crearUsuario());
			break;
		default:
			break;
		}
	}
	
	private int buscar(String material, int cod){
		switch (material) {
		case "Revista":
			for(int i=0;i<revistas.size();i++){
				try{
					if(this.revistas.elementAt(i).getCodRevista()==cod){
						return i;
					}
				}catch(Exception e){}
			}
			break;
		case "CD-ROM":
			for(int i=0;i<cdrom.size();i++){
				try{
					if(this.cdrom.elementAt(i).getCodCdrom()==cod){
						return i;
					}	
				}catch(Exception e){}
			}
			break;
		case "Usuario":
			for(int i=0;i<usuarios.size();i++){
				try{
					if(this.usuarios.elementAt(i).getCodUsuario()==cod){
						return i;
					}	
				}catch(Exception e){}
			}
			break;
		case "Articulo":
			for(int i=0;i<articulos.size();i++){
				try{
					if(this.articulos.elementAt(i).getCodArticulo()==cod){
						return i;
					}	
				}catch(Exception e){}
			}
			break;
		default:
			break;
		}
		return -1;
	}
	
	private int buscarLibro(String isbn){
		for(int i=0;i<libros.size();i++){
			try{
				if(this.libros.elementAt(i).getIsbn().equals(isbn)){
					return i;
				}
			}catch(Exception e){}
		}
		return -1;
	}
	
	private void modificarMaterial(String material){
		int pos;

		if(material.equals("Libro")){
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a modificar: ");
			pos=this.buscarLibro(isbn);
			if(pos==-1){
				System.out.println("No existe el libro con el ISBN "+isbn+".");
				return;
			}
			this.libros.setElementAt(crearLibro(),pos);
			return;
		}
		int codigo=PedirDatos.leerEntero("Introduce el c�digo del objeto a modificar: ");
		pos=this.buscar(material,codigo);
		if(pos==-1){
			System.out.println("No existe "+material+" con el c�digo "+codigo+".");
			return;
		}
		switch (material) {
		case "Articulo":
			this.articulos.setElementAt(crearArticulo(),pos);
			break;
		case "CD-ROM":
			this.cdrom.setElementAt(crearCdrom(),pos);
			break;
		case "Revista":
			this.revistas.setElementAt(crearRevista(),pos);
			break;
		case "Usuario":
			this.usuarios.setElementAt(crearUsuario(),pos);
			break;
		default:
			break;	
		}
	}
	
	private void borrarMaterial(String material){
		int pos;

		if(material.equals("Libro")){
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a borrar: ");
			pos=this.buscarLibro(isbn);
			if(pos==-1){
				System.out.println("No existe el libro con el ISBN "+isbn+".");
				return;
			}
			this.libros.remove(pos);
			return;
		}
		int codigo=PedirDatos.leerEntero("Introduce el c�digo del objeto a borrar: ");
		pos=this.buscar(material,codigo);
		if(pos==-1){
			System.out.println("No existe "+material+" con el c�digo "+codigo+".");
			return;
		}
		switch (material) {
		case "Articulo":
			this.articulos.remove(pos);
			break;
		case "CD-ROM":
			this.cdrom.remove(pos);
			break;
		case "Revista":
			this.revistas.remove(pos);
			break;
		case "Usuario":
			this.usuarios.remove(pos);
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
				this.borrarMaterial(material);
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


/*package biblioteca;

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
			this.libros.add(new Libro(isbn, signatura, titulo, autor, materia, editorial));
			break;
		case "Articulo":
			cod=PedirDatos.leerEntero("Introduce C�digo del Art�culo:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce T�tulo:");
			numPaginas=PedirDatos.leerEntero("Introduce n�mero de p�ginas:");
			this.articulos.add(new Articulo(cod, titulo, autor, numPaginas));
			break;
		case "CD-ROM":
			cod=PedirDatos.leerEntero("Introduce C�digo de CD-ROM:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce T�tulo:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			editorial=PedirDatos.leerCadena("Introduce Editorial:");
			this.cdrom.add(new Cdrom(cod, signatura, titulo, autor, materia, editorial));
			break;
		case "Revista":
			cod=PedirDatos.leerEntero("Introduce C�digo de Revista:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			nombre=PedirDatos.leerCadena("Introduce Nombre:");
			this.revistas.add(new Revista(cod, signatura, nombre, materia));
			break;
		case "Usuario":
			cod=PedirDatos.leerEntero("Introduce C�digo de Usuario:");
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
		String isbn, signatura, titulo, autor, materia, editorial, nombre, apellido1, apellido2;
		int numPaginas, cod;
		if(material.equals("Libro")){
			isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a modificar: ");
			if(this.buscarLibro(isbn)==-1){
				System.out.println("No existe el libro con el ISBN "+isbn+".");
			}
			isbn=PedirDatos.leerCadena("Introduce ISBN:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce T�tulo:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			editorial=PedirDatos.leerCadena("Introduce Editorial:");
			this.libros.add(new Libro(isbn, signatura, titulo, autor, materia, editorial));
			return;
		}
		int codigo=PedirDatos.leerEntero("Introduce el c�digo del objeto a modificar: ");
		if(this.buscar(material,codigo)==-1){
			System.out.println("No existe "+material+" con el c�digo "+codigo+".");
		}
		switch (material) {
		case "Articulo":
			cod=PedirDatos.leerEntero("Introduce C�digo del Art�culo:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce T�tulo:");
			numPaginas=PedirDatos.leerEntero("Introduce n�mero de p�ginas:");
			this.articulos.setElementAt(new Articulo(cod, titulo, autor, numPaginas),codigo);
			break;
		case "CD-ROM":
			cod=PedirDatos.leerEntero("Introduce C�digo de CD-ROM:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			autor=PedirDatos.leerCadena("Introduce Autor:");
			titulo=PedirDatos.leerCadena("Introduce T�tulo:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			editorial=PedirDatos.leerCadena("Introduce Editorial:");
			this.cdrom.setElementAt(new Cdrom(cod, signatura, titulo, autor, materia, editorial),codigo);
			break;
		case "Revista":
			cod=PedirDatos.leerEntero("Introduce C�digo de Revista:");
			signatura=PedirDatos.leerCadena("Introduce Signatura:");
			materia=PedirDatos.leerCadena("Introduce Materia:");
			nombre=PedirDatos.leerCadena("Introduce Nombre:");
			this.revistas.setElementAt(new Revista(cod, signatura, nombre, materia),codigo);
			break;
		case "Usuario":
			cod=PedirDatos.leerEntero("Introduce C�digo de Usuario:");
			nombre=PedirDatos.leerCadena("Introduce Nombre:");
			apellido1=PedirDatos.leerCadena("Introduce Primer Apellido:");
			apellido2=PedirDatos.leerCadena("Introduce Segundo Apellido:");
			this.usuarios.setElementAt(new Usuario(cod, nombre, apellido1, apellido2),codigo);
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
*/