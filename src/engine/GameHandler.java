package engine;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

import ResourceHandling.ResourceCollection;
import ResourceHandling.Resource;
import entities.*;
import keyInputs.*;
import states.gameState.*;

/*
 * LevelHandler holds the game loop. It also holds the current level
 * and takes in keyboard inputs.
 */
public class GameHandler extends JPanel {
	
	public MainRuntime mrt;
	public GameStateContext state;
	public Keymap keymap;
	
	public GameHandler() {
		this.setFocusable(true);
		this.state = new GameStateContext(this);
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
        		repaint();
        		Thread.sleep(20);
        	} catch (Exception e) {
	        	System.out.println(e);
	        	state.setGameState(new GameStateStop(state));;
        	}
        } while(!(getGameState().getState() instanceof states.gameState.GameStateStop));
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
		
		return MainRuntime.getSettings().getWindowSize();
	}
	
	public GameStateContext getGameState() {
		return state;
	}

	public Keymap getKeymap() {
		return keymap;
	}

	public void setKeymap(Keymap keymap) {
		this.keymap = keymap;
	}
}
