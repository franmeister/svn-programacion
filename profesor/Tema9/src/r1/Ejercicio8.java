package relacion1;

import teoria.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class Ejercicio8 extends JFrame implements ActionListener{
	JMenuBar mbarra;
	JMenuItem msalir,mejercicio7,mlistas,mcolores;
	
	public Ejercicio8() {
		this.setLocation(300, 200);
		this.setSize(300, 300);
		InicializaMenus();
		JLabel texto=new JLabel("MENÚ");
		texto.setFont(new Font("Arial", Font.BOLD, 44));
		JPanel principal=new JPanel();
		principal.add(texto);
		
		this.add(principal);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setJMenuBar(mbarra);
		
		msalir.addActionListener(this);
		mejercicio7.addActionListener(this);
		mlistas.addActionListener(this);
		mcolores.addActionListener(this);
		
	}
	
	private void InicializaMenus() { 
		mbarra = new JMenuBar();
		JMenu m = new JMenu( "Archivo" ); 
		
		mejercicio7=new JMenuItem( "Ejercicio7");
		m.add( mejercicio7 );
		
		mlistas=new JMenuItem( "Listas"); 
		m.add(mlistas );
		
		mcolores=new JMenuItem( "Seleccion de Colores");
		m.add( mcolores );
		
		m.addSeparator(); 
		
		msalir=new JMenuItem( "Salir");
		m.add( msalir );
		mbarra.add( m ); 
	} 

	public static void main(String[] args) {
		new Ejercicio8();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(msalir)){
			System.exit(0);
		}
		if(e.getSource().equals(mejercicio7)){
			new Ejercicio7();
		}
		if(e.getSource().equals(mlistas)){
			new Listas();
		}
		if(e.getSource().equals(mcolores)){
			new SeleccionColores();
		}
		
		
	}

	
}
