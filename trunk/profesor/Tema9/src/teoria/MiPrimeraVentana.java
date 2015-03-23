package teoria;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MiPrimeraVentana extends JFrame implements ActionListener{
	
	private JLabel l1,l2;
	private JTextField t1,t2;
	private JButton b1,b2;
	
	public MiPrimeraVentana(){
		this.setTitle("Mi primera ventana");
		
		l1=new JLabel("Nombre");
		l2=new JLabel("Apellidos");
		
		Color c=new Color(255,0,0);
		
		l1.setForeground(c);
		
		t1=new JTextField("          ");
		t1.addActionListener(this);
		
		t2=new JTextField("          ");
		Font f=new Font("Verdana", Font.BOLD, 20);
		
		//Boton b1
		b1=new JButton();
		b1.setText("Aceptar");
		b1.setFont(f);
		
		b2=new JButton("Salir");
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	/*	b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				t1.setText("Hola Antonio");
				
			}
		});
		*/
		
		
		JPanel principal=new JPanel();
		principal.setLayout(new GridLayout(1, 1));
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(3,2));

		//JPanel p2=new JPanel();
		//p2.setLayout(new GridLayout(1,2));

		this.add(principal);
		principal.add(p1);
		//principal.add(p2);
		
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(b1);
		p1.add(b2);
		
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Apéndice de método generado automáticamente
		if(e.getSource().equals(b1)){
			this.t1.setText("El boton pulado es: "+b1.getText());
		}else {
			System.exit(0);
		}
	}
	

}
