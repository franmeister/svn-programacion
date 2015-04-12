package teoria;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class ListaModulos extends JFrame implements ActionListener, ItemListener{
	List lista;
	JTextArea area;
	
	public ListaModulos() {
		JPanel principal=new JPanel();
		
		lista=new List(4,true);
		lista.add("PRO");
		lista.add("BD");
		lista.add("LM");
		lista.add("ED");
		lista.add("SI");
		lista.add("FOL");
		
		//lista.addActionListener(this);
		lista.addItemListener(this);
		
		area=new JTextArea(4, 30);
		area.setBackground(Color.gray);
		area.setEnabled(false);
		principal.add(lista);
		principal.add(area);

		this.add(principal);
		this.pack();
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new ListaModulos();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		area.setText(lista.getSelectedItem());
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String cadena="";
		for(int i=0;i<lista.getSelectedItems().length;i++){
			cadena=cadena+lista.getSelectedItems()[i];
		}
		area.setText(cadena);
	}

}
