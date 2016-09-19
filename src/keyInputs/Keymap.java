package keyInputs;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import engine.*;

public class Keymap {

	private LevelHandler handle; 
	private final String MOVE_UP = "move_up";
	private final String MOVE_DOWN = "move_down";
	private final String MOVE_RIGHT = "move_right";
	private final String MOVE_LEFT = "move_left";
	private final String PAUSE = "pause";
	
	private final String R_MOVE_UP = "r_move_up";
	private final String R_MOVE_DOWN = "r_move_down";
	private final String R_MOVE_RIGHT = "r_move_right";
	private final String R_MOVE_LEFT = "r_move_left";
	private int moveX = 0;
	private int moveY = 0;
	
	public Keymap(LevelHandler handle) {
		initInputs(handle.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW));
		initActions(handle.getActionMap());
		this.handle = handle;
	}
	
	private void initInputs(InputMap inputMap) {
		inputMap.put(KeyStroke.getKeyStroke("UP"), MOVE_UP);
		inputMap.put(KeyStroke.getKeyStroke("DOWN"), MOVE_DOWN);
		inputMap.put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);
		inputMap.put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
		
		inputMap.put(KeyStroke.getKeyStroke("released UP"), R_MOVE_UP);
		inputMap.put(KeyStroke.getKeyStroke("released DOWN"), R_MOVE_DOWN);
		inputMap.put(KeyStroke.getKeyStroke("released RIGHT"), R_MOVE_RIGHT);
		inputMap.put(KeyStroke.getKeyStroke("released LEFT"), R_MOVE_LEFT);
		
		inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), PAUSE);
	}
	
	private void initActions(ActionMap actionMap) {
		//TODO: Pass the movement handling to the Entity class
		actionMap.put(MOVE_UP, new MovementAction(this, null, -5));
		actionMap.put(MOVE_DOWN, new MovementAction(this, null, 5));
		actionMap.put(MOVE_RIGHT, new MovementAction(this, 5, null));
		actionMap.put(MOVE_LEFT, new MovementAction(this, -5, null));
		
		actionMap.put(R_MOVE_UP, new MovementAction(this, null, 0));
		actionMap.put(R_MOVE_DOWN, new MovementAction(this, null, 0));
		actionMap.put(R_MOVE_RIGHT, new MovementAction(this, 0, null));
		actionMap.put(R_MOVE_LEFT, new MovementAction(this, 0, null));
		
		actionMap.put(PAUSE, new PauseAction(this));
	}
	
	public int getMoveX() {
		return moveX;
	}
	
	public void setMoveX(int moveX) {
		this.moveX = moveX;
	}

	public int getMoveY() {
		return moveY;
	}
	
	public void setMoveY(int moveY) {
		this.moveY = moveY;
	}
	
	public void updatePlayerActions(Level level) {
		Point point = level.getPlayer().getStatus().getHitbox().getPosition();
		point.translate(getMoveX(), getMoveY());
	}
	
	public void pause() {
		handle.isPaused = !handle.isPaused;
		System.out.println(handle.isPaused);
	}
}
