package r1;

import java.awt.List;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;

import javax.swing.*;

public class Ejercicio3 extends JFrame{ //implements ItemListener{
	private List planetas;
	private JPanel ppal;
	
	public Ejercicio3(){
		this.setTitle("Ejercicio 3");
		ppal = new JPanel();
		
		planetas = new List(8, true);
		planetas.addItem("Venus");
		planetas.addItem("Mercurio");
		planetas.addItem("Marte");
		planetas.addItem("Tierra"); 
		planetas.addItem("Júpiter"); 
		planetas.addItem("Saturno"); 	
		planetas.addItem("Urano"); 
		planetas.addItem("Neptuno"); 
		ppal.add(planetas);
		
		this.add(ppal);
		this.pack();
		this.setVisible(true);
	}

//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		if(e.getItemSelectable().equals(new Object())){}
//		
//	}
}
