package keyInputs;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import engine.*;

/*
 * 	Keymap uses KeyBindings to declare keyboard strokes to an ACTIONS.
 * 		In the future, we may add functionality to change KeyBindings
 * 		and save the changes in a file. 
 */
public class Keymap {

	public GameHandler handle;
	
	public Keymap(GameHandler handle) {
		this.handle = handle;
		initInputs(handle.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW));
		initActions(handle.getActionMap());
	}

	private void initInputs(InputMap inputMap) {
		inputMap.put(KeyStroke.getKeyStroke("UP"), ACTIONS.MOVE_UP);
		inputMap.put(KeyStroke.getKeyStroke("DOWN"), ACTIONS.MOVE_DOWN);
		inputMap.put(KeyStroke.getKeyStroke("RIGHT"), ACTIONS.MOVE_RIGHT);
		inputMap.put(KeyStroke.getKeyStroke("LEFT"), ACTIONS.MOVE_LEFT);
		
		inputMap.put(KeyStroke.getKeyStroke("released UP"), ACTIONS.R_MOVE_UP);
		inputMap.put(KeyStroke.getKeyStroke("released DOWN"), ACTIONS.R_MOVE_DOWN);
		inputMap.put(KeyStroke.getKeyStroke("released RIGHT"), ACTIONS.R_MOVE_RIGHT);
		inputMap.put(KeyStroke.getKeyStroke("released LEFT"), ACTIONS.R_MOVE_LEFT);
		
		inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), ACTIONS.PAUSE);
		
		inputMap.put(KeyStroke.getKeyStroke("SPACE"), ACTIONS.JUMP);
		inputMap.put(KeyStroke.getKeyStroke("S"), ACTIONS.ATTACK);
		inputMap.put(KeyStroke.getKeyStroke("released S"), ACTIONS.R_ATTACK);
		inputMap.put(KeyStroke.getKeyStroke("D"), ACTIONS.ATTACK2);
		
		inputMap.put(KeyStroke.getKeyStroke("0"), ACTIONS.NUM_0);
		inputMap.put(KeyStroke.getKeyStroke("1"), ACTIONS.NUM_1);
		inputMap.put(KeyStroke.getKeyStroke("2"), ACTIONS.NUM_2);
		inputMap.put(KeyStroke.getKeyStroke("3"), ACTIONS.NUM_3);
		inputMap.put(KeyStroke.getKeyStroke("4"), ACTIONS.NUM_4);
		inputMap.put(KeyStroke.getKeyStroke("5"), ACTIONS.NUM_5);
		inputMap.put(KeyStroke.getKeyStroke("6"), ACTIONS.NUM_6);
		inputMap.put(KeyStroke.getKeyStroke("7"), ACTIONS.NUM_7);
		inputMap.put(KeyStroke.getKeyStroke("8"), ACTIONS.NUM_8);
		inputMap.put(KeyStroke.getKeyStroke("9"), ACTIONS.NUM_9);
	}
	
	private void initActions(ActionMap actionMap) {
		//TODO: Pass the input handling to the LevelHandler.GameState class to deal with
		actionMap.put(ACTIONS.MOVE_UP, new PlayerInput(this,ACTIONS.MOVE_UP));
		actionMap.put(ACTIONS.MOVE_DOWN, new PlayerInput(this,ACTIONS.MOVE_DOWN));
		actionMap.put(ACTIONS.MOVE_RIGHT, new PlayerInput(this,ACTIONS.MOVE_RIGHT));
		actionMap.put(ACTIONS.MOVE_LEFT, new PlayerInput(this,ACTIONS.MOVE_LEFT));
		
		actionMap.put(ACTIONS.R_MOVE_UP, new PlayerInput(this,ACTIONS.R_MOVE_UP));
		actionMap.put(ACTIONS.R_MOVE_DOWN, new PlayerInput(this,ACTIONS.R_MOVE_DOWN));
		actionMap.put(ACTIONS.R_MOVE_RIGHT, new PlayerInput(this,ACTIONS.R_MOVE_RIGHT));
		actionMap.put(ACTIONS.R_MOVE_LEFT, new PlayerInput(this,ACTIONS.R_MOVE_LEFT));
		
		actionMap.put(ACTIONS.PAUSE, new PlayerInput(this,ACTIONS.PAUSE));
		
		actionMap.put(ACTIONS.JUMP, new PlayerInput(this,ACTIONS.JUMP));
		actionMap.put(ACTIONS.ATTACK, new PlayerInput(this,ACTIONS.ATTACK));
		actionMap.put(ACTIONS.R_ATTACK, new PlayerInput(this,ACTIONS.R_ATTACK));
		actionMap.put(ACTIONS.ATTACK2, new PlayerInput(this,ACTIONS.ATTACK2));
		
		actionMap.put(ACTIONS.NUM_0, new PlayerInput(this,ACTIONS.NUM_0));
		actionMap.put(ACTIONS.NUM_1, new PlayerInput(this,ACTIONS.NUM_1));
		actionMap.put(ACTIONS.NUM_2, new PlayerInput(this,ACTIONS.NUM_2));
		actionMap.put(ACTIONS.NUM_3, new PlayerInput(this,ACTIONS.NUM_3));
		actionMap.put(ACTIONS.NUM_4, new PlayerInput(this,ACTIONS.NUM_4));
		actionMap.put(ACTIONS.NUM_5, new PlayerInput(this,ACTIONS.NUM_5));
		actionMap.put(ACTIONS.NUM_6, new PlayerInput(this,ACTIONS.NUM_6));
		actionMap.put(ACTIONS.NUM_7, new PlayerInput(this,ACTIONS.NUM_7));
		actionMap.put(ACTIONS.NUM_8, new PlayerInput(this,ACTIONS.NUM_8));
		actionMap.put(ACTIONS.NUM_9, new PlayerInput(this,ACTIONS.NUM_9));
	}
	
	public void inputAction(String actionType) {
		handle.keyPressed(actionType);
	}
}
