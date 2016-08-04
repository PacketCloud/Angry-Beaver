package engine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

import entities.*;

/* MainRuntime is the class which will initialize
 * 	a window and the game loop. Images will be drawn
 * 	inside the window and updated by the game loop.
 */
public class MainRuntime extends JFrame implements KeyListener {

	// This is a list of Entities which can be used to track all
	// entities in the game.
	Level level = Level.getInstance();
	
	public static void main(String[] args) {
		// Opens a 1080x720 window to start the game
		MainRuntime gameWindow = new MainRuntime();
		gameWindow.runLoop();
		System.exit(0);
	}
	
	// This initializes the game settings. We can later save
	// User settings in a file to read and set them here
	public void init(String title, int width, int height) {

		this.setTitle(title);
		this.setSize(width, height);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(this);
		// This should be done while loading the level instead of here. Temp solution instead of FileUtility
		EntityPlayer player = new EntityPlayer(new Point(0,0), title, title, height, height, height, height, height, height, height, height, height);
		level.setPlayer(player);
	}
	
	// This is the game loop
	// TODO: FPS handling?
	public void runLoop() {
		init("Angry-Beaver", 1280, 720);//will get resolution parameters from settings.cfg file in the future.
        while(true)
        {
        	try{
        		draw();
        		// Delay game loop
        		Thread.sleep(20);
        	} catch (Exception e) {
        		System.out.println(e);
        	}
        }
	}
	
	// Draw a blank Graphics, then update and
	// draw the next movement.
	public void draw() {
		Graphics2D g = (Graphics2D) getGraphics();
		level.updateLevel();
		level.drawLevel(g);
	}

	// Currently this moves the box
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		int y = (int) level.getPlayer().getPosition().getY();
		int x = (int) level.getPlayer().getPosition().getX();
		if(key == KeyEvent.VK_UP) {
			y -= 5;
		} if(key == KeyEvent.VK_DOWN) {
			y += 5;
		} if(key == KeyEvent.VK_RIGHT) {
			x += 5;
		} if(key == KeyEvent.VK_LEFT) {
			x -= 5;
		}
		
		level.getPlayer().setPosition(new Point(x,y));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
