package keyInputs;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import engine.*;

/**
 * Class Keymap uses KeyBindings to declare keyboard strokes to an ACTIONS.
 * TODO: KeyBindings should be able to be changed
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
		inputMap.put(KeyStroke.getKeyStroke("released SPACE"), ACTIONS.R_JUMP);
		inputMap.put(KeyStroke.getKeyStroke("S"), ACTIONS.ATTACK);
		inputMap.put(KeyStroke.getKeyStroke("released S"), ACTIONS.R_ATTACK);
		inputMap.put(KeyStroke.getKeyStroke("D"), ACTIONS.ATTACK2);
		inputMap.put(KeyStroke.getKeyStroke("released D"), ACTIONS.R_ATTACK2);
	}
	
	private void initActions(ActionMap actionMap) {
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
		//actionMap.put(ACTIONS.R_JUMP, new PlayerInput(this,ACTIONS.R_JUMP));
		actionMap.put(ACTIONS.ATTACK, new PlayerInput(this,ACTIONS.ATTACK));
		actionMap.put(ACTIONS.R_ATTACK, new PlayerInput(this,ACTIONS.R_ATTACK));
		actionMap.put(ACTIONS.ATTACK2, new PlayerInput(this,ACTIONS.ATTACK2));
		actionMap.put(ACTIONS.R_ATTACK2, new PlayerInput(this,ACTIONS.R_ATTACK2));
	}
	
	public void inputAction(String actionType) {
		handle.keyPressed(actionType);
	}
}
