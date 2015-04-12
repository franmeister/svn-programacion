package R1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ejercicio10 extends JFrame implements ActionListener{
	private JTextField decimal = new JTextField(16);
    private JTextField romano   = new JTextField(16);
    private static File f, ftemp;
    
    public static void Fichero(){
    	String ruta="C:/Users/JuanAntonio/Documents/JAVA 1ºDAW/Ejercicios/Tema-9";
    	
    	f= new File(ruta,"ConversionNumero.txt");
    	
    	if (!f.exists()){
    		System.out.println("El fichero de trabajo de conversiones, no existe.");
    		System.exit(0);
    	}
    	
    	ftemp= new File(ruta,"temporal.txt");	
    }
    
    public static void escribirFichero(String decimal, String romano){
		try {
			Fichero();
			
			BufferedReader flectura=new BufferedReader(new FileReader(f));
			BufferedWriter fescritura=new BufferedWriter(new FileWriter(ftemp));
			String linea;
			while ((linea=flectura.readLine())!=null){
				fescritura.write(linea);
				fescritura.newLine();
			}
			flectura.close();	
			fescritura.write("Nº Decimal: "+ decimal);
			fescritura.newLine();
			fescritura.write("Nº Romano: "+ romano);
			fescritura.newLine();
			fescritura.write("------------------------");
			fescritura.newLine();
			fescritura.flush();
			fescritura.close();
			
			f.delete();
			ftemp.renameTo(f);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
    
    public static void main(String[] args) {
        new Ejercicio10();
    }
    
	public Ejercicio10() {
		JButton botonConvierte = new JButton("Convierte");
		JLabel l1=new JLabel("Número Decimal");
		JLabel l2=new JLabel("Número Romano");
		botonConvierte.addActionListener(this);
        decimal.addActionListener(this);
        romano.addActionListener(this);
        
        JPanel contenido = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        contenido.setLayout(new GridLayout(2,1));
        p1.setLayout(new GridLayout(2,2));
        p2.setLayout(new GridLayout(1,1));
        p1.add(l1);
        p1.add(decimal);
        p1.add(l2);
        p1.add(romano);
        p2.add(botonConvierte);
        contenido.add(p1);
        contenido.add(p2);
        
        this.setContentPane(contenido);
        this.setTitle("Mi decima ventana");
        this.pack();                       
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (decimal.getText().isEmpty() || decimal.getText().equals("")){
			String decimal = Romano.convertirDecimal(romano.getText(), romano.getText().length());
            this.decimal.setText(decimal);
            this.escribirFichero(decimal, romano.getText());
		}else{
			String romano = Romano.convertirRomano(decimal.getText());
	        this.romano.setText("" + romano);
	        this.escribirFichero(decimal.getText(), romano);
		}
	}
}

class Romano {

	static int saberDecimal(char n){
	    int nv=0;
 
	    switch(n)
	    {
	      case 'I':nv=1;break;
	      case 'V':nv=5;break;
	      case 'X':nv=10;break;
	      case 'L':nv=50;break;
	      case 'C':nv=100;break;
	      case 'D':nv=500;break;
	      case 'M':nv=1000;break;
	    };
	    //printf("%d,",nv);
	    return nv;
	}
 
	static String convertirDecimal(String r,int n){
		 int nume[]=new int [n];
		 int s=0,sig=0,act;
		 //Paso XXIV a 10,10,1,5
		 for(int i=0;i<n;i++)
		 {
		 	nume[i]=saberDecimal(r.charAt(i));
		 }
		 if(n%2==0)
		 {
		 	for(int i=0;i<n;i=i+2)
		 	{
		 		act=nume[i];
		 		sig=nume[i+1];
		 		if(act>=sig){
		 			s+=(act+sig);
		 		}else{
		 			s+=(sig-act);
		 		}
		 	}	
		 }else{
		 	for(int i=n-1;i>0;i=i-2)
		 	{
		 		act=nume[i];
		 		sig=nume[i-1];
		 		
		 		if(act>sig){
		 			s+=(act-sig);
		 		}else{
		 			s+=(sig+act);
		 		}
		 	}
 
		 	act=nume[0];
		 	if (act<s){
		 		s-=act;
		 	}else{
		 		s+=act;
		 	}
		 }
 
	     return String.valueOf(s);
	}
	
	static String saberRomano(int n){
	    String cadena = "";
	    
	    while(n>=1000){
	        cadena+="M";
	        n-=1000;
	    }
	    if(n>=900){
	        cadena+="CM";
	        n-=900;
	    }
	    if(n>=500){
	        cadena+="D";
	        n-=500;
	    }
	    if(n>=400){
	        cadena+="CD";
	        n-=400;
	    }
	    while(n>=100){
	        cadena+="C";
	        n-=100;
	    }
	    if(n>=90){
	        cadena+="XC";
	        n-=90;
	    }
	    if(n>=50){
	        cadena+="L";
	        n-=50;
	    }
	    if(n>=40){
	        cadena+="XL";
	        n-=40;
	    }
	    while(n>=10){
	        cadena+="X";
	        n-=10;
	    }
	    if(n>=9){
	        cadena+="IX";
	        n-=9;
	    }
	    if(n>=5){
	        cadena+="V";
	        n-=5;
	    }
	    if(n>=4){
	        cadena+="IV";
	        n-=4;
	    }
	    while(n>=1){
	        cadena+="I";
	        n-=1;
	    }
	    return cadena;  
	}
	
	static String convertirRomano(String numero){
		try {
			int n = Integer.parseInt(numero);
		    numero = saberRomano(n);
		    return numero;
        } catch (NumberFormatException ex) {
            return "Error";
        }
	}
}