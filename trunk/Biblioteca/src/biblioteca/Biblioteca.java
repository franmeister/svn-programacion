package biblioteca;

import java.util.Calendar;
import java.util.Vector;

public class Biblioteca {
	
	private Vector<Articulo> articulos=new Vector<Articulo>();
	private Vector<Libro> libros=new Vector<Libro>();
	private Vector<Cdrom> cdrom=new Vector<Cdrom>();
	private Vector<Revista> revistas=new Vector<Revista>();
	private Vector<Usuario> usuarios=new Vector<Usuario>();
	private Prestamo[] prestamos=new Prestamo[1000];
	private int posicion=0;
	
	private Libro crearLibro(){
		String isbn = PedirDatos.leerCadena("Introduce ISBN:");
		String signatura = PedirDatos.leerCadena("Introduce Signatura:");
		String autor = PedirDatos.leerCadena("Introduce Autor:");
		String titulo = PedirDatos.leerCadena("Introduce Título:");
		String materia = PedirDatos.leerCadena("Introduce Materia:");
		String editorial = PedirDatos.leerCadena("Introduce Editorial:");
		return new Libro(isbn, signatura, titulo, autor, materia, editorial);
	}
	
	private Articulo crearArticulo(){
		int cod = PedirDatos.leerEntero("Introduce Código del Artículo:");
		String autor = PedirDatos.leerCadena("Introduce Autor:");
		String titulo = PedirDatos.leerCadena("Introduce Título:");
		int numPaginas = PedirDatos.leerEntero("Introduce número de páginas:");
		return new Articulo(cod, titulo, autor, numPaginas);
	}
	
	private Cdrom crearCdrom(){
		int cod = PedirDatos.leerEntero("Introduce Código de CD-ROM:");
		String signatura = PedirDatos.leerCadena("Introduce Signatura:");
		String autor = PedirDatos.leerCadena("Introduce Autor:");
		String titulo = PedirDatos.leerCadena("Introduce Título:");
		String materia = PedirDatos.leerCadena("Introduce Materia:");
		String editorial = PedirDatos.leerCadena("Introduce Editorial:");
		return new Cdrom(cod, signatura, titulo, autor, materia, editorial);
	}

	private Revista crearRevista(){
		int cod = PedirDatos.leerEntero("Introduce Código de Revista:");
		String signatura = PedirDatos.leerCadena("Introduce Signatura:");
		String materia = PedirDatos.leerCadena("Introduce Materia:");
		String nombre = PedirDatos.leerCadena("Introduce Nombre:");
		return new Revista(cod, signatura, nombre, materia);
	}
	
	private Usuario crearUsuario(){
		int cod = PedirDatos.leerEntero("Introduce Código de Usuario:");
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
		int codigo=PedirDatos.leerEntero("Introduce el código del "+material+" a modificar: ");
		pos=this.buscar(material,codigo);
		if(pos==-1){
			System.out.println("No existe "+material+" con el código "+codigo+".");
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
		int codigo=PedirDatos.leerEntero("Introduce el código del "+material+" a borrar: ");
		pos=this.buscar(material,codigo);
		if(pos==-1){
			System.out.println("No existe "+material+" con el código "+codigo+".");
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
	
	private Calendar fechaActual(){
		 Calendar c = Calendar.getInstance();
	     return c;
	}
	
	private int estaPrestado(String material, String cod){
		try{
			for(int i=0;i<prestamos.length;i++){
				if(prestamos[i].getCodMaterial().equals(cod)){
					return i;
				}
			}
		}catch(Exception e){}
		return -1;
	}
	
	private void prestarMaterial(String material){
		int pos;
		int usuario=PedirDatos.leerEntero("Introduce el código del usuario");
		
		pos=this.buscar("Usuario", usuario);
		if(pos==-1){
			System.out.println("No existe el usuario con código "+usuario+".");
			return;
		}
		
		if(material.equals("Libro")){
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a prestar: ");
			pos=this.buscarLibro(isbn);
			if(pos==-1){
				System.out.println("No existe el libro con el ISBN "+isbn+".");
				return;
			}
			if(this.estaPrestado(material, isbn)!=-1){
				System.out.println("El libro está prestado.");
				return;
			}
			this.prestamos[posicion]=new Prestamo(usuario, isbn, material, fechaActual());
			this.posicion++;
			return;
		}
		
		int codigo=PedirDatos.leerEntero("Introduce el código del "+material+" a prestar: ");
		pos=this.buscar(material,codigo);
		if(pos==-1){
			System.out.println("No existe "+material+" con el código "+codigo+".");
			return;
		}
		if(this.estaPrestado(material, codigo+"")!=-1){
			System.out.println("El "+material+" está prestado.");
			return;
		}
		this.prestamos[posicion]=new Prestamo(usuario, codigo+"", material, fechaActual());
		this.posicion++;
	}
	
	private void devolverMaterial(String material){
		int pos;

		if(material.equals("Libro")){
			String isbn=PedirDatos.leerCadena("Introduce el ISBN del libro a devolver: ");
			pos=this.buscarLibro(isbn);
			if(pos==-1){
				System.out.println("No existe el libro con el ISBN "+isbn+".");
				return;
			}
			pos=this.estaPrestado(material, isbn);
			if(pos==-1){
				System.out.println("El libro no está prestado.");
				return;
			}
			this.prestamos[pos].setFechaPrestamo(fechaActual());
			return;
		}
			
		int codigo=PedirDatos.leerEntero("Introduce el código del "+material+" a prestar: ");
		pos=this.buscar(material,codigo);
		if(pos==-1){
			System.out.println("No existe "+material+" con el código "+codigo+".");
			return;
		}
		pos=this.estaPrestado(material, codigo+"");
		if(pos!=-1){
			this.prestamos[pos].setFechaPrestamo(fechaActual());
		}
	}
		
	private void realizarPrestamo(){
		int op=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Libro");
			System.out.println("2.Revista");
			System.out.println("3.Artículo");
			System.out.println("4.CD-ROM");
			System.out.println("0.Volver al menú principal");
			op=PedirDatos.leerEntero("Introduce material a prestar");
			
			switch (op) {
			case 0:
				break;
			case 1:
				this.prestarMaterial("Libro");
				break; 
			case 2:
				this.prestarMaterial("Revista");
				break;
			case 3:
				this.prestarMaterial("Articulo");
				break;
			case 4:
				this.prestarMaterial("CD-ROM");
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(op!=0);
		
	}
	
	private void devolverPrestamo(){
		int op=-1;
		do{
			System.out.println("\n");
			System.out.println("1.Libro");
			System.out.println("2.Revista");
			System.out.println("3.Artículo");
			System.out.println("4.CD-ROM");
			System.out.println("0.Volver al menú principal");
			op=PedirDatos.leerEntero("Introduce material a devolver");
			
			switch (op) {
			case 0:
				break;
			case 1:
				this.devolverMaterial("Libro");
				break;
			case 2:
				this.devolverMaterial("Revista");
				break;
			case 3:
				this.devolverMaterial("Articulo");
				break;
			case 4:
				this.devolverMaterial("CD-ROM");
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(op!=0);
		
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
				this.borrarMaterial(material);
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
				this.realizarPrestamo();
				break;
			case 7:
				this.devolverPrestamo();
				break;
			default:
				System.out.println("Debe selecionar una opción correcta. Vuelva a intentarlo.");
				break;
			}
		}while(opcion!=0);
	}
}