package teoria;

import java.awt.event.*;

import javax.swing.*;

public class Menu extends JFrame implements ActionListener{
	JMenuBar mbarra;
	JMenuItem msalir,mayuda;
	
	public Menu() {
		this.setLocation(300, 200);
		InicializaMenus();
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setJMenuBar(mbarra);
		
		msalir.addActionListener(this);
		mayuda.addActionListener(this);

	}
	
	private void InicializaMenus() { 
		mbarra = new JMenuBar();
		JMenu m = new JMenu( "Archivo" ); 
		m.add( new JMenuItem( "Nuevo") );
		m.add( new JMenuItem( "Abrir") ); 
		m.add( new JMenuItem( "Guardar") );
		m.add( new JMenuItem( "Guardar como") );
		m.add( new JMenuItem( "Imprimir") );
		m.addSeparator(); 
		msalir=new JMenuItem( "Salir");
		m.add( msalir );
		mbarra.add( m ); 
		m = new JMenu( "Ayuda" );
		mayuda=new JMenuItem( "Ayuda!" );
		m.add( mayuda ); 
		m.addSeparator();
		m.add( new JMenuItem( "Acerca de..." ) ); 
		mbarra.add( m );
	} 

	public static void main(String[] args) {
		new Menu();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(msalir)){
			System.exit(0);
		}
		
	}

}
