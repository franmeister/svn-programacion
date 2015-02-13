package trabajoconficheros;

import java.io.*;

public class GestionAlumnos {
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	private BufferedReader flectura;
	private BufferedWriter fescritura;
	private File f,ftmp;
	
	public GestionAlumnos(String ruta){
		f=new File(ruta);
		if(!f.exists()||!f.isFile()){
			System.out.println("la dirección introducida no es un fichero");
			System.exit(0);
		}
		ftmp=new File(f.getParent(),"temporal.txt");
	}
	private String addEspacios(String dato,int caracteres){
		String ret="";
		for (int i=dato.length();i<caracteres;i++){
			ret=ret+" ";
		}
		
		ret=(dato+ret).substring(0,caracteres);
		
		return ret;
	}
	
	private Alumno descomponerLinea(String linea){
		Alumno a;
		String dni,nombre;
		double nota;
		dni=linea.substring(0, 10).trim();
		nombre=linea.substring(10,50).trim();
		nota=Double.parseDouble(linea.substring(50,54).trim());
		a=new Alumno(dni,nombre,nota);
		return a;
	}
	
	private String componerLinea(Alumno a){
		String linea;
		linea=addEspacios(a.getDni(), 10);
		linea=linea+addEspacios(a.getNombre(), 40);
		linea=linea+addEspacios(a.getNota()+"", 4);
		
		return linea;

	}
	
	private void nuevoAlumno(){
		String dni,nombre,registro;
		double nota;
		Alumno a;
		try{
			System.out.println("Introduzca el DNI");
			dni=teclado.readLine();
			System.out.println("Introduzca el Nombre");
			nombre=teclado.readLine();
			System.out.println("Introduzca la Nota");
			nota=Double.parseDouble(teclado.readLine());
		}catch(NumberFormatException e){
			System.out.println("la nota debe de ser un numero.");
			return;
		}catch (IOException e) {
			System.out.println("Error al pedir datos");
			return;
		}
		
		a=new Alumno(dni,nombre,nota);
		
		registro=componerLinea(a);
		

		try {
			flectura=new BufferedReader(new FileReader(f));
			fescritura=new BufferedWriter(new FileWriter(ftmp));
			
			int contador=0;
			String linea=flectura.readLine();
			while(linea!=null){
				fescritura.write(linea);
				fescritura.newLine();
				contador++;
				if(contador==200){
					fescritura.flush();
					contador=0;
				}
				linea=flectura.readLine();
			}
			
			fescritura.write(registro);
			fescritura.flush();
			//Cierro los ficheros
			flectura.close();
			fescritura.close();
			
			f.delete();
			ftmp.renameTo(f);
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			System.out.println("Se producido un error.Consulte a su administrador");;
			//e.printStackTrace();
		}
	}
	
	private void modificarAlumno(){
		String dni,nombre;
		double nota;
		Alumno alumno,a;
		try{
			System.out.println("Introduzca el DNI");
			dni=teclado.readLine();
			System.out.println("Introduzca el Nombre");
			nombre=teclado.readLine();
			System.out.println("Introduzca la Nota");
			nota=Double.parseDouble(teclado.readLine());
		}catch(NumberFormatException e){
			System.out.println("la nota debe de ser un numero.");
			return;
		}catch (IOException e) {
			System.out.println("Error al pedir datos");
			return;
		}
		
		alumno=new Alumno(dni,nombre,nota);
		try{
			flectura=new BufferedReader(new FileReader(f));
			fescritura=new BufferedWriter(new FileWriter(ftmp));
		
			String linea=flectura.readLine();
			while(linea!=null){
				a=descomponerLinea(linea);
				if(a.getDni().equals(alumno.getDni())){
					linea=componerLinea(alumno);
				}
				fescritura.write(linea);
				fescritura.newLine();
				
				linea=flectura.readLine();
			}
			
			fescritura.flush();
			flectura.close();
			fescritura.close();
			
			f.delete();
			ftmp.renameTo(f);
		}catch(IOException e){
			System.out.println("Se producido un error.Consulte a su administrador");;
		}
	}
	
	private void listarAlumnos(){
		Alumno a;
		try {
			flectura=new BufferedReader(new FileReader(f));
			String linea=flectura.readLine();
			while(linea!=null){
				a=descomponerLinea(linea);
				System.out.println(a);
				linea=flectura.readLine();
			}
			flectura.close(); 
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			System.out.println("Se producido un error.Consulte a su administrador");;
			//e.printStackTrace();
		}
	}
	
	private void buscarAlumno(){
		Alumno a;
		System.out.println("Introduzca el DNI del Alumno a Buscar");
		try {
			String dni=teclado.readLine();
			
			flectura=new BufferedReader(new FileReader(f));
			String linea=flectura.readLine();
			while(linea!=null){
				a=descomponerLinea(linea);
				if(dni.equals(a.getDni())){
					System.out.println(a);
					break;
				}
				linea=flectura.readLine();
			}
			
			flectura.close();
			
		} catch (IOException e) {
			System.out.println("Se producido un error.Consulte a su administrador");;
		}
	}
	
	private void borrarAlumno(){
		Alumno a;
		System.out.println("Introduzca el DNI del Alumno a borrar");
		try {
			String dni=teclado.readLine();
			flectura=new BufferedReader(new FileReader(f));
			fescritura=new BufferedWriter(new FileWriter(ftmp));
			
			String linea=flectura.readLine();
			while(linea!=null){
				a=descomponerLinea(linea);
				if(!dni.equals(a.getDni())){
					fescritura.write(linea);
					fescritura.newLine();
				}
				linea=flectura.readLine();
			}
			
			fescritura.flush();
			flectura.close();
			fescritura.close();
			
			f.delete();
			ftmp.renameTo(f);
			
			
		} catch (IOException e) {
			System.out.println("Se producido un error.Consulte a su administrador");;
		}
	}
	
	public void menu(){
		int opcion=0;
		boolean seguir=true;
		
		do{
			System.out.println("1.Nuevo Alumno");
			System.out.println("2.Modificar Alumno");
			System.out.println("3.Borrar Alumno");
			System.out.println("4.Buscar Alumno");
			System.out.println("5.Listar Alumnos");
			System.out.println("6.salir");
			do{
				try{
					System.out.println("Introduzca una opción:");
					opcion=Integer.parseInt(teclado.readLine());
					seguir=true;
				}catch (Exception e) {
					System.out.println("Debe de introducir un numero entero");
					seguir=false;
				}
			}while(!seguir);
			
			switch (opcion) {
			case 1:
				this.nuevoAlumno();
				break;
			case 2:
				modificarAlumno();
				break;
			case 3:
				borrarAlumno();
				break;
			case 4:
				buscarAlumno();
				break;
			case 5:
				listarAlumnos();
				break;
			case 6:
				System.out.println("Adios!!!");
				break;
			default:
				System.out.println("Debe introducir un numero entre 1 y 6");
				break;
			}
			
		}while(opcion!=6);
	}
}
