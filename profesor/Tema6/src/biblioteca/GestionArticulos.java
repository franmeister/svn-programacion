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
	
	private Articulo descomponerLinea(String linea){
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
			
			f.delete();
			temp.renameTo(f);
		}catch(IOException e){
			System.out.println("Error");
		}
		
	}
	private void mostrarArticulo(){
		Articulo a;
		try{
			System.out.println("Introduzca el codigo a buscar");
			int codigo=Integer.parseInt(teclado.readLine());
			br=new BufferedReader(new FileReader(f));
			String linea=br.readLine();
			while(linea!=null){
				a=this.descomponerLinea(linea);
				if(codigo==a.getCodigoArticulo()){
					System.out.println(a);
					break;
				}
				linea=br.readLine();
			}
			br.close();
		}catch(IOException e){
			System.out.println("error");
		}
	}
	private void listarArticulo(){
		Articulo a;
		try{
			br=new BufferedReader(new FileReader(f));
			String linea=br.readLine();
			while(linea!=null){
				a=this.descomponerLinea(linea);
				System.out.println(a);
				linea=br.readLine();
			}
			br.close();
		}catch(IOException e){
			System.out.println("Consulte con el administrador");
		}
		
	}
	private void borrarArticulo(){
		Articulo a;
		try{
			System.out.println("Introduzca codigo de articulo");
			int codigo=Integer.parseInt(teclado.readLine());
			br=new BufferedReader(new FileReader(f));
			bw= new BufferedWriter(new FileWriter(temp));
			String linea=br.readLine();
			
			while (linea!=null){
				a=descomponerLinea(linea);
				if (codigo!=a.getCodigoArticulo()){
					bw.write(linea);
					bw.newLine();
				}
				linea=br.readLine();
			}
			
			bw.flush();
			bw.close();
			br.close();
			
			f.delete();
			temp.renameTo(f);
		}catch(IOException e){
			System.out.println("Consulte con el adm");
		}
		
		
	}
	private void modificarArticulo(){
		Articulo a=new Articulo();
		a.pedirArticulo();
		Articulo b;
		try{
			br=new BufferedReader(new FileReader(f));
			bw=new BufferedWriter(new FileWriter(temp));
			String linea=br.readLine();
			while(linea!=null){
				b=descomponerLinea(linea);
				if(a.getCodigoArticulo()==b.getCodigoArticulo()){
					linea=this.componerLinea(a);
				}
				bw.write(linea);
				bw.newLine();
				linea=br.readLine();
			}
			bw.flush();
			bw.close();
			br.close();
			f.delete();
			temp.renameTo(f);
		}catch(IOException e){
			System.out.println("error");
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
				this.nuevoArticulo();
				break;
			case 2:
				this.mostrarArticulo();
				break;
			case 3:
				this.modificarArticulo();
				break;
			case 4:
				this.borrarArticulo();
				break;
			case 5:
				this.listarArticulo();
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
