package teoria;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SeleccionColores extends JFrame implements AdjustmentListener{
	
	JScrollBar rojo,verde,azul;
	JTextArea cuadro;
	JLabel l_cuadro;
	Color c;
	
	public SeleccionColores() {
		JPanel principal=new JPanel();
		principal.setLayout(new GridLayout(2,1));
		
		JPanel psuperior=new JPanel();
		psuperior.setLayout(new GridLayout(2,1));
		JPanel pinferior=new JPanel();
		pinferior.setLayout(new GridLayout(3,1));
		
		cuadro=new JTextArea(4, 30);
		psuperior.add(cuadro);
		l_cuadro=new JLabel("etiqueta");
		psuperior.add(l_cuadro);
		l_cuadro.setOpaque(true);
		
		rojo=new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 255);
		verde=new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 255);
		azul=new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 255);
		pinferior.add(rojo);
		pinferior.add(verde);
		pinferior.add(azul);
		
		rojo.addAdjustmentListener(this);
		verde.addAdjustmentListener(this);
		azul.addAdjustmentListener(this);
		
		c=new Color(0, 0, 0);
		
		cuadro.setBackground(c);
		
		
		principal.add(psuperior);
		principal.add(pinferior);
		this.add(principal);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setLocation(300, 150);
	}

	public static void main(String[] args) {
		new SeleccionColores();

	}


	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		c=new Color(rojo.getValue(),verde.getValue(),azul.getValue());
		cuadro.setBackground(c);
		l_cuadro.setBackground(c);
		
	}

}
