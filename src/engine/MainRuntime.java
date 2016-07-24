package engine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.*;

/* Brief: MainRuntime is the class which will initialize
 * 		a window and the game loop. Images will be drawn
 * 		inside the window and updated by the game loop.
 */
public class MainRuntime {
	
	// This is a list of Entities which can be used to track all
	// entities in the game.
	public final GameFrame game;
	private ArrayList<Entity> entityList = new ArrayList<Entity>();
	
	public static void main(String[] args) {
		// Opens a 1080x720 window to start the game
		MainRuntime gameWindow = new MainRuntime();
		game = new GameFrame("Angry-Beaver", 1080, 720);
	}
	
//	
//	// Draw a blank Graphics, then update and
//	// draw the next movement.
//	public void draw() {
//		Graphics g = getGraphics();
//		g.setColor(Color.WHITE);
//		g.fillRect(0, 0, 1080, 720);
//		
//		g.setColor(Color.RED);
//		g.fillRect(x, y, 100, 100);
//	}
//
//	// Currently this moves the box
//	@Override
//	public void keyPressed(KeyEvent e) {
//		int key = e.getKeyCode();
//		if(key == KeyEvent.VK_UP) {
//			y -= 5;
//		} if(key == KeyEvent.VK_DOWN) {
//			y += 5;
//		} if(key == KeyEvent.VK_RIGHT) {
//			x += 5;
//		} if(key == KeyEvent.VK_LEFT) {
//			x -= 5;
//		}
//		repaint();
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
}
