import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainRuntime extends JPanel {

	public static void main(String[] args) {
		// Opens a 1920x1080 window to start the game
		JFrame frame = new JFrame();
		MainRuntime mrt = new MainRuntime();
		frame.add(mrt);
		frame.setSize(1280, 720);
		frame.setResizable(false);
		frame.setVisible(true);

		frame.update(frame.getGraphics());
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setColor(Color.BLUE);

		g2D.fillRect(0, 0, 100, 100);
		g2D.drawRect(0, 0, 100, 100);
	}

}
