package teoria.trabajoconficheros;

import java.io.*;

public class GestionAlumnos {
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	private BufferedReader flectura;
	private BufferedWriter fescritura;
	private File f, tmp;
	
	public GestionAlumnos(String ruta){
		f=new File(ruta);
		
		if(!f.exists()||!f.isFile()){
			System.out.println("La dirección introducida no es un fichero.");
			System.exit(0);
		}
		tmp=new File(f.getParent(),"temporal");
		
		/*
		try {
			flectura=new BufferedReader(new FileReader(f));
			//fescritura=new BufferedWriter(new FileWriter(f));
			flectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("la dirección introducida no es un fichero");
			System.exit(0);
		} catch (IOException e){
			System.out.println("Error en el fichero de escritura");
			System.exit(0);
		}*/
		
	}
	private String addEspacios(String dato,int caracteres){
		String ret="";
		for (int i=dato.length();i<caracteres;i++){
			ret=ret+" ";
		}
		
		ret=(dato+ret).substring(0,caracteres);
		
		return ret;
	}
	
	private void nuevoAlumno(){
		String dni,nombre,registro;
		double nota;
		Alumno a;
		
		try{
			System.out.println("Introduzca el DNI: ");
			dni=teclado.readLine();
			System.out.println("Introduzca el Nombre: ");
			nombre=teclado.readLine();
			System.out.println("Introduzca la Nota: ");
			nota=Double.parseDouble(teclado.readLine());
		}catch(NumberFormatException e){
			System.out.println("La nota debe de ser un numero.");
			return;
		}catch (IOException e) {
			System.out.println("Error al pedir datos.");
			return;
		}
		
		a=new Alumno(dni,nombre,nota);
		
		registro=addEspacios(a.getDni(), 10);
		registro=registro+addEspacios(a.getNombre(), 40);
		registro=registro+addEspacios(a.getNota()+"", 4);
		
		try {
			flectura=new BufferedReader(new FileReader(f));
			fescritura=new BufferedWriter(new FileWriter(tmp));

			try {
				String linea=flectura.readLine();
				while(linea!=null){
					//fescritura.write(new Alumno(linea.substring(0, 9), linea.substring(10, 50), Double.parseDouble(linea.substring(50, 54))).toString());
					fescritura.write(linea);
					fescritura.newLine();
					linea=flectura.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			fescritura.write(registro);
			fescritura.flush();
			fescritura.close();
			flectura.close();
			
			f.delete();
			tmp.renameTo(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void listarAlumnos(){
		try {
			flectura=new BufferedReader(new FileReader(f));
			String linea=flectura.readLine();
			while(linea!=null){
				System.out.println(descomponerLinea(linea).toString());
				linea=flectura.readLine();
			}
			flectura.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private Alumno descomponerLinea(String linea){
		//return new Alumno(linea.substring(0, 9), linea.substring(10, 50), Double.parseDouble(linea.substring(50, 54)));
		Alumno a;
		String dni,nombre;
		double nota;
		
		dni=linea.substring(0, 10).trim();
		nombre=linea.substring(10,50).trim();
		nota=Double.parseDouble(linea.substring(50,54).trim());
		a=new Alumno(dni,nombre,nota);
		return a;
	}
	
	private int buscarAlumno(String dni){
		int pos=1;
		
		try {
			flectura=new BufferedReader(new FileReader(f));
			String linea=flectura.readLine();
			while(linea!=null){
				if(descomponerLinea(linea).getDni().equals(dni)){
					flectura.close();
					return pos;
				}
				pos++;
				linea=flectura.readLine();
			}
			flectura.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	private String pedirDni(){
		String dni="";
		try {
			System.out.println("Introduzca el DNI de un alumno: ");
			dni = teclado.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dni;
	}
	
	private boolean borrarAlumno(String dni){
		int i=1,pos=this.buscarAlumno(dni);
		if(pos!=-1){
			try {
				flectura=new BufferedReader(new FileReader(f));
				fescritura=new BufferedWriter(new FileWriter(tmp));
				try {
					String linea=flectura.readLine();
					while(linea!=null){
						if(i!=pos){
							fescritura.write(linea);
							fescritura.newLine();
						}
						linea=flectura.readLine();
						i++;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		
				fescritura.flush();
				fescritura.close();
				flectura.close();
				
				f.delete();
				tmp.renameTo(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//System.out.println("El alumno con DNI "+dni+" se ha borrado correctamente.");
			return true;
		}
		return false;
		//System.out.println("El alumno con DNI "+dni+" no existe.");
	}
	
	public void menu(){
		int opcion=0;
		boolean seguir=true;
		
		do{
			System.out.println("1. Nuevo Alumno");
			System.out.println("2. Modificar Alumno");
			System.out.println("3. Borrar Alumno");
			System.out.println("4. Buscar Alumno");
			System.out.println("5. Listar Alumnos");
			System.out.println("6. Salir");
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
				if(this.borrarAlumno(this.pedirDni())){
					this.nuevoAlumno();
					break;
				}
				System.out.println("El alumno no existe.");
				break;
			case 3:
				if(this.borrarAlumno(this.pedirDni())){
					System.out.println("El alumno se ha borrado correctamente.");
					break;
				}
				System.out.println("El alumno no existe.");
				break;
			case 4:
				System.out.println(this.buscarAlumno(this.pedirDni()));
				break;
			case 5:
				this.listarAlumnos();
				break;
			case 6:
				break;
			default:
				System.out.println("Debe introducir un numero entre 1 y 6");
				break;
			}
		}while(opcion!=6);
	}
}
