package trabajoconficheros;

import java.io.*;

public class GestionAlumnos {
	private BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	private BufferedReader flectura;
	private BufferedWriter fescritura;
	private File f;
	
	public GestionAlumnos(String ruta){
		f=new File(ruta);
		
		try {
			//flectura=new BufferedReader(new FileReader(f));
			fescritura=new BufferedWriter(new FileWriter(f));
		} catch (FileNotFoundException e) {
			System.out.println("la dirección introducida no es un fichero");
			System.exit(0);
		} catch (IOException e){
			System.out.println("Error en el fichero de escritura");
			System.exit(0);
		}
		
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
		
		registro=addEspacios(a.getDni(), 10);
		registro=registro+addEspacios(a.getNombre(), 40);
		registro=registro+addEspacios(a.getNota()+"", 4);
		
		try {
			fescritura.write(registro);
			fescritura.flush();
			fescritura.close();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
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
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
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
