package r1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ejercicio4 extends JFrame implements ActionListener{
	private JPanel ppal;
	private JLabel l1,l2,l3,l4;
	private JTextField t1, t2, t3;
	private JButton b1;
	
	public Ejercicio4(){
		this.setTitle("Ejercicio 4");
		
		ppal = new JPanel();
		ppal.setLayout(new GridLayout(4,2));
		l2 = new JLabel("Nombre: ");
		l3 = new JLabel("Primer Apellido: ");
		l4 = new JLabel("Segundo Apellido: ");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		l1 = new JLabel();
		b1 = new JButton("Enviar");
		b1.addActionListener(this);
		ppal.add(l2);
		ppal.add(t1);
		ppal.add(l3);
		ppal.add(t2);
		ppal.add(l4);
		ppal.add(t3);
		ppal.add(l1);
		ppal.add(b1);

		this.add(ppal);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		l1.setText(t1.getText()+" "+t2.getText()+" "+t3.getText());
	}
}
