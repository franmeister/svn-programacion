package relacion1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Ejercicio7 extends JFrame implements KeyListener{
	private JTextField area;
	private JButton boton;
	
	public Ejercicio7(){
		area=new JTextField();
		boton=new JButton("Aceptar");
		boton.setEnabled(false);
		area.addKeyListener(this);
		
		JPanel principal=new JPanel();
		principal.setLayout(new GridLayout(2,1));
		
		principal.add(area);
		principal.add(boton);
		
		this.add(principal);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Ejercicio7();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Apéndice de método generado automáticamente
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(area.getText().equals("")){
			boton.setEnabled(false);
		}else{
			boton.setEnabled(true);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Apéndice de método generado automáticamente
		
	}

}
