package biblioteca;

import java.io.*;

public class GestionArticulos {
	File f,temp;
	BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	BufferedReader br;
	BufferedWriter bw;
	
	public GestionArticulos(File f){
		this.f=f;
		this.temp=new File(f.getParent(),"temporal.txt");
	}
	private String componerLinea(Articulo a){
		String linea="";
		linea=addEspacios(a.getCodigoArticulo()+"", 20);
		linea=linea+addEspacios(a.getTitulo(), 30);
		linea=linea+addEspacios(a.getAutor(), 40);
		linea=linea+addEspacios(a.getNumeroPaginas()+"", 3);
		return linea;
	}
	
	private String addEspacios(String cadena, int longitud){
		String cad="";
		
		for(int i=cadena.length();i<longitud;i++){
			cad=cad+" ";
		}
		cad=cadena+cad;
		cad=cad.substring(0, longitud);
		return cad;
	}
	
	private Articulo decomponerLinea(String linea){
		Articulo a=new Articulo();
		a.setCodigoArticulo(Integer.parseInt(linea.substring(0, 20).trim()));
		a.setTitulo(linea.substring(20, 50).trim());
		a.setAutor(linea.substring(50, 90).trim());
		a.setNumeroPaginas(Integer.parseInt(linea.substring(90, 93).trim()));
		return a;
	}
	
	private void nuevoArticulo(){
		Articulo a= new Articulo();
		a.pedirArticulo();
		try{
			br=new BufferedReader(new FileReader(f));
			bw=new BufferedWriter(new FileWriter(temp));
			String linea;
			linea=br.readLine();
			while(linea!=null){
				bw.write(linea);
				bw.newLine();
				linea=br.readLine();
			}
			linea=componerLinea(a);
			bw.write(linea);
			bw.newLine();
			bw.flush();
			br.close();
			bw.close();
		}catch(IOException e){
			
		}
	}
	
	private void listarArticulo(){
		Articulo a;
		try{
			br=new BufferedReader(new FileReader(f));
			String linea=br.readLine();
			while(linea!=null){
				a=this.decomponerLinea(linea);
				System.out.println(a);
				linea=br.readLine();
			}
			br.close();
		}catch(IOException e){
			System.out.println("Consulte con el administrador");
		}
		
	}
	public void menu() {
		int opcion = 0;
		boolean seguir = true;

		do {
			System.out.println("1.Añadir Articulo");
			System.out.println("2.Mostrar un Articulo");
			System.out.println("3.Modificar un Articulo");
			System.out.println("4.Borrar un Articulo");
			System.out.println("5.Listar todos los Articulos");
			System.out.println("6.salir");
			do {
				try {
					System.out.println("Introduzca una opción:");
					opcion = Integer.parseInt(teclado.readLine());
					seguir = true;
				} catch (Exception e) {
					System.out.println("Debe de introducir un numero entero");
					seguir = false;
				}
			} while (!seguir);

			switch (opcion) {
			case 1:
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

		} while (opcion != 6);
	}
}
