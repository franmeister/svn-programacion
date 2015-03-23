package teoria;
import javax.swing.*;

public class HolaMundoSwing {
	public static void main(String[] args) {
		JFrame frame = new JFrame("HolaMundoSwing");
		JLabel label = new JLabel("Hola Mundo");
		frame.getContentPane().add(label);
		frame.pack();
		frame.setVisible(true);
		
	}
}
