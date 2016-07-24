package engine;

import javax.swing.JFrame;

public class GameFrame {
	
	private final JFrame frame = new JFrame();
	private final GameLoop loop;
	
	public GameFrame(String title, int width, int height) {

		frame.setTitle(title);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//frame.addKeyListener(this);
		frame.setLocationRelativeTo(null);
		loop = new GameLoop(this);
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
