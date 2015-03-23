package teoria;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.*;

public class BotonesCheck extends JFrame implements ActionListener,ItemListener{

	JCheckBox af_lectura;
	JCheckBox af_cine;
	JCheckBox af_deporte;
	Checkbox hombre;
	Checkbox mujer;
	CheckboxGroup sexo;
	JTextArea resumen;
	
	public BotonesCheck() {
		af_lectura=new JCheckBox("Lectura");
		af_cine=new JCheckBox("cine");
		af_deporte=new JCheckBox("deporte");
		
		JPanel principal=new JPanel();
		principal.setLayout(new GridLayout(3,1));
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(3,1));
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(1,2));
		JPanel p3=new JPanel();

		Border bordep1 = new TitledBorder(new EtchedBorder(), "Aficiones");
        p1.setBorder(bordep1); 
		p1.add(af_lectura);
		p1.add(af_cine);
		p1.add(af_deporte);
		af_lectura.addActionListener(this);
		af_cine.addActionListener(this);
		af_deporte.addActionListener(this);
		
		sexo=new CheckboxGroup();
		hombre =new Checkbox("Hombre",sexo,false);
		mujer=new Checkbox("Mujer",sexo, true);

		
		Border bordep2 = new TitledBorder(new EtchedBorder(), "Sexo");
        p2.setBorder(bordep2); 
		p2.add(hombre);
		p2.add(mujer);
		
		hombre.addItemListener(this);
		mujer.addItemListener(this);
		
		resumen=new JTextArea(4, 30);
		resumen.setEditable(false);
		resumen.setBackground(Color.BLUE);
		resumen.setForeground(Color.red);
		
		JScrollPane scroll = new JScrollPane(resumen);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //p3.add(resumen);
		p3.add(scroll);
		
		principal.add(p1);
		principal.add(p2);
		principal.add(p3);
		this.add(principal);
		this.pack();
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BotonesCheck();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		crearCadena();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		crearCadena();
	}
	
	private void crearCadena(){
		String cadena="";
		if(af_lectura.isSelected()){
			cadena+="Lectura,";
		}
		if(af_cine.isSelected()){
			cadena+="Cine,";
		}
		if(af_deporte.isSelected()){
			cadena+="Deporte";
		}

		cadena+="\n"+sexo.getSelectedCheckbox().getLabel();

		resumen.setText(cadena);
	}

}
