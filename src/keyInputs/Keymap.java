package keyInputs;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import engine.*;

public class Keymap {

	public LevelHandler handle;
	
	public Keymap(LevelHandler handle) {
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
		inputMap.put(KeyStroke.getKeyStroke("D"), ACTIONS.THROW);
	}
	
	private void initActions(ActionMap actionMap) {
		//TODO: Pass the input handling to the LevelHandler.GameState class to deal with
		actionMap.put(ACTIONS.MOVE_UP, new PlayerInput(handle,ACTIONS.MOVE_UP));
		actionMap.put(ACTIONS.MOVE_DOWN, new PlayerInput(handle,ACTIONS.MOVE_DOWN));
		actionMap.put(ACTIONS.MOVE_RIGHT, new PlayerInput(handle,ACTIONS.MOVE_RIGHT));
		actionMap.put(ACTIONS.MOVE_LEFT, new PlayerInput(handle,ACTIONS.MOVE_LEFT));
		
		actionMap.put(ACTIONS.R_MOVE_UP, new PlayerInput(handle,ACTIONS.R_MOVE_UP));
		actionMap.put(ACTIONS.R_MOVE_DOWN, new PlayerInput(handle,ACTIONS.R_MOVE_DOWN));
		actionMap.put(ACTIONS.R_MOVE_RIGHT, new PlayerInput(handle,ACTIONS.R_MOVE_RIGHT));
		actionMap.put(ACTIONS.R_MOVE_LEFT, new PlayerInput(handle,ACTIONS.R_MOVE_LEFT));
		
		actionMap.put(ACTIONS.PAUSE, new PlayerInput(handle,ACTIONS.PAUSE));
		
		actionMap.put(ACTIONS.JUMP, new PlayerInput(handle,ACTIONS.JUMP));
		actionMap.put(ACTIONS.ATTACK, new PlayerInput(handle,ACTIONS.ATTACK));
		actionMap.put(ACTIONS.THROW, new PlayerInput(handle,ACTIONS.THROW));
	}
}
