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
a) int dia,mes,a�o: Todos ellos privados.
Los m�todos p�blicos:
b) ModificarFecha
c) ModificarDia, ModificarMes, ModificarA�o
d) DevoverDia,DevolverMes,DevolverA�o
e) toString
Un m�todo privado, que se llama al modificar:
f) ComprobarFecha: Que hace una comprobaci�n simple:
1<dia<31 ; 1<mes<12: Si la fecha no es correcta se da un error y no
se cambia la fecha
*/
