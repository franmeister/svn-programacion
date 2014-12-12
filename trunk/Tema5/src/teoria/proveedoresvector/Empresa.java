package teoria.proveedoresvector;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import javax.net.ssl.ExtendedSSLSession;

public class Empresa {
	private Vector<Proveedor> proveedores=new Vector<Proveedor>();
	private int genCodigo=10000;
	
	public Empresa(){
		proveedores.setSize(10000);
	}
	
	private void nuevoProveedor(){
		Proveedor p;
		Scanner teclado=new Scanner(System.in);
		String nombre,sino;
		System.out.println("Introduzca el nombre del proveedor");
		nombre=teclado.nextLine();
		if(this.buscarProveedor(nombre)>-1){
			System.out.println("El proveedor "+nombre+" ya existe");
			System.out.println("No se puede volver a crear");
			return;
		}
		System.out.println("Desea introducir mas datos del proveedor(s/n)?");
		sino=teclado.nextLine();
		
		if(sino.equals("s")){
			System.out.println("Introduzca la dirección");
			String direccion=teclado.nextLine();
			System.out.println("Introduzca el teléfono");
			String telefono=teclado.nextLine();
			p=new Proveedor(genCodigo,nombre,direccion,telefono);
		}else{
			p=new Proveedor(genCodigo,nombre);
		}
		proveedores.add(genCodigo, p);
		genCodigo++;
	}
	
	private void listarProveedor(){
		Proveedor p;
		for(int i=10000;i<genCodigo;i++){
			try{
				p=(Proveedor)proveedores.elementAt(i);
				System.out.println(p+"\n");
			}catch (Exception e){
			}
		}
	}
	
	private int buscarProveedor(String nombre){
		Proveedor p;
		for(int i=10000;i<genCodigo;i++){
			try{
				p=(Proveedor)proveedores.elementAt(i);
				if(p.getNombre().equals(nombre)){
					return i;
				}
			}catch(Exception e){
				
			}
		}
		return -1;
	}
	private int buscarProveedor(Proveedor p){
		Proveedor p1;
		for(int i=10000;i<genCodigo;i++){
			try{
				p1=(Proveedor)proveedores.elementAt(i);
				if(p1.equals(p)){
					return i;
				}
			}catch(Exception e){
				
			}
		}
		return -1;
	}
	
	private void buscarProveedor(){
		System.out.println("Introduzca el nombre del proveedor");
		String nombre=new Scanner(System.in).nextLine();
		int pos=buscarProveedor(nombre);
		if(pos==-1){
			System.out.println("No existe proveedor con nombre "+nombre);
			return;
		}
		System.out.println("el proveedor buscado es");
		System.out.println((Proveedor)proveedores.elementAt(pos));
	}

	private void modificarProveedor(){
		System.out.println("Introduzca el nombre del proveedor a modificar");
		String nombre=new Scanner(System.in).nextLine();
		int pos=buscarProveedor(nombre);
		if(pos==-1){
			System.out.println("No existe proveedor con nombre "+nombre);
			return;
		}
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduzca el nombre");
		nombre=teclado.nextLine();
		System.out.println("Introduzca la dirección");
		String direccion=teclado.nextLine();
		System.out.println("Introduzca el teléfono");
		String telefono=teclado.nextLine();
		
		Proveedor p=new Proveedor(pos, nombre, direccion,telefono);
		proveedores.setElementAt(p,pos);
	}
	
	private void borrarProveedor(){
		System.out.println("Introduzca el nombre del proveedor a borrar");
		String nombre=new Scanner(System.in).nextLine();
		int pos=buscarProveedor(nombre);
		if(pos==-1){
			System.out.println("No existe proveedor a borrar");
			return;
		}
		
		proveedores.remove(pos);
		
	}
	
	private void comprarProveedor(boolean comprar){
		Proveedor p;
		System.out.println("Introduzca el nombre del proveedor al que realizar compra");
		String nombre=new Scanner(System.in).nextLine();
		int pos=buscarProveedor(nombre);
		if(pos==-1){
			System.out.println("No existe proveedor al que comprar o devolver");
			return;
		}
		if(comprar){
			System.out.println("Introduzca el importe a Comprar");
			double importe=new Scanner(System.in).nextDouble();
			p=(Proveedor)proveedores.elementAt(pos);
			p.setTotal(importe);
			proveedores.setElementAt(p, pos);
		}else{
			System.out.println("Introduzca el importe a Devolver");
			double importe=new Scanner(System.in).nextDouble();
			((Proveedor)proveedores.elementAt(pos)).setTotal(-importe);
		}
		
		
	}
	
	private void totalDeuda(){
		Proveedor p;
		double total=0;
		for(int i=10000;i<genCodigo;i++){
			p=(Proveedor)proveedores.elementAt(i);
			if(p!=null){
				System.out.println(p.getNombre()+"-->"
						+p.getTotal()+" €");
				total=total+p.getTotal();
			}
		}
		
		System.out.println("---------------------");
		System.out.println("Total------->"+total+" €");
	}
	
	public void menu(){
		int opcion=-1;
		
		do{
			System.out.println("\n");
			System.out.println("1.Nuevo Proveedor");
			System.out.println("2.Listar Proveedores");
			System.out.println("3.Buscar Proveedor");
			System.out.println("4.Modificar Proveedor");
			System.out.println("5.Borrar Proveedor");
			System.out.println("6.Comprar a Proveedor");
			System.out.println("7.Devolver a Proveedor");
			System.out.println("8.Total Deuda");
			System.out.println("0.Salir");
			System.out.println("Elija una opcion:");
			System.out.println("\n");
			
			try{
				opcion=new Scanner(System.in).nextInt();
			}catch(InputMismatchException e){
				new Scanner(System.in).nextLine();
			}
	
			switch (opcion) {
			case 0:
				System.out.print("Adios!!!");
				break;
			case 1:
				this.nuevoProveedor();
				break;
			case 2:
				this.listarProveedor();
				break;
			case 3:
				this.buscarProveedor();
				break;
			case 4:
				this.modificarProveedor();
				break;
			case 5:
				this.borrarProveedor();
				break;
			case 6:
				this.comprarProveedor(true);
				break;
			case 7:
				this.comprarProveedor(false);
				break;
			case 8:
				this.totalDeuda();
				break;
			default:
				System.out.println("Debe selecionar 0, 1, 2, 3, 4, 5, 6, 7 u 8");
				System.out.println("Vuelva a intentarlo");
				break;
			}
			
		}while(opcion!=0);
	}
}
