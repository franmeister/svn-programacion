package r1;

public class Fecha {
	private int dia;
	private int mes;
	private int ano;

	private boolean comprobarFecha(int dia, int mes){
		if((dia>31)||(mes>12)||(dia<1)||(mes<1)){
			System.out.println("Error en la fecha.");
			return false;
		}
		return true;
	}
	
	public void setFecha(int dia, int mes, int ano){
		if(comprobarFecha(dia,mes)){
			this.dia=dia;
			this.mes=mes;
			this.ano=ano;
		}
	}
	
	public void setDia(int dia){
		if(comprobarFecha(dia,10)){
			this.dia=dia;
		}
	}
	
	public void setMes(int mes){
		if(comprobarFecha(10,mes)){
			this.mes=mes;
		}
	}
	
	public void setAno(int ano){
			this.ano=ano;
	}
	
	public int getDia(){
		return this.dia;
	}
	
	public int getMes(){
		return this.mes;
	}
	
	public int getAno(){
		return this.ano;
	}
	
	public String toString(){
		return this.dia+"/"+this.mes+"/"+this.ano;
	}
	

}
/* Crear una clase fecha con los siguientes atributos:
a) int dia,mes,año: Todos ellos privados.
Los métodos públicos:
b) ModificarFecha
c) ModificarDia, ModificarMes, ModificarAño
d) DevoverDia,DevolverMes,DevolverAño
e) toString
Un método privado, que se llama al modificar:
f) ComprobarFecha: Que hace una comprobación simple:
1<dia<31 ; 1<mes<12: Si la fecha no es correcta se da un error y no
se cambia la fecha
*/
