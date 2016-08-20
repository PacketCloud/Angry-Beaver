package engine;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;

import entities.EntityPlayer;

/*
 * LevelHandler holds the game loop. It also holds the current level
 * and takes in keyboard inputs.
 */
public class LevelHandler extends JPanel implements KeyListener {
	MainRuntime mrt;
	Level currentLevel = null;
	boolean isRunning = true;
	
	public LevelHandler(MainRuntime mrt, int width, int height) {
		setMrt(mrt);
		// loadLevel("mainmenu");
		this.addKeyListener(this);
		this.setFocusable(true);
		currentLevel = new Level(this);
		// This should be done while loading the level instead of here. Temp solution instead of FileUtility
		EntityPlayer player = new EntityPlayer(new Point(0,0), new Vector(2), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0);
		currentLevel.setPlayer(player);
	}
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(1280, 720);
	}

	// This is the game loop
	// TODO: FPS handling?
	public void runLoop() {
        while(isRunning)
        {
        	try{
        		repaint();
        		currentLevel.updateLevel();
        		repaint();
        		// Delay game loop
        		Thread.sleep(20);
        	} catch (Exception e) {
        		System.out.println(e);
        	}
        }
	}

	@Override
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponents(g);
		currentLevel.drawLevel((Graphics2D) g);
	}
	
	public void setMrt(MainRuntime mrt) {
		this.mrt = mrt;
	}
	
	public MainRuntime getMrt() {
		return mrt;
	}
	
	public Level getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}

	public void loadLevel(String levelName) {
		//TODO Load level 
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		Point point = currentLevel.getPlayer().getPosition();
		if(key == KeyEvent.VK_UP) {
			point.move(point.x, point.y - 5);
		} if(key == KeyEvent.VK_DOWN) {
			point.move(point.x, point.y + 5);
		} if(key == KeyEvent.VK_RIGHT) {
			point.move(point.x + 5, point.y);
		} if(key == KeyEvent.VK_LEFT) {
			point.move(point.x - 5, point.y);
		}
		currentLevel.getPlayer().setPosition(point);
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
