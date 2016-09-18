package engine;

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

/*
 * LevelHandler holds the game loop. It also holds the current level
 * and takes in keyboard inputs.
 */
public class LevelHandler extends JPanel {
	MainRuntime mrt;
	Level currentLevel = null;
	boolean isRunning = true;
	Dimension windowSize;
	
	public LevelHandler(MainRuntime mrt, Dimension windowSize) {
		setWindowSize(windowSize);
		setMrt(mrt);
		//this.addKeyListener(this);
		this.setFocusable(true);
		setCurrentLevel(loadLevel("Temp"));
		
		//TODO: Multiple Key Input Class
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "MOVE_UP");
		this.getActionMap().put("MOVE_UP", new MoveUp(currentLevel));
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "MOVE_RIGHT");
		this.getActionMap().put("MOVE_RIGHT", new MoveRight(currentLevel));
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "MOVE_LEFT");
		this.getActionMap().put("MOVE_LEFT", new MoveLeft(currentLevel));
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "MOVE_DOWN");
		this.getActionMap().put("MOVE_DOWN", new MoveDown(currentLevel));
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

	public Level loadLevel(String levelName) {
		Level level = new Level(this);
		// This should be done while loading the level instead of here. Temp solution instead of FileUtility
		Platform platform = new Platform(new Hitbox(new Point(0, 600), 50, 1280));
		EntityStatus status = new EntityStatus(new Hitbox(new Point(0,0), 100, 100));
		EntityPlayer player = new EntityPlayer(status);
		//EntityPlayer player = new EntityPlayer(new Point(0,0), new Vector(2), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		//
		level.addPlatform(platform);
		level.setPlayer(player);
		return level;
	}
}
