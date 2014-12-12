package r1;

public class Ejercicio1 {

	public static void main(String[] args) {
		int i=1,j=2;
		boolean b=true;
		if ((i==0)&&(b=(j==0))) { }
		System.out.println(b);
	}

}
/*Crear una clase Java y en su método main escribir:
int i=1,j=2;
boolean b=true;
if ((i==0)&&(b=(j==0))) { }
System.out.println(b);
a. Compile y ejecute el programa y compruebe que escribe "true".
b. Sustituir && por &.
c. Compile y ejecute el programa y compruebe que escribe "false".
d. Escriba una explicación de porqué aunque los operadores && y &
significan lo mismo el programa produce diferentes resultados.

-- && hace que si la primera comparación es falsa, la segunda no se verifique, asi
que el valor de "b" no varía al no llegar a (b=(j==0)), 
en cambio con & la segunda si se comprueba, en este caso (b=(j==0)) hace que la 
variable "b" sea "false" debido a que "j" no es 0   */