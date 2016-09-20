package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import entities.*;
import keyInputs.*;

/*
 * LevelHandler holds the game loop. It also holds the current level
 * and takes in keyboard inputs.
 */
public class LevelHandler extends JPanel {
	public MainRuntime mrt;
	public Level currentLevel = null;
	public boolean isRunning = true;
	public boolean isPaused = false;
	public Dimension windowSize;
	public Keymap keymap;
	
	public LevelHandler(MainRuntime mrt, Dimension windowSize) {
		setWindowSize(windowSize);
		setMrt(mrt);
		//this.addKeyListener(this);
		this.setFocusable(true);
		setCurrentLevel(loadLevel("Temp"));
		
		setKeymap(new Keymap(this));
		//TODO: Multiple Key Input Class
	}
	
	public void setWindowSize(Dimension windowSize) {
		this.windowSize = windowSize;
	}
	
	public Dimension getWindowSize() {
		return windowSize;
	}
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return getWindowSize();
	}

	// This is the game loop
	// TODO: FPS handling?
	public void runLoop() {
        while(isRunning)
        {
        	try{
        		if(!isPaused) {
	        		repaint();
	        		getKeymap().updatePlayerActions(currentLevel);
	        		getCurrentLevel().updateLevel();
	        		repaint();
	        		System.out.println("Running");
        		} else {
        			// Temporary pause functionality
        			// TODO: Pause Menu
        			Graphics2D g = (Graphics2D) this.getGraphics();
        			g.setColor(Color.WHITE);
        			g.scale(5, 5);
        			g.drawString("Paused", 100, 100);
    	        	System.out.println("Paused");
    	        }
        		//TODO: FPS handling?
        		Thread.sleep(20);
        	} catch (Exception e) {
	        	System.out.println(e);
	        	isRunning = !isRunning;
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

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Keymap getKeymap() {
		return keymap;
	}

	public void setKeymap(Keymap keymap) {
		this.keymap = keymap;
	}

	public Level loadLevel(String levelName) {
		Level level = new Level(this);
		// This should be done while loading the level instead of here. Temp solution instead of FileUtility
		Platform platform = new Platform(new Hitbox(new Point(150, 600), 50, 800));
		EntityStatus status = new EntityStatus(new Hitbox(new Point(0,0), 100, 100));
		EntityPlayer player = new EntityPlayer(status);
		//EntityPlayer player = new EntityPlayer(new Point(0,0), new Vector(2), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		//
		level.addPlatform(platform);
		level.setPlayer(player);
		return level;
	}
}
