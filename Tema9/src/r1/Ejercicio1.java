package r1;

import java.awt.GridLayout;
import javax.swing.*;

public class Ejercicio1 extends JFrame{
	public Ejercicio1(){
		this.setTitle("Ejercicio 1");
		
		JPanel ppal = new JPanel();
		ppal.setLayout(new GridLayout(2,1));
		
		JLabel l1=new JLabel("PRO");
		JLabel l2=new JLabel("1º DAW");
	
		ppal.add(l1);
		ppal.add(l2);
	
		this.add(ppal);
		this.pack();
		this.setVisible(true);
	}
}
