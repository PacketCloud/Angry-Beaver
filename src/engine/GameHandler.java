package engine;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import fileUtility.Settings;
import keyInputs.*;
import states.gameState.*;

/**
 * Class GameHandler holds the game loop and the current state of the game
 */

public class GameHandler extends JPanel {
	
	private static final long serialVersionUID = -5336794019561227772L;
	public MainRuntime mrt;
	public GameStateContext state;
	public Keymap keymap;
	
	public int maxFPS;
	
	public GameHandler() {
		this.setFocusable(true);
		this.state = new GameStateContext(this);
		setKeymap(new Keymap(this));
		maxFPS = Settings.getInstance().getMaxFPS();
	}

	/**
	 * Method keyPressed takes in a String defined by class ACTIONS
	 * and treats this string as an input from the user. 
	 * Game State will handle the input.
	 * 
	 * @param actionType	A string defined by ACTIONS
	 */
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
		return Settings.getInstance().getWindowSize();
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
