package teoria.trabajoconficheros;

import java.io.*;

public class GestionAlumnos_enClase {
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	private BufferedReader flectura;
	private BufferedWriter fescritura;
	private File f, tmp;
	
	public GestionAlumnos_enClase(String ruta){
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
		
		registro=componerLinea(a);

		
		try {
			flectura=new BufferedReader(new FileReader(f));
			fescritura=new BufferedWriter(new FileWriter(tmp));

			try {
				String linea=flectura.readLine();
				while(linea!=null){
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
		Alumno a;
		String dni,nombre;
		double nota;
		
		dni=linea.substring(0, 10).trim();
		nombre=linea.substring(10,50).trim();
		nota=Double.parseDouble(linea.substring(50,54).trim());
		a=new Alumno(dni,nombre,nota);
		return a;
	}
	
	private void buscarAlumno(String dni){		
		try {
			flectura=new BufferedReader(new FileReader(f));
			String linea=flectura.readLine();
			while(linea!=null){
				Alumno a=descomponerLinea(linea);
				if(a.getDni().equals(dni)){
					System.out.println(a.toString());
					break;
				}
				linea=flectura.readLine();
			}
			flectura.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	private void borrarAlumno(String dni){
		try {
			flectura=new BufferedReader(new FileReader(f));
			fescritura=new BufferedWriter(new FileWriter(tmp));
			
			String linea=flectura.readLine();
			while(linea!=null){
				Alumno a=descomponerLinea(linea);
				if(!a.getDni().equals(dni)){
					fescritura.write(linea);
					fescritura.newLine();
				}
				linea=flectura.readLine();
			}
	
			fescritura.flush();
			fescritura.close();
			flectura.close();
			
			f.delete();
			tmp.renameTo(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	private void modiAlumno(String dniB){
		String dni,nombre,registro;
		double nota;
		Alumno a;
		
		try {
			flectura=new BufferedReader(new FileReader(f));
			fescritura=new BufferedWriter(new FileWriter(tmp));
			String linea=flectura.readLine();
			while(linea!=null){
				a=descomponerLinea(linea);
				if(!a.getDni().equals(dniB)){
					fescritura.write(linea);
				}else{
					try{
						System.out.println("Introduzca el nuevo DNI: ");
						dni=teclado.readLine();
						System.out.println("Introduzca el nuevo Nombre: ");
						nombre=teclado.readLine();
						System.out.println("Introduzca la nueva Nota: ");
						nota=Double.parseDouble(teclado.readLine());
					}catch(NumberFormatException e){
						System.out.println("La nota debe de ser un numero.");
						return;
					}catch (IOException e) {
						System.out.println("Error al pedir datos.");
						return;
					}
					a=new Alumno(dni,nombre,nota);
					registro=componerLinea(a);
					fescritura.write(registro);
				}
				fescritura.newLine();
				linea=flectura.readLine();
			}
		fescritura.flush();
		fescritura.close();
		flectura.close();
		
		f.delete();
		tmp.renameTo(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String componerLinea(Alumno a){
		String registro;
		registro=addEspacios(a.getDni(), 10);
		registro=registro+addEspacios(a.getNombre(), 40);
		registro=registro+addEspacios(a.getNota()+"", 4);
		return registro;
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
				this.modiAlumno(this.pedirDni());
				break;
			case 3:
				this.borrarAlumno(this.pedirDni());
				break;
			case 4:
				this.buscarAlumno(this.pedirDni());
				break;
			case 5:
				this.listarAlumnos();
				break;
			case 6:
				System.out.println("Progama terminado.");
				break;
			default:
				System.out.println("Debe introducir un numero entre 1 y 6");
				break;
			}
		}while(opcion!=6);
	}
}
