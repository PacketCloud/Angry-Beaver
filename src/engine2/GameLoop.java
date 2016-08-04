package engine2;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GameLoop extends JPanel implements Runnable {
	
	private final GameFrame frame;
	
	public GameLoop(GameFrame frame) {
		this.frame = frame;
		setFocusable(true);
	}

	public void runLoop() {
        while(true) {
        	try{
        		// Delay game loop
        		Thread.sleep(20);
        	} catch (Exception e) {
        		System.out.println(e);
        	}
        }
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		this.repaint();
	}

	@Override
	public void run() {
		runLoop();
	}
	
}
