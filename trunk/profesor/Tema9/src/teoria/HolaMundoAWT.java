package teoria;
import java.awt.*;

public class HolaMundoAWT {

	public static void main(String[] args) {
		Frame frame = new Frame("HolaMundoAWT");
		Label label = new Label("Hola Mundo");
		frame.add(label);
		frame.pack();
		frame.setVisible(true);
	}
}
