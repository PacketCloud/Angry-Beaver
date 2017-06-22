package engine;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

import ResourceHandling.ResourceCollection;
import ResourceHandling.Resource;
import entities.*;
import keyInputs.*;
import states.gameState.GameState;

/*
 * LevelHandler holds the game loop. It also holds the current level
 * and takes in keyboard inputs.
 */
public class LevelHandler extends JPanel {
	
	public MainRuntime mrt;
	public Level currentLevel = null;
	public GameState state;
	public Dimension windowSize;
	public Keymap keymap;
	
	public LevelHandler(MainRuntime mrt, Dimension windowSize) {
		setWindowSize(windowSize);
		setMrt(mrt);
		this.setFocusable(true);
		setCurrentLevel(loadLevel("Temp"));
		this.state = new GameState(this);
		setKeymap(new Keymap(this));
	}

	public void keyPressed(String actionType) {
		getGameState().userInput(actionType);
	}
	
	// This is the game loop
	public void runLoop() {
        do
        {
        	try{        		
        		getGameState().update();
        		//TODO: FPS handling?
        		Thread.sleep(20);
        	} catch (Exception e) {
	        	System.out.println(e);
	        	getGameState().stateStop();
        	}
        } while(!(getGameState().getState() instanceof states.gameState.GameStateStop));
	}
	
	public Level loadLevel(String levelName) {
		Level level = new Level(windowSize);
		// This should be done using FileUtility instead of here. Temp solution instead of FileUtility
		Platform platform = new Platform(new Hitbox(new Point(150, 600), 50, 800));
		
		//This is temporary, should be done elsewhere as the level loads.
		ResourceCollection PlayerResourceCollection = new ResourceCollection("Player");
		PlayerResourceCollection.add(new Resource("Beaver Walking", "/Resources/Sprites/Player/Beaver_Walking.gif", (float) 2.5, null, true, "Walking"));
			
		Entity player = new Entity(new Point(0,0), new Hitbox(new Point(0,0), 50, 50), PlayerResourceCollection, -1, "Walking");
		
		level.addPlatform(platform);
		level.setPlayer(player);
		return level;
	}
	
	@Override
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponents(g);
		getGameState().render((Graphics2D) g);
	}
	
	/******** Getters and Setters ********/
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return getWindowSize();
	}
	public void setWindowSize(Dimension windowSize) {
		this.windowSize = windowSize;
	}
	
	public Dimension getWindowSize() {
		return windowSize;
	}

	public void setMrt(MainRuntime mrt) {
		this.mrt = mrt;
	}
	
	public GameState getGameState() {
		return state;
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

	public Keymap getKeymap() {
		return keymap;
	}

	public void setKeymap(Keymap keymap) {
		this.keymap = keymap;
	}
}
