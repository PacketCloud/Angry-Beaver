import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class MainRuntime {

	public static void main(String[] args) {
		// Opens a 1920x1080 window to start the game
		JFrame frame = new JFrame();
		frame.setSize(1280, 720);
		frame.setVisible(true);
		/*
		Graphics graphics = frame.getGraphics();
		graphics.setColor(Color.BLUE);
		graphics.drawRect(0, 0, 100, 100);
		graphics.fillRect(0, 0, 100, 100);
		frame.update(graphics);
		*/
	}

}
