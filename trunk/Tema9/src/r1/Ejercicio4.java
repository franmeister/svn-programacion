package r1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ejercicio4 extends JFrame implements ActionListener{
	public Ejercicio4(){
		this.setTitle("Ejercicio 4");
		
		JPanel ppal = new JPanel();
		//ppal.setLayout(new GridLayout(1,2));
		JLabel l1 = new JLabel();
		JButton b1 = new JButton("Enviar");
		b1.addActionListener(this);
		ppal.add(b1);
		ppal.add(l1);

	
		this.add(ppal);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		l1.setText();
	}
}
