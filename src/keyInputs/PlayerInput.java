package keyInputs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import engine.LevelHandler;

/*
 * 	PlayerInput passes the KeyBoard stroke to the LevelHandler.
 * 		The gameState of the LevelHandler will define how the stroke
 * 		will be handled when passed.
 */
public class PlayerInput extends AbstractAction{
	public LevelHandler handle;
	public String actionType;
	
	public PlayerInput(LevelHandler h, String actionType) {
		this.handle = h;
		this.actionType = actionType;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		handle.keyPressed(actionType);
	}

}
