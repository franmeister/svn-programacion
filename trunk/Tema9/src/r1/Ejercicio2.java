package r1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ejercicio2 extends JFrame implements ActionListener{
	public Ejercicio2(){
		this.setTitle("Ejercicio 2");
		
		JPanel ppal = new JPanel();
		//ppal.setLayout(new GridLayout(1,2));
		
		JButton b1 = new JButton("Cerrar");
		b1.addActionListener(this);
		ppal.add(b1);
	
		this.add(ppal);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
