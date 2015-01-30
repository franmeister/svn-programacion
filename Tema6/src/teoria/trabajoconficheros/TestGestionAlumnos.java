package teoria.trabajoconficheros;


public class TestGestionAlumnos {

	public static void main(String[] args){		
		//GestionAlumnos ga=new GestionAlumnos("C:\\Users\\usuario\\Documents\\cursos\\DAW\\PRO\\svn-programacion\\Tema6\\src\\teoria\\trabajoconficheros\\registro.txt");
		GestionAlumnos_enClase ga=new GestionAlumnos_enClase("E:\\Users\\USUARIO\\Desktop\\svnJava\\Tema6\\src\\teoria\\trabajoconficheros\\registro.txt");
		//GestionAlumnos_enClase ga=new GestionAlumnos_enClase("C:\\Users\\usuario\\Documents\\cursos\\DAW\\PRO\\svn-programacion\\Tema6\\src\\teoria\\trabajoconficheros\\registro.txt");

		
		ga.menu();

	}

}
