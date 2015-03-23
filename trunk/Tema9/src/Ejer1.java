import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ejer1 extends JFrame implements ActionListener {
	private JPanel ppal, p1, p2, p3;
	private Checkbox chR;
	private Checkbox chA;
	private Checkbox chV;
	private JCheckBox fr1;
	private JCheckBox fr2;
	private JCheckBox fr3;
	private JLabel la;
	

	public Ejer1(){
		this.setTitle("Ejercicio");
		ppal = new JPanel();
		p1 = new JPanel();
		ppal.setLayout(new GridLayout(2,1));
		p1.setLayout(new GridLayout(1,2));
		p2.setLayout(new GridLayout(3,1));
		p3.setLayout(new GridLayout(3,1));
		
		chR = new Checkbox("Rojo");
		chA = new Checkbox("Rojo");
		chZ = new Checkbox("Rojo");
		ppal.add(p1);
		ppal.add(p2);
		ppal.add(p3);
		this.add(ppal);
		this.pack();
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Apéndice de método generado automáticamente
		
	}

}
