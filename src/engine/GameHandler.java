package engine;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

import entities.*;
import keyInputs.*;
import resourceHandling.Resource;
import resourceHandling.ResourceCollection;
import states.gameState.*;

/*
 * LevelHandler holds the game loop. It also holds the current level
 * and takes in keyboard inputs.
 */
public class GameHandler extends JPanel {
	
	public MainRuntime mrt;
	public GameStateContext state;
	public Keymap keymap;
	
	public int maxFPS;
	
	public GameHandler() {
		this.setFocusable(true);
		this.state = new GameStateContext(this);
		setKeymap(new Keymap(this));
		maxFPS = MainRuntime.getSettings().getMaxFPS();
	}

	public void keyPressed(String actionType) {
		getGameState().userInput(actionType);
	}
	
	// This is the game loop
	public void runLoop() {
        do
        {
        	try{
                long fps = 1000 / maxFPS;
                // Start time of updating the game
                long startTime = System.nanoTime() / 1000000;

                // Update game state and draw
        		getGameState().update();
        		repaint();

                // End time of updating the game
        		long endTime = System.nanoTime() / 1000000 - startTime;

                // Time left over
                long sleepTime = fps - endTime;

                if (sleepTime > 0) {
            		Thread.sleep(sleepTime);
                }
                
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

	public int getMaxFPS() {
		return maxFPS;
	}
}
