package engine;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.util.Vector;

import entities.*;

/* MainRuntime is the class which will initialize
 * 	a window and the game loop. Images will be drawn
 * 	inside the window and updated by the game loop.
 */
public class MainRuntime extends JFrame implements KeyListener {

	// This is a list of Entities which can be used to track all
	// entities in the game.
	Level level = null;
	BufferedImage buffer;
	
	public static void main(String[] args) {
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
		
		level = new Level(this);
		// This should be done while loading the level instead of here. Temp solution instead of FileUtility
		EntityPlayer player = new EntityPlayer(new Point(0,0), new Vector(2), title, title, height, height, height, height, height, height, height, height, height);
		level.setPlayer(player);
		buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		
		//level.setLevelSetting(new LevelSettings(200, 800, 500, 2));
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
		Graphics2D g2 = (Graphics2D) buffer.getGraphics();
		level.updateLevel();
		level.drawLevel(g2);
		g.drawImage(buffer, 0, 0, this);
	}
	
	public void loadLevel(String levelName) {
		//TODO: Go to FileUtility to load a new level
	}

	// Currently this moves the box
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		Point point = level.getPlayer().getPosition();
		if(key == KeyEvent.VK_UP) {
			point.move(point.x, point.y - 5);
		} if(key == KeyEvent.VK_DOWN) {
			point.move(point.x, point.y + 5);
		} if(key == KeyEvent.VK_RIGHT) {
			point.move(point.x + 5, point.y);
		} if(key == KeyEvent.VK_LEFT) {
			point.move(point.x - 5, point.y);
		}
		level.getPlayer().setPosition(point);
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
