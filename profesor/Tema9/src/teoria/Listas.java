package teoria;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Listas extends JFrame implements ItemListener {
	private Choice selector;
	private JLabel etiqueta;
	
	public Listas() {
		JPanel principal=new JPanel();
		etiqueta=new JLabel("Color");
		
		selector=new Choice();
		selector.add("");
		selector.add("Rojo");
		selector.add("Verde");
		selector.add("Azul");
		
		selector.addItemListener(this);
		
		principal.add(etiqueta);
		principal.add(selector);
		
		this.add(principal);
		this.pack();
		this.setLocation(400, 200);
		this.setSize(100, 100);
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		new Listas();
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getItem().equals("Rojo")) {
			this.etiqueta.setForeground(Color.red);
		}
		if(e.getItem().equals("Verde")) {
			this.etiqueta.setForeground(Color.green);
		}
		if(e.getItem().equals("Azul")) {
			this.etiqueta.setForeground(Color.blue);
		}
		
	}



}
